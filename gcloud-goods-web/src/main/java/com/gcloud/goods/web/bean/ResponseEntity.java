package com.gcloud.goods.web.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.gcloud.goods.core.Constant;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    @JSONField(name = "status")
    private String status = Constant.API_CALL_SUCCESS;

    @JSONField(name = "message")
    private String message = Constant.API_CALL_SUCCESS;

    @JSONField(name = "api")
    private String api;

    @JSONField(name = "result")
    private Object result = "";

    @JSONField(name = "sign")
    private Object sign = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

}
