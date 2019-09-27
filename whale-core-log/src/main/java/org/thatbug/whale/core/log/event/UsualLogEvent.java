package org.thatbug.whale.core.log.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * UsualLogEvent
 *
 * @author qzl
 * @date 16:27 2019/9/19
 */
public class UsualLogEvent extends ApplicationEvent {

    public UsualLogEvent(Map<String, Object> source) {
        super(source);
    }

}
