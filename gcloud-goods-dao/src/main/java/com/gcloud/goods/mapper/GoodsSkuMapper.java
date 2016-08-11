package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.GoodsSku;

public interface GoodsSkuMapper {

    int deleteByPrimaryKey(Long skuId);

    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    GoodsSku selectByPrimaryKey(Long skuId);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);
}