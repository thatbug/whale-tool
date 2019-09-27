package org.thatbug.whale.core.secure;

import lombok.Data;

/**
 * TokenInfo
 *
 * @author qzl
 * @date 14:55 2019/9/17
 */
@Data
public class TokenInfo {

    /**
     * 令牌值
     */
    private String token;

    /**
     * 过期秒数
     */
    private int expire;

}
