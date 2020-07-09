package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckOkCardContract;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 核验成功卡
 * @Author qc
 * ================================================
 */
@ActivityScope
public class CheckOkCardModel extends BaseModel implements CheckOkCardContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public CheckOkCardModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}