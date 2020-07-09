package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.app.Application;

import com.dayouzc.e2e.core.E2EContext;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HomeContract;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;


import java.util.List;


/**
 * ================================================
 *
 * @Description: 首页
 * @Author qc
 * ================================================
 */
@ActivityScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView) {
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
    //卡列表
    public void getData() {

        String token = E2EContext.getToken();
        String bizType = "CHK";

        mModel.getData(bizType, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<ResponseData<List<McardTypeDTO>>>(mErrorHandler) {
                    @Override
                    public void onNext(ResponseData<List<McardTypeDTO>> mcardTypeDTO) {
                        mRootView.setData(mcardTypeDTO);
                    }
                });


    }
}
