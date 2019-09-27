package org.thatbug.whale.core.log.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.thatbug.whale.core.launch.props.WhaleProperties;
import org.thatbug.whale.core.launch.server.ServerInfo;
import org.thatbug.whale.core.log.constant.EventConstant;
import org.thatbug.whale.core.log.feign.ILogClient;
import org.thatbug.whale.core.log.model.LogUsual;
import org.thatbug.whale.core.log.utils.LogAbstractUtil;

import java.util.Map;

/**
 * 异步监听日志事件
 *
 * @author qzl
 * @date 16:31 2019/9/19
 */
@Slf4j
@AllArgsConstructor
public class UsualLogListener {

    private final ILogClient logService;
    private final ServerInfo serverInfo;
    private final WhaleProperties whaleProperties;

    @Async
    @Order
    @EventListener(UsualLogEvent.class)
    public void saveUsualLog(UsualLogEvent event) {
        Map<String, Object> source = (Map<String, Object>) event.getSource();
        LogUsual logUsual = (LogUsual) source.get(EventConstant.EVENT_LOG);
        LogAbstractUtil.addOtherInfoToLog(logUsual, whaleProperties, serverInfo);
        logService.saveUsualLog(logUsual);
    }

}