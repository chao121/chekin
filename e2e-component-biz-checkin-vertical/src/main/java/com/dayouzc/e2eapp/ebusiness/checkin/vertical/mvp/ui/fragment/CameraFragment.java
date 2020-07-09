package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerCameraComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CameraContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.CameraPresenter;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CheckSuccessActivity;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.utils.CustomCaptureManager;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.E2EBaseObject;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:摄像头
 *
 * @Author qc
 * ================================================
 */
public class CameraFragment extends BaseFragment<CameraPresenter> implements CameraContract.View {

    /**
     * 条形码扫描管理器
     */
    private CustomCaptureManager mCaptureManager;

    /**
     * 条形码扫描视图
     */
    private DecoratedBarcodeView mBarcodeView;


    public static CameraFragment newInstance() {
        CameraFragment fragment = new CameraFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerCameraComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carmera, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        mBarcodeView = (DecoratedBarcodeView) getActivity().findViewById(R.id.zxing_barcode_scanner);
        mCaptureManager = new CustomCaptureManager(getActivity(), mBarcodeView);
        mCaptureManager.initializeFromIntent(getActivity().getIntent(), savedInstanceState);

        mCaptureManager.setResultCallBack(new CustomCaptureManager.ResultCallBack() {
            @Override
            public void callBack(int requestCode, int resultCode, Intent intent) {
                IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
                if (null != result && null != result.getContents()) {
                    Toast.makeText(CameraFragment.this.getActivity(), result.getContents(), Toast.LENGTH_LONG).show();
                    //解析二维码
                    mPresenter.getData("OVUFfMcardInfo;35353");

                }
            }
        });
        mCaptureManager.decode();

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
    public void onResume() {

        super.onResume();
        mCaptureManager.onResume();
        mCaptureManager.decode();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCaptureManager.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCaptureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mCaptureManager.onSaveInstanceState(outState);
    }

    /**
     * 权限处理
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        mCaptureManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void setData(ResponseData<E2EBaseObject> e2EBaseObject) {

        if ("FfMcardInfo".equals(e2EBaseObject.getResult().getObjType())){
            String cardNum="860990000486";
            mPresenter.getCheck(cardNum);
        }

    }

    @Override
    public void setOrderInfo(ResponseData<OrderInfoDTO> bean) {

        startActivity(new Intent(getActivity(), CheckSuccessActivity.class));

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // 获取解析结果
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if (result != null) {
//            if (result.getContents() == null) {
//                Toast.makeText(getActivity(), "取消扫描", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(getActivity(), "扫描内容:" + result.getContents(), Toast.LENGTH_LONG).show();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }


    /**
     * 按键处理
     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return mBarcodeView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
//    }
}
