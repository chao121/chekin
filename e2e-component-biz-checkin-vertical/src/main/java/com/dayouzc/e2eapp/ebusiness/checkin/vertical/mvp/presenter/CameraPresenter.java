package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.app.Application;

import com.dayouzc.e2e.core.E2EContext;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CameraContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.OrderRecordRequestBean;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.E2EBaseObject;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;


/**
 * ================================================
 * Description:摄像头
 *
 * @Author qc
 * ================================================
 */
@FragmentScope
public class CameraPresenter extends BasePresenter<CameraContract.Model, CameraContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public CameraPresenter(CameraContract.Model model, CameraContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    //解析
    public void getData(String cardNum) {


        mModel.getData(cardNum, E2EContext.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<ResponseData<E2EBaseObject>>(mErrorHandler) {
                    @Override
                    public void onNext(ResponseData<E2EBaseObject> e2EBaseObject) {

                        mRootView.setData(e2EBaseObject);
                    }
                });
    }

    //核验
    public void getCheck(String cardNum) {

        mModel.getOrderRecord(new OrderRecordRequestBean(cardNum), E2EContext.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<ResponseData<OrderInfoDTO>>(mErrorHandler) {
                    @Override
                    public void onNext(ResponseData<OrderInfoDTO> responseData) {

                        mRootView.setOrderInfo(responseData);
                    }
                });

    }
}
