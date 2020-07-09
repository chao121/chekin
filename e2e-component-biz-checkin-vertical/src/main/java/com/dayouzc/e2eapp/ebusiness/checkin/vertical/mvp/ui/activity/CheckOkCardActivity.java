package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R2;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerCheckOkCardComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckOkCardContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.CheckOkCardPresenter;
import com.dayouzc.e2eapp.mcard.dto.McardRecordDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;



import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 *
 * @Description: 核验成功
 * @Author qc
 * ================================================
 */
@Route(path = "/activity/checkOkCard")
public class CheckOkCardActivity extends BaseActivity<CheckOkCardPresenter> implements CheckOkCardContract.View {

    @BindView(R2.id.tv_check_ok_card_name)
    TextView tvName;
    @BindView(R2.id.tv_check_ok_num)
    TextView tvNum;
    @BindView(R2.id.tv_check_ok_phone)
    TextView tvPhone;
    @BindView(R2.id.tv_check_ok__cardNum)
    TextView tvCardNum;
    @BindView(R2.id.tv_check_ok_status)
    TextView tvCardStatus;
    private ResponseData<McardRecordDTO> responseData;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerCheckOkCardComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_check_ok_card; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        responseData = (ResponseData<McardRecordDTO>) getIntent().getSerializableExtra("mCardRecord");
        tvName.setText(responseData.getResult().getCreateMan());
        tvNum.setText(responseData.getResult().getCreateManId());
//        tvPhone.setText(responseData.getResult().getCreateManId());
        tvCardNum.setText(String.format("卡号:%s", responseData.getResult().getCardNum()));
//        tvCardStatus.setText();  //TODO 字段未找到

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
