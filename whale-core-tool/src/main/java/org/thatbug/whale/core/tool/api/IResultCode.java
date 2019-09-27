package org.thatbug.whale.core.tool.api;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @author qzl
 * @date 11:51 2019/9/17
 */
public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
