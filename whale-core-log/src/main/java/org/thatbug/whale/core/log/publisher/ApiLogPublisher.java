package org.thatbug.whale.core.log.publisher;

import org.thatbug.whale.core.log.annotation.ApiLog;
import org.thatbug.whale.core.log.constant.EventConstant;
import org.thatbug.whale.core.log.event.ApiLogEvent;
import org.thatbug.whale.core.log.model.LogApi;
import org.thatbug.whale.core.log.utils.LogAbstractUtil;
import org.thatbug.whale.core.tool.constant.WhaleConstant;
import org.thatbug.whale.core.tool.utils.SpringUtil;
import org.thatbug.whale.core.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * api日志信息事件发送
 *
 * @author qzl
 * @date 16:23 2019/9/19
 */
public class ApiLogPublisher {

    public static void publishEvent(String methodName, String methodClass, ApiLog apiLog, long time) {
        HttpServletRequest request = WebUtil.getRequest();
        LogApi logApi = new LogApi();
        logApi.setType(WhaleConstant.LOG_NORMAL_TYPE);
        logApi.setTitle(apiLog.value());
        logApi.setTime(String.valueOf(time));
        logApi.setMethodClass(methodClass);
        logApi.setMethodName(methodName);

        LogAbstractUtil.addRequestInfoToLog(request, logApi);
        Map<String, Object> event = new HashMap<>(16);
        event.put(EventConstant.EVENT_LOG, logApi);
        SpringUtil.publishEvent(new ApiLogEvent(event));
    }

}
