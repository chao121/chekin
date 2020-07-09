package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean.OrderRecordRequestBean;
import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.E2EBaseObject;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import io.reactivex.Observable;


/**
 * ================================================
 *
 * @Description: 摄像
 * @Author qc
 * ================================================
 */
public interface CameraContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void setData(ResponseData<E2EBaseObject> e2EBaseObject);

        void setOrderInfo(ResponseData<OrderInfoDTO> requestData);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<ResponseData<E2EBaseObject>> getData(String codeStr, String token);

        Observable<ResponseData<OrderInfoDTO>> getOrderRecord(OrderRecordRequestBean bean, String token);

    }
}
