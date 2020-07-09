package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dayouzc.e2e.core.util.ToastUtils;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R2;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerArtificialComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.ArtificialContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.ArtificialPresenter;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:人工
 *
 * @Author qc
 * ================================================
 */

public class ArtificialFragment extends BaseFragment<ArtificialPresenter> implements ArtificialContract.View {

    public static ArtificialFragment newInstance() {
        ArtificialFragment fragment = new ArtificialFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerArtificialComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artificial, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {



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

    @Override
    public void setData(ResponseData<OrderInfoDTO> responseData) {
        ToastUtils.showToast(getActivity(),responseData.getMsg());
    }


    @OnClick({R2.id.btn_artificial_true})
    public void onClick(View view){
        if (view.getId()==R.id.btn_artificial_true){
            mPresenter.getData();
        }
    }
}
