package org.thatbug.whale.core.log.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视图实体类
 *
 * @author qzl
 * @date 16:39 2019/9/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogApiVo extends LogApi {
    private static final long serialVersionUID = 1L;

    private String strId;

}

