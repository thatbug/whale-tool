package org.thatbug.whale.core.mybatis.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具
 *
 * @author qzl
 * @date 14:51 2019/9/19
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer size;

    /**
     * 排序的字段名
     */
    @ApiModelProperty(value = "升序的字段")
    private String ascs;

    /**
     * 排序方式
     */
    @ApiModelProperty(value = "倒叙的字段")
    private String descs;

}
