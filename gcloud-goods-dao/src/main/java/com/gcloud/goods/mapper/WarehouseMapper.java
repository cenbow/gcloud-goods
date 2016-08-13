package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.Warehouse;

public interface WarehouseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}