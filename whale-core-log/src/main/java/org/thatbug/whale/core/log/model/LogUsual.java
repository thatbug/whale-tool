package org.thatbug.whale.core.log.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author qzl
 * @date 16:18 2019/9/19
 */
@Data
@TableName("whale_log_usual")
public class LogUsual extends LogAbstract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志级别
     */
    private String logLevel;
    /**
     * 日志业务id
     */
    private String logId;
    /**
     * 日志数据
     */
    private String logData;


}