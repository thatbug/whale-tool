package org.thatbug.whale.core.secure.interceptor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thatbug.whale.core.secure.WhaleUser;
import org.thatbug.whale.core.secure.utils.SecureUtil;
import org.thatbug.whale.core.tool.api.R;
import org.thatbug.whale.core.tool.api.ResultCode;
import org.thatbug.whale.core.tool.constant.WhaleConstant;
import org.thatbug.whale.core.tool.jackson.JsonUtil;
import org.thatbug.whale.core.tool.utils.StringUtil;
import org.thatbug.whale.core.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 客户端校验
 *
 * @author qzl
 * @date 15:22 2019/9/17
 */
@Slf4j
@AllArgsConstructor
public class ClientInterceptor extends HandlerInterceptorAdapter {

    private final String clientId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        WhaleUser user = SecureUtil.getUser();
        if (user != null && StringUtil.equals(clientId, SecureUtil.getClientIdFromHeader()) && StringUtil.equals(clientId, user.getClientId())) {
            return true;
        } else {
            log.warn("客户端认证失败，请求接口：{}，请求IP：{}，请求参数：{}", request.getRequestURI(), WebUtil.getIP(request), JsonUtil.toJson(request.getParameterMap()));
            R result = R.fail(ResultCode.UN_AUTHORIZED);
            response.setHeader(WhaleConstant.CONTENT_TYPE_NAME, MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding(WhaleConstant.UTF_8);
            response.setStatus(HttpServletResponse.SC_OK);
            try {
                response.getWriter().write(Objects.requireNonNull(JsonUtil.toJson(result)));
            } catch (IOException ex) {
                log.error(ex.getMessage());
            }
            return false;
        }
    }

}