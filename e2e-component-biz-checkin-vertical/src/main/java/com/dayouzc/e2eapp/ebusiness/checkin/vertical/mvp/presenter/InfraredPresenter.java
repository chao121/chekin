package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.InfraredContract;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 红外
 * @Author qc
 * ================================================
 */
@FragmentScope
public class InfraredPresenter extends BasePresenter<InfraredContract.Model, InfraredContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public InfraredPresenter(InfraredContract.Model model, InfraredContract.View rootView) {
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
