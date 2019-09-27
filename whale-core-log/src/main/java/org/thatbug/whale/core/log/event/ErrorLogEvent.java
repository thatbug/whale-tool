package org.thatbug.whale.core.log.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * 错误日志事件
 *
 * @author qzl
 * @date 16:11 2019/9/19
 */
public class ErrorLogEvent extends ApplicationEvent {

    public ErrorLogEvent(Map<String, Object> source) {
        super(source);
    }

}