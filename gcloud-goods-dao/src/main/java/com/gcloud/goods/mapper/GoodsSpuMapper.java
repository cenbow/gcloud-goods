package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.GoodsSpu;

public interface GoodsSpuMapper {

    int deleteByPrimaryKey(Long numIid);

    int insert(GoodsSpu record);

    int insertSelective(GoodsSpu record);

    GoodsSpu selectByPrimaryKey(Long numIid);

    int updateByPrimaryKeySelective(GoodsSpu record);

    int updateByPrimaryKey(GoodsSpu record);
}