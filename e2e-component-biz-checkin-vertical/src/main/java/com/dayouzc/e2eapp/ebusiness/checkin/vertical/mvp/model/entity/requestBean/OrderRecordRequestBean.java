package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean;

/**
 * ================================================
 *
 * @Description: 统计bean
 * @Author qc
 * ================================================
 */
public class OrderRecordRequestBean {
    public OrderRecordRequestBean(String cardNum) {
        this.appData= new AppData(cardNum);
    }

    private AppData appData;

    public AppData getAppDataBean() {
        return appData;
    }

    public void setAppDataBean(AppData appDataBean) {
        this.appData = appDataBean;
    }

    public static class AppData {
        public AppData(String cardNum) {
            this.cardNum = cardNum;
        }

        /**
         * cardNum : D17E4069
         */


        private String cardNum;

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }
    }
}
