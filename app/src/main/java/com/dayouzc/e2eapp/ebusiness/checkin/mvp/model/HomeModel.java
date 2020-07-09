package com.dayouzc.e2eapp.ebusiness.checkin.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.HomeContract;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.model.api.service.CommonService;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * ================================================
 *
 * @Description: 首页
 * @Author qc
 * ================================================
 */
@ActivityScope
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<ResponseData<List<McardTypeDTO>>> getData(String bizType, String token) {
        return mRepositoryManager.obtainRetrofitService(CommonService.class).getData(bizType, token);
    }
}