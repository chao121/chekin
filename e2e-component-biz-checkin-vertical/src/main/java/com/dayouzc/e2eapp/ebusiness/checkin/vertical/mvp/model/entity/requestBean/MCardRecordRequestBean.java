package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.requestBean;
/**
 * ================================================
 *
 * @Description: 卡bean
 * @Author qc
 * ================================================
 */
public class MCardRecordRequestBean {

    public MCardRecordRequestBean(String cardIcid) {
        this.appData = new AppDataBean(cardIcid);
    }

    /**
     * appData : {"cardIcid":"D17E4069"}
     */

    private AppDataBean appData;

    public AppDataBean getAppData() {
        return appData;
    }

    public void setAppData(AppDataBean appData) {
        this.appData = appData;
    }

    public static class AppDataBean {
        /**
         * cardIcid : D17E4069
         */

        private String cardIcid;

        public AppDataBean(String cardIcid) {
            this.cardIcid = cardIcid;
        }

        public String getCardIcid() {
            return cardIcid;
        }

        public void setCardIcid(String cardIcid) {
            this.cardIcid = cardIcid;
        }
    }
}
