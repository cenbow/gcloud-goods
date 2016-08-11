package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.IGoodsSpuService;
import com.gcloud.goods.core.ServcieException;
import com.gcloud.goods.mapper.GoodsSpuMapper;
import com.gcloud.goods.domain.GoodsSpu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GoodsSpuServiceImpl
 * @Package com.gcloud.goods.core.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:29
 */
@Service("goodsSpuService")
public class GoodsSpuServiceImpl implements IGoodsSpuService {

    @Resource
    private GoodsSpuMapper goodsSpuMapper;

    @Override
    public int deleteByPrimayKey(Long spuId) throws ServcieException {
        return goodsSpuMapper.deleteByPrimaryKey(spuId);
    }

    @Override
    public int insert(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.insertSelective(record);
    }

    @Override
    public GoodsSpu selectByPrimaryKey(Long spuId) throws ServcieException {
        return goodsSpuMapper.selectByPrimaryKey(spuId);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.updateByPrimaryKey(record);
    }

}
