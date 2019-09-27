package org.thatbug.whale.core.mybatis.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 租户基础实体类
 *
 * @author qzl
 * @date 18:48 2019/9/17
 */
@Data
public class TenantEntity extends BaseEntity {

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantId;

}

