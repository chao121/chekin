package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import android.app.Application;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CameraContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.api.service.CommonService;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.OrderRecordRequestBean;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.E2EBaseObject;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;


import io.reactivex.Observable;


/**
 * ================================================
 *
 * @Description: 摄像
 * @Author qc
 * ================================================
 */
@FragmentScope
public class CameraModel extends BaseModel implements CameraContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public CameraModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<ResponseData<E2EBaseObject>> getData(String codeStr, String token) {
        return mRepositoryManager.obtainRetrofitService(CommonService.class).getParseCode(codeStr,token);
    }

    @Override
    public Observable<ResponseData<OrderInfoDTO>> getOrderRecord(OrderRecordRequestBean bean, String token) {
        return mRepositoryManager.obtainRetrofitService(CommonService.class).getOrderRecord(bean,token);
    }
}