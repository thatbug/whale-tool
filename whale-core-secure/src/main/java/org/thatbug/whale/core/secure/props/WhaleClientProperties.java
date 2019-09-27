package org.thatbug.whale.core.secure.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端校验配置
 *
 * @author qzl
 * @date 15:18 2019/9/17
 */
@Data
@ConfigurationProperties("whale.secure")
public class WhaleClientProperties {

    private final List<ClientSecure> client = new ArrayList<>();

}
