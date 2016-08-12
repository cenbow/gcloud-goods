package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.Constant;
import com.gcloud.goods.core.IGoodsSkuService;
import com.gcloud.goods.core.ServcieException;
import com.gcloud.goods.domain.GoodsSku;
import com.gcloud.goods.mapper.GoodsSkuMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GoodsSpuServiceImpl
 * @Package com.gcloud.goods.core.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:29
 */
@Service("goodsSkuService")
public class GoodsSkuServiceImpl implements IGoodsSkuService {

    private static final Logger logger = LogManager.getLogger(GoodsSkuServiceImpl.class);

    @Resource
    private GoodsSkuMapper goodsSkuMapper;

    @Override
    public int deleteByPrimayKey(Long skuId) throws ServcieException {
        return goodsSkuMapper.deleteByPrimaryKey(skuId);
    }

    @Override
    public int insert(GoodsSku record) throws ServcieException {
        return goodsSkuMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsSku record) throws ServcieException {
        return goodsSkuMapper.insertSelective(record);
    }

    @Override
    public GoodsSku selectByPrimaryKey(Long skuId) throws ServcieException {
        return goodsSkuMapper.selectByPrimaryKey(skuId);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSku record) throws ServcieException {
        return goodsSkuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsSku record) throws ServcieException {
        return goodsSkuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsSku> queryGoodsSku(Map<String, Object> params) throws ServcieException {

        List<GoodsSku> goodsSkuList = null;
        try {
            goodsSkuList = goodsSkuMapper.queryGoodsSku(params);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServcieException(Constant.API_CALL_ERROR, "查询商品SKU错误!");
        }
        return goodsSkuList;
    }

}
