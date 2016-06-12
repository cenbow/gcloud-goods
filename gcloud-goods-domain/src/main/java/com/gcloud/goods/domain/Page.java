package com.gcloud.goods.domain;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Page
 * @Package com.gcloud.domain
 * @Description: 页码信息，startRow必须从1开始,page必须大于或者等于0
 * @date 2016/6/1 13:53
 */
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;
	public final static int DEFAULT_PAGE_SIZE = 20;
    public final static int DEFAULT_PAGE_NUM = 1;
    protected Integer pageSize = DEFAULT_PAGE_SIZE;
    protected Integer startRow = 0;//起始行
    protected Integer offsetRow;//结束行(闭合)
    protected Integer pageNo = DEFAULT_PAGE_NUM;

    public Integer getStartRow() {
    	if(startRow == null){
    		setPageNo(pageNo);
    	}
        return startRow;
    }

    public Page setStartRow(Integer startRow) {
        this.startRow = startRow;
        return this;
    }

    public Integer getOffsetRow() {
    	if(null == offsetRow){
    		setPageNo(pageNo);
    	}
        return offsetRow;
    }

    public Page setOffsetRow(Integer offsetRow) {
        this.offsetRow = offsetRow;
        return this;
    }

    public Page setPageNo(Integer page) {
        if (page == null || page < 0) page = DEFAULT_PAGE_NUM;
        this.pageNo = page;
        this.startRow = (page - 1) * this.pageSize;
        this.offsetRow = this.pageSize;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Page setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) pageSize = 1;
        this.pageSize = pageSize;
        this.startRow = (pageNo - 1) * this.pageSize;
        this.offsetRow = this.pageSize;
        return this;
    }

    public Integer getPageNo() {
        return pageNo;
    }
}
