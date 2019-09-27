package org.thatbug.whale.core.log.utils;

import org.thatbug.whale.core.launch.props.WhaleProperties;
import org.thatbug.whale.core.launch.server.ServerInfo;
import org.thatbug.whale.core.log.model.LogAbstract;
import org.thatbug.whale.core.secure.utils.SecureUtil;
import org.thatbug.whale.core.tool.utils.StringPool;
import org.thatbug.whale.core.tool.utils.UrlUtil;
import org.thatbug.whale.core.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * LogAbstractUtil
 *
 * @author qzl
 * @date 16:09 2019/9/19
 */
public class LogAbstractUtil {

    /**
     * 向log中添加补齐request的信息
     *
     * @param request     请求
     * @param logAbstract 日志基础类
     */
    public static void addRequestInfoToLog(HttpServletRequest request, LogAbstract logAbstract) {
        logAbstract.setRemoteIp(WebUtil.getIP(request));
        logAbstract.setUserAgent(request.getHeader(WebUtil.USER_AGENT_HEADER));
        logAbstract.setRequestUri(UrlUtil.getPath(request.getRequestURI()));
        logAbstract.setMethod(request.getMethod());
        logAbstract.setParams(WebUtil.getRequestParamString(request));
        logAbstract.setCreateBy(SecureUtil.getUserAccount(request));
    }

    /**
     * 向log中添加补齐其他的信息（eg：blade、server等）
     *
     * @param logAbstract     日志基础类
     * @param bladeProperties 配置信息
     * @param serverInfo      服务信息
     */
    public static void addOtherInfoToLog(LogAbstract logAbstract, WhaleProperties bladeProperties, ServerInfo serverInfo) {
        logAbstract.setServiceId(bladeProperties.getName());
        logAbstract.setServerHost(serverInfo.getHostName());
        logAbstract.setServerIp(serverInfo.getIpWithPort());
        logAbstract.setEnv(bladeProperties.getEnv());
        logAbstract.setCreateTime(LocalDateTime.now());

        //这里判断一下params为null的情况，否则blade-log服务在解析该字段的时候，可能会报出NPE
        if (logAbstract.getParams() == null) {
            logAbstract.setParams(StringPool.EMPTY);
        }
    }
}