package com.gcloud.goods.core.event;

import com.gcloud.event.core.CommonEventSource;
import com.gcloud.event.core.EventSourceBase;
import com.gcloud.event.core.IEventListener;
import com.gcloud.event.core.annotation.EventBind;
import com.gcloud.goods.domain.Area;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaEvent
 * @Package com.gcloud.event.web.event
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/13 10:05
 */
@Component
@EventBind("gcloud.goods.area.list")
public class AreaEvent implements IEventListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onObserved(EventSourceBase source) {

        CommonEventSource evt = (CommonEventSource) source;
        List<Area> areaList = evt.getArgList(0, Area.class);
        for(Area area : areaList){
            logger.info(area.toString());
        }
    }
}

