package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HelpCenterContract;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 帮助中心
 * @Author qc
 * ================================================
 */
@ActivityScope
public class HelpCenterPresenter extends BasePresenter<HelpCenterContract.Model, HelpCenterContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public HelpCenterPresenter(HelpCenterContract.Model model, HelpCenterContract.View rootView) {
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
