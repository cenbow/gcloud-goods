package com.gcloud.goods.domain;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Area
 * @Package com.gcloud.event.domain
 * @Description: 区域模型
 * @date 2016/6/12 15:24
 */
public class Area {

    public Area() {

    }

    private Long id;

    private Integer type;

    private String name;

    private Long parentId;

    private String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("{id:").append(id).append(",type:").append(type).append(",name:").append(name);
        builder.append(",parentId:").append(parentId).append(",zip:").append(zip).append("}");
        return builder.toString();
    }
}