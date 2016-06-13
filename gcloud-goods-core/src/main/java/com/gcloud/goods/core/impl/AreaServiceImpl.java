package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.IAreaService;
import com.gcloud.goods.dao.IAreaDao;
import com.gcloud.goods.domain.Area;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
//@Service("areaService")
public class AreaServiceImpl implements IAreaService {

    private static final Logger logger = LogManager.getLogger(AreaServiceImpl.class);

    @Resource
    IAreaDao areaDao;

    @Override
    public List<Area> queryAreaList(Map<String, Object> condition) {

        logger.info("===================== queryAreaList ==============================");
        return areaDao.queryAreaList(condition);
    }

}
