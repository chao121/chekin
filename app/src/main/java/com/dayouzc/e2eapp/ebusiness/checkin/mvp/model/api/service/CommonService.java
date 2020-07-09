package com.dayouzc.e2eapp.ebusiness.checkin.mvp.model.api.service;

import com.dayouzc.e2eapp.ebusiness.checkin.mvp.model.Api;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CommonService {
    //卡列表
    @Headers({"Content-Type: application/json"})
    @GET(Api.cardType)
    Observable<ResponseData<List<McardTypeDTO>>> getData(@Query("bizType") String bizType, @Query("token") String token);

}
