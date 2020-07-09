package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerCheckSuccessComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckSuccessContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.CheckSuccessPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * @Description: 验证成功
 * @Author qc
 * ================================================
 */
@Route(path = "/activity/checkSuccess")
public class CheckSuccessActivity extends BaseActivity<CheckSuccessPresenter> implements CheckSuccessContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerCheckSuccessComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_check_success; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

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
