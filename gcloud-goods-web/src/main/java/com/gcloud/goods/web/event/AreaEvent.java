package com.gcloud.goods.web.event;

import com.gcloud.event.core.CommonEventSource;
import com.gcloud.event.core.EventSourceBase;
import com.gcloud.event.core.IEventListener;
import com.gcloud.event.core.annotation.EventBind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaEvent
 * @Package com.gcloud.event.web.event
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/13 10:05
 */
@Component
@EventBind("gcloud_goods_area_list")
public class AreaEvent implements IEventListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onObserved(EventSourceBase source) {
        CommonEventSource evt = (CommonEventSource) source;
        String userName = evt.getArg(0, String.class);
        logger.info("您好! " + userName);
    }
}

