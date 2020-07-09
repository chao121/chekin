package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.ArtificialContract;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;



/**
 * ================================================
 *
 * @Description: 人工
 * @Author qc
 * ================================================
 */
@FragmentScope
public class ArtificialModel extends BaseModel implements ArtificialContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ArtificialModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}