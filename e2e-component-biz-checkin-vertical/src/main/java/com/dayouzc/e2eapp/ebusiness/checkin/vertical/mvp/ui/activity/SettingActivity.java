package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.BuildConfig;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R2;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerSettingComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.SettingContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.SettingPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;


import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 *
 * @Description:系统设置
 * @Author qc
 * ================================================
 */
@Route(path = "/activity/setting")
public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {

    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.tv_setting_version)
    TextView tvSettingVersion;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSettingComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_setting; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        title.setText(getResources().getString(R.string.tv_setting_name));
        tvSettingVersion.setText(BuildConfig.VERSION_NAME);
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
}
