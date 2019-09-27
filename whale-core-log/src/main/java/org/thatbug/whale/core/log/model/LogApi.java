package org.thatbug.whale.core.log.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * LogApi
 *
 * @author qzl
 * @date 16:19 2019/9/19
 */
@Data
@TableName("blade_log_api")
public class LogApi extends LogAbstract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;

}