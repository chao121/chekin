package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerInfraredComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.InfraredContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.InfraredPresenter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:红外线
 * @Author qc
 * ================================================
 */
public class InfraredFragment extends BaseFragment<InfraredPresenter> implements InfraredContract.View {

    private ConsumerIrManager mCIR;

    public static InfraredFragment newInstance() {
        InfraredFragment fragment = new InfraredFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerInfraredComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_infrared, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        // 获取系统的红外遥控服务
        mCIR = (ConsumerIrManager) getActivity().getSystemService(Context.CONSUMER_IR_SERVICE);
    }


    @Override
    public void setData(@Nullable Object data) {

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

    }
}
