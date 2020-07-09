package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckSuccessContract;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 核验成功
 * @Author qc
 * ================================================
 */
@ActivityScope
public class CheckSuccessModel extends BaseModel implements CheckSuccessContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public CheckSuccessModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}