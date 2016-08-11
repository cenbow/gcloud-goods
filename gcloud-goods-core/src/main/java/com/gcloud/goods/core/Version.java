package com.gcloud.goods.core;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Version
 * @Package com.gcloud.api
 * @Description: 版本信息
 * @date 2016/6/1 13:53
 */
public class Version {

    /**
     * 版本名称
     */
    private String name;

    /**
     * 版本发布时间
     */
    private String releaseTime;

    /**
     * 版本发布人
     */
    private String Publisher;

    /**
     * 版本发布描述
     */
    private String realeaseDesc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getRealeaseDesc() {
        return realeaseDesc;
    }

    public void setRealeaseDesc(String realeaseDesc) {
        this.realeaseDesc = realeaseDesc;
    }
}
