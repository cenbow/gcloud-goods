package com.gcloud.goods.core;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ServcieException
 * @Package com.gcloud.pay.core
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class ServcieException extends Exception {

    private static final long serialVersionUID = -8113101052534916105L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public ServcieException() {
        super();
    }

    public ServcieException(Throwable throwable) {
        super(throwable);
    }

    public ServcieException(String message) {
        super(message);
        msgDesc = message;
    }

    public ServcieException(String msgCode, String msgDesc) {
        super();
        this.msgCode = msgCode;
        this.msgDesc = msgDesc;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }
}
