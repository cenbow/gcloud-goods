package com.gcloud.goods.web.event;

import com.gcloud.event.core.CommonEventSource;
import com.gcloud.event.core.EventSourceBase;
import com.gcloud.event.core.IEventListener;
import com.gcloud.event.core.annotation.EventBind;
import com.gcloud.trade.core.IAreaService;
import com.gcloud.trade.domain.Area;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaListEvent
 * @Package com.gcloud.goods.core.event
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/13 14:12
 */
@Component
@EventBind("gcloud_goods_area_list")
public class AreaListEvent implements IEventListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAreaService areaService;

    @Override
    public void onObserved(EventSourceBase source) {

        List<Area> areaList =areaService.queryAreaList(new HashMap<String, Object>());
        logger.info(areaList.size());

        CommonEventSource evt = (CommonEventSource) source;
        String userName = evt.getArg(0, String.class);
        logger.info("您好! " + userName);
    }
}