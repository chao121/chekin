package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckNoCardContract;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 核验失败卡
 * @Author qc
 * ================================================
 */
@ActivityScope
public class CheckNoCardPresenter extends BasePresenter<CheckNoCardContract.Model, CheckNoCardContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public CheckNoCardPresenter(CheckNoCardContract.Model model, CheckNoCardContract.View rootView) {
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
}
