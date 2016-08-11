package com.gcloud.goods.core;

import com.gcloud.goods.domain.GoodsSku;

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

}
