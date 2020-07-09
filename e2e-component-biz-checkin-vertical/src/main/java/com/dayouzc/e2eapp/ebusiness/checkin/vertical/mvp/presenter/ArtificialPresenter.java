package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.annotation.SuppressLint;
import android.app.Application;

import com.dayouzc.e2e.core.E2EContext;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.ArtificialContract;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eapp.mcard.dto.McardDeliverDetailDTO;
import com.dayouzc.e2eapp.mcard.dto.McardOrderDetailDTO;
import com.dayouzc.e2eapp.mcard.sdk.McardOrderSDK;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 人工
 * @Author qc
 * ================================================
 */
@FragmentScope
public class ArtificialPresenter extends BasePresenter<ArtificialContract.Model, ArtificialContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public ArtificialPresenter(ArtificialContract.Model model, ArtificialContract.View rootView) {
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

    public void getData() {


        Observable.create(new ObservableOnSubscribe<ResponseData<OrderInfoDTO>>() {
            @Override
            public void subscribe(ObservableEmitter<ResponseData<OrderInfoDTO>> emitter) throws Exception {
            }
        }).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseData<OrderInfoDTO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseData<OrderInfoDTO> responseData) {
                        mRootView.setData(responseData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
