package com.gcloud.goods.web.controller;

import com.gcloud.goods.core.Constant;
import com.gcloud.goods.core.IGoodsSkuService;
import com.gcloud.goods.core.ServcieException;
import com.gcloud.goods.domain.GoodsSku;
import com.gcloud.goods.web.bean.ResponseEntity;
import com.gcloud.goods.web.request.GoodsSkuReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaController
 * @Package com.gcloud.demo.web.controller
 * @Description: 地区信息
 * @date 2016/6/1 13:53
 */
@Controller
@RequestMapping("/data/goods/sku")
public class GoodsSkuController {

    private static final Logger logger = LogManager.getLogger(GoodsSkuController.class);

    @Resource
    private IGoodsSkuService goodsSkuService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity skuList(GoodsSkuReq goodsSkuReq) {

        ResponseEntity responseEntity = new ResponseEntity();
        try {
            List<GoodsSku> goodsSkuList = goodsSkuService.queryGoodsSku(null);
            responseEntity.setResult(goodsSkuList);
        } catch (ServcieException e){
            responseEntity.setStatus(e.getMsgCode());
            responseEntity.setMessage(e.getMsgDesc());
            logger.error(e.getMessage());
        } catch (Exception e){
            responseEntity.setStatus(Constant.API_CALL_ERROR);
            responseEntity.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

}