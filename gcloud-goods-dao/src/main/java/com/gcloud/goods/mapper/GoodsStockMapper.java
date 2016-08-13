package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.GoodsStock;

public interface GoodsStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    GoodsStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsStock record);

    int updateByPrimaryKey(GoodsStock record);
}