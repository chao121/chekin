package com.dayouzc.e2eapp.ebusiness.checkin.mvp.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dayouzc.e2e.core.AppUpdate;
import com.dayouzc.e2e.core.E2EAppClientContext;
import com.dayouzc.e2e.core.E2EContext;
import com.dayouzc.e2e.core.aop.annotation.Location;
import com.dayouzc.e2e.core.aop.annotation.OrganChoose;
import com.dayouzc.e2e.core.aop.annotation.UserLogin;
import com.dayouzc.e2e.core.biz.devicelogin.activity.LoginActivity;
import com.dayouzc.e2e.core.util.LoginUtils;
import com.dayouzc.e2eapp.ebusiness.checkin.R;
import com.dayouzc.e2eapp.ebusiness.checkin.di.component.DaggerHomeComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.adapter.CardRecyclerAdapter;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.HomeContract;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.presenter.HomePresenter;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 *
 * @Description: 首页
 * @Author qc
 * ================================================
 */
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.ic_home_where)
    TextView where;
    @BindView(R.id.tv_home_info)
    TextView tv_home_info;
    @BindView(R.id.tv_home_time)
    TextView time;
    @BindView(R.id.tv_home_card)
    TextView tvHomeCard;
    @BindView(R.id.tv_home_setting)
    TextView tvHomeSetting;

    @BindView(R.id.rl_home_background)
    RelativeLayout rlHomeBackground;
    @BindView(R.id.rl_home_show_card)
    RelativeLayout rlHomeShowCard;
    @BindView(R.id.ll_home_show_set)
    LinearLayout llHomeShowSet;

    @BindView(R.id.recycler_home_card)
    RecyclerView recyclerHomeCard;
    private LinearLayoutManager layoutManager;
    private List<McardTypeDTO> data;
    private int oldItem = 0;

    private Handler mHandler = new Handler();

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    @Location(needLocation = false)
    @UserLogin(needUserLogin = true)
    @OrganChoose(needOrganChoose = true)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        init();
    }

    //初始化
    private void init() {
        //请求卡列表
        mPresenter.getData();
        String customerName = E2EContext.getTokenInfo().getCustomerName();
        if (!TextUtils.isEmpty(customerName))
            where.setText(customerName);
        String beginTime = E2EContext.getTokenInfo().getConnBeginTime();
        if (!TextUtils.isEmpty(beginTime))
            time.setText(beginTime);
        String userName = E2EContext.getTokenInfo().getUserName();
        String organName = E2EContext.getTokenInfo().getOrganName();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(organName))
            tv_home_info.setText(String.format("%s %s", organName, userName));

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerHomeCard.setLayoutManager(layoutManager);

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @OnClick({R.id.rl_certificate, R.id.rl_order, R.id.rl_statistic, R.id.btn_home_exit, R.id.rl_home_card, R.id.rl_home_set, R.id.rl_home_background, R.id.rl_home_wifi, R.id.rl_home_update})
    public void onClick(View view) {
        if (view.getId() == R.id.rl_certificate) {
            ARouter.getInstance().build("/activity/certificate").navigation();
        } else if (view.getId() == R.id.rl_order) {
            ARouter.getInstance().build("/activity/order").navigation();
        } else if (view.getId() == R.id.rl_statistic) {
            ARouter.getInstance().build("/activity/statistics").navigation();
        } else if (view.getId() == R.id.btn_home_exit) {
            E2EAppClientContext.logout();
            LoginUtils.deleteFileForPublicData();

            startActivity(new Intent(this, LoginActivity.class)
                    .putExtra("packageName", "com.dayouzc.e2eapp.ebusiness.checkin")
                    .putExtra("className", "com.dayouzc.e2eapp.ebusiness.checkin.mvp.ui.activity.HomeActivity"));
            finish();
        } else if (view.getId() == R.id.rl_home_card) {
            tvHomeCard.setTextColor(getResources().getColor(R.color.color_0AABF6));
            tvHomeSetting.setTextColor(getResources().getColor(R.color.color_FFFFFF));
            Drawable icHomeCardChecked = getResources().getDrawable(R.mipmap.ic_home_card_checked);
            icHomeCardChecked.setBounds(0, 0, icHomeCardChecked.getMinimumWidth(), icHomeCardChecked.getMinimumHeight());
            tvHomeCard.setCompoundDrawables(icHomeCardChecked, null, null, null);
            Drawable icHomeSet = getResources().getDrawable(R.mipmap.ic_home_set);
            icHomeSet.setBounds(0, 0, icHomeSet.getMinimumWidth(), icHomeSet.getMinimumHeight());
            tvHomeSetting.setCompoundDrawables(icHomeSet, null, null, null);
            rlHomeBackground.setVisibility(View.VISIBLE);
            rlHomeShowCard.setVisibility(View.VISIBLE);
            llHomeShowSet.setVisibility(View.GONE);
        } else if (view.getId() == R.id.rl_home_set) {
            tvHomeCard.setTextColor(getResources().getColor(R.color.color_FFFFFF));
            tvHomeSetting.setTextColor(getResources().getColor(R.color.color_0AABF6));
            Drawable icHomeCard = getResources().getDrawable(R.mipmap.ic_home_card);
            icHomeCard.setBounds(0, 0, icHomeCard.getMinimumWidth(), icHomeCard.getMinimumHeight());
            tvHomeCard.setCompoundDrawables(icHomeCard, null, null, null);
            Drawable icHomeSetCheck = getResources().getDrawable(R.mipmap.ic_home_set_checked);
            icHomeSetCheck.setBounds(0, 0, icHomeSetCheck.getMinimumWidth(), icHomeSetCheck.getMinimumHeight());
            tvHomeSetting.setCompoundDrawables(icHomeSetCheck, null, null, null);
            rlHomeBackground.setVisibility(View.VISIBLE);
            rlHomeShowCard.setVisibility(View.GONE);
            llHomeShowSet.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.rl_home_background) {
            rlHomeBackground.setVisibility(View.GONE);
            rlHomeShowCard.setVisibility(View.GONE);
            llHomeShowSet.setVisibility(View.GONE);
        } else if (view.getId() == R.id.rl_home_wifi) {
            //   startActivity(new Intent(this, VerticalConnectionIserverActivity.class));
            rlHomeBackground.setVisibility(View.GONE);
            rlHomeShowCard.setVisibility(View.GONE);
            llHomeShowSet.setVisibility(View.GONE);
            Intent i = new Intent();
            i.setClassName("com.android.settings"
                    , "com.android.settings.wifi.WifiSettings");
            startActivity(i);
        } else if (view.getId() == R.id.rl_home_update) {
            rlHomeBackground.setVisibility(View.GONE);
            AppUpdate.appUpdate(this, E2EContext.getTokenInfo().getAppId(), E2EContext.getTokenInfo().getAppVer());
        }
    }

    //显示数据
    @Override
    public void setData(ResponseData<List<McardTypeDTO>> response) {

        if (null != data)
            data.clear();
        data = response.getResult();

        CardRecyclerAdapter adapter = new CardRecyclerAdapter(HomeActivity.this, data);

        recyclerHomeCard.setAdapter(adapter);

    }


    Runnable scrollRunnable = new Runnable() {
        @Override
        public void run() {
            recyclerHomeCard.scrollBy(3, 0);
            int firstItem = layoutManager.findFirstVisibleItemPosition();
            if (firstItem != oldItem && firstItem > 0) {
                oldItem = firstItem;
            }

            mHandler.postDelayed(scrollRunnable, 50);
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(scrollRunnable, 50);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(scrollRunnable);
    }

}
