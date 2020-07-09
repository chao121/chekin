package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model;

import com.dayouzc.e2e.core.E2EAppClientContext;
import com.dayouzc.e2e.core.config.E2ESvrConfig;
import com.dayouzc.e2e.core.constant.common.BaseConstant;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * ================================================
 *
 * @Description: url
 * @Author qc
 * ================================================
 */
public interface Api {

    public static final String ip = E2ESvrConfig.connectIp;
    public static final String BaseUrl = "http://172.16.2.221";
    public static final String port = E2ESvrConfig.connectPort;
    public static final String path = BaseConstant.ContextPath.MCARDSVR_PATH;
    public static final String helpCenterPath = "http://172.16.17.157/ebmccsmweb/scenichelpcenter?token=1&mcId=12312";
    public static final String cardType = "/mcardsvr/mcardtypes/organ/mine/mcardtypes";
    //解析二维码/条形码
    public static final String parseCode = "/commonsvr/qrcodes/parse";
    //卡核验
    public static final String checkCard = "/mcardsvr/mcards/use";
    //订单核验
    public static final String checkOrder = "/ebsvr/eborders/pickup";



    public static final String PARAM_SUCCESS = "10000";
    /**
     * 信息参数校验：参数错误
     */
    public static final String PARAM_ERROR = "10010";
    /**
     * 信息参数校验：未查询到卡
     */
    public static final String PARAM_CARD_NOT_EXIST = "10020";
    /**
     * 卡状态异常：卡未销售
     */
    public static final String CARD_UNSOLD = "20010";
    /**
     * 卡状态异常：卡未绑定
     */
    public static final String CARD_UNBIND = "20011";
    /**
     * 卡状态异常：卡已过期
     */
    public static final String CARD_OVERDUR = "20014";
    /**
     * 卡状态异常：卡已冻结
     */
    public static final String CARD_FROZEN = "20016";
    /**
     * 卡状态异常：卡已挂失
     */
    public static final String CARD_LOST = "20013";
    /**
     * 卡状态异常：卡为无效卡
     */
    public static final String CARD_UNVALID = "20019";
    /**
     * 适用景区规则：卡不适用于本景区
     */
    public static final String MC_NOTMATCH = "20021";
    /**
     * 适用景区规则：卡无可用次数
     */
    public static final String MC_NO_NUMBER = "20022";

    public static Map<String, String> map = new LinkedHashMap<String, String>() {
        {
            put("10010", "扫描结果有误！请重新扫描！");
            put("10020", "未查询到相应信息");
            put("20010", "验证失败！此卡暂未销售！");
            put("20011", "验证失败！此卡未绑定！");
            put("20014", "验证失败！此卡已过期，请联系售卡方咨询！");
            put("20016", "验证失败！此卡已冻结！");
            put("20013", "验证失败！此卡已挂失！");
            put("20019", "验证失败！此卡为无效卡！");
            put("20021", "验证失败！此卡不适用于本景区！");
            put("20022", "验证失败！此卡无可用次数！");
        }
    };


}
