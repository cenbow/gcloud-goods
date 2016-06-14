package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.IDemoService;
import com.gcloud.goods.dao.IDemoDao;
import com.gcloud.goods.domain.Demo;
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
@Service("demoService")
public class DemoServiceImpl implements IDemoService {

    private static final Logger logger = LogManager.getLogger(DemoServiceImpl.class);

    @Resource
    IDemoDao demoDao;

    @Override
    public List<Demo> queryDemoList(Map<String, Object> condition) {

        logger.info("===================== queryAreaList ==============================");
        return demoDao.queryDemoList(condition);
    }

}
