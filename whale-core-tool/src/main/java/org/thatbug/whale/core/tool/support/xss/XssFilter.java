package org.thatbug.whale.core.tool.support.xss;

import lombok.AllArgsConstructor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Xss过滤
 *
 * @author qzl
 * @date 14:13 2019/9/17
 */
@AllArgsConstructor
public class XssFilter implements Filter {

    private XssProperties xssProperties;

    @Override
    public void init(FilterConfig config) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        if (xssProperties.getExcludePatterns().stream().anyMatch(path::contains)) {
            chain.doFilter(request, response);
        } else {
            XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
            chain.doFilter(xssRequest, response);
        }
    }

    @Override
    public void destroy() {

    }

}
