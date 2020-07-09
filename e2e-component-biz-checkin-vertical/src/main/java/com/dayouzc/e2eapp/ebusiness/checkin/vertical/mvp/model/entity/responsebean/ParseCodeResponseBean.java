package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.entity.responsebean;
/**
 * ================================================
 *
 * @Description: 解析二维码bean
 * @Author qc
 * ================================================
 */
public class ParseCodeResponseBean {


    /**
     * status : 10000
     * msg : success!
     * result : {"objValue":"12451245"}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * objValue : 12451245
         */

        private String objValue;
        private String objType;

        public ResultBean(String objValue, String objType) {
            this.objValue = objValue;
            this.objType = objType;
        }

        public String getObjType() {
            return objType;
        }

        public void setObjType(String objType) {
            this.objType = objType;
        }

        public String getObjValue() {
            return objValue;
        }



        public void setObjValue(String objValue) {
            this.objValue = objValue;
        }
    }
}
