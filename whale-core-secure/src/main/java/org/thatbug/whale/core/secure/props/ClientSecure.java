package org.thatbug.whale.core.secure.props;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端令牌认证信息
 *
 * @author qzl
 * @date 15:19 2019/9/17
 */
@Data
public class ClientSecure {

    private String clientId;

    private final List<String> pathPatterns = new ArrayList<>();

}