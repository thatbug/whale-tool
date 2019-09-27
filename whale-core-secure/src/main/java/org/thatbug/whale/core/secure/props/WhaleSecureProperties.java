package org.thatbug.whale.core.secure.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 额外放行配置
 *
 * @author qzl
 * @date 15:16 2019/9/17
 */
@Data
@ConfigurationProperties("whale.secure.url")
public class WhaleSecureProperties {

    private final List<String> excludePatterns = new ArrayList<>();

}