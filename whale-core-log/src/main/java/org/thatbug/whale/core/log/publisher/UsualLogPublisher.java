package org.thatbug.whale.core.log.publisher;

import org.thatbug.whale.core.log.constant.EventConstant;
import org.thatbug.whale.core.log.event.UsualLogEvent;
import org.thatbug.whale.core.log.model.LogUsual;
import org.thatbug.whale.core.log.utils.LogAbstractUtil;
import org.thatbug.whale.core.tool.utils.SpringUtil;
import org.thatbug.whale.core.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志信息事件发送
 *
 * @author qzl
 * @date 16:26 2019/9/19
 */
public class UsualLogPublisher {

    public static void publishEvent(String level, String id, String data) {
        HttpServletRequest request = WebUtil.getRequest();
        LogUsual logUsual = new LogUsual();
        logUsual.setLogLevel(level);
        logUsual.setLogId(id);
        logUsual.setLogData(data);

        LogAbstractUtil.addRequestInfoToLog(request, logUsual);
        Map<String, Object> event = new HashMap<>(16);
        event.put(EventConstant.EVENT_LOG, logUsual);
        event.put(EventConstant.EVENT_REQUEST, request);
        SpringUtil.publishEvent(new UsualLogEvent(event));
    }

}

