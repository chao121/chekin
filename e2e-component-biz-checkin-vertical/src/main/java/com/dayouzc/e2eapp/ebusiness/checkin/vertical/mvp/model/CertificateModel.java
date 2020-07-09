package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CertificateContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.api.service.CommonService;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.MCardRecordRequestBean;
import com.dayouzc.e2eapp.mcard.dto.McardRecordDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;


import io.reactivex.Observable;


/**
 * ================================================
 *
 * @Description: 核验
 * @Author qc
 * ================================================
 */
@ActivityScope
public class CertificateModel extends BaseModel implements CertificateContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public CertificateModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }


    @Override
    public Observable<ResponseData<McardRecordDTO>> getData(MCardRecordRequestBean bean, String token) {
        return mRepositoryManager.obtainRetrofitService(CommonService.class).getCardRecord(bean,token);
    }

}