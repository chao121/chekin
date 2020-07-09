package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract;

import com.dayouzc.e2eapp.lforder.dto.OrderInfoDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

/**
 * ================================================
 *
 * @Description: 人工
 * @Author qc
 * ================================================
 */
public interface ArtificialContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void setData(ResponseData<OrderInfoDTO> responseData);

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

    }
}
