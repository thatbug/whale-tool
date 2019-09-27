package org.thatbug.whale.core.log.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thatbug.whale.core.log.model.LogApi;
import org.thatbug.whale.core.log.model.LogError;
import org.thatbug.whale.core.log.model.LogUsual;
import org.thatbug.whale.core.tool.api.R;

/**
 * 日志Fallback
 *
 * @author qzl
 * @date 16:17 2019/9/19
 */
@Slf4j
@Component
public class LogClientFallback implements ILogClient {

    @Override
    public R<Boolean> saveUsualLog(LogUsual log) {
        return R.fail("usual log send fail");
    }

    @Override
    public R<Boolean> saveApiLog(LogApi log) {
        return R.fail("api log send fail");
    }

    @Override
    public R<Boolean> saveErrorLog(LogError log) {
        return R.fail("error log send fail");
    }
}

