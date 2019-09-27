package org.thatbug.whale.core.tool.support.xss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * xss配置类
 *
 * @author qzl
 * @date 14:04 2019/9/17
 */
@Data
@ConfigurationProperties("whale.xss.url")
public class XssProperties {

    private final List<String> excludePatterns = new ArrayList<>();

}