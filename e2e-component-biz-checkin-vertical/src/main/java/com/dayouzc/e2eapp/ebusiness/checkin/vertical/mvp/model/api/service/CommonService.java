package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.api.service;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.Api;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.MCardRecordRequestBean;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.OrderRecordRequestBean;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eapp.mcard.dto.McardRecordDTO;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;
import com.dayouzc.e2eplatform.core.dto.common.E2EBaseObject;
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

    //解析二维码
    @Headers({"Content-Type: application/json"})
    @GET(Api.parseCode)
    Observable<ResponseData<E2EBaseObject>> getParseCode(@Query("codeStr") String codeStr, @Query("token") String token);

    //卡核验
    @Headers({"Content-Type: application/json"})
    @POST(Api.checkCard)
    Observable<ResponseData<McardRecordDTO>> getCardRecord(@Body MCardRecordRequestBean bean, @Query("token") String token);

    //订单核验
    @Headers({"Content-Type: application/json"})
    @POST(Api.checkOrder)
    Observable<ResponseData<OrderInfoDTO>> getOrderRecord(@Body OrderRecordRequestBean bean, @Query("token") String token);


}
