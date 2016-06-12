package com.gcloud.goods.web.exception;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudException
 * @Package com.gcloud.shop.web.exception
 * @Description: 系统异常类
 * @date 2016/6/8 10:40
 */
public class GcloudException extends Exception {

    private static final long serialVersionUID = 6288105537455940999L;

    public GcloudException(){

    }

    public GcloudException(String errorMessage){
        super(errorMessage);
    }

    public GcloudException(Throwable throwable){
        super(throwable);
    }

    public GcloudException(String errorMessage, Throwable throwable){
        super(errorMessage, throwable);
    }

    public GcloudException(String errorCode, String errorMessage){
        super(errorCode + ":" + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String errorMessage;
}
