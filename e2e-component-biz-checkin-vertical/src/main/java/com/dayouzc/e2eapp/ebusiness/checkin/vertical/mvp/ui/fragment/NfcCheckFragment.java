package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment;

import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerNfcCheckComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.NfcCheckContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.NfcCheckPresenter;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.utils.NfcUtils;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:nfc
 *
 * @Author qc
 * ================================================
 */
public class NfcCheckFragment extends BaseFragment<NfcCheckPresenter> implements NfcCheckContract.View {

    public static NfcCheckFragment newInstance() {
        NfcCheckFragment fragment = new NfcCheckFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerNfcCheckComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nfc_check, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        NfcUtils utils = new NfcUtils(getActivity());

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
//        NfcUtils.mNfcAdapter.disableForegroundDispatch(getActivity());
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
