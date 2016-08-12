package com.gcloud.goods.core;

import com.gcloud.goods.domain.GoodsSku;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IGoodsSpuService
 * @Package com.gcloud.goods.core
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:28
 */
public interface IGoodsSkuService {

    int deleteByPrimayKey(Long skuId) throws ServcieException;

    int insert(GoodsSku record) throws ServcieException;

    int insertSelective(GoodsSku record) throws ServcieException;

    GoodsSku selectByPrimaryKey(Long skuId) throws ServcieException;

    int updateByPrimaryKeySelective(GoodsSku record) throws ServcieException;

    int updateByPrimaryKey(GoodsSku record) throws ServcieException;

    /**
     * 查询SKU数据
     * @param params
     * @return
     */
    List<GoodsSku> queryGoodsSku(Map<String, Object> params) throws ServcieException;

}
