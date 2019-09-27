package org.thatbug.whale.core.secure; /**
 * 用户实体
 *
 * @author qzl
 * @date 14:53 2019/9/17
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author qzl
 * @date 14:54 2019/9/17
 */
@Data
public class WhaleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 客户端id
     */
    @ApiModelProperty(hidden = true)
    private String clientId;

    /**
     * 用户id
     */
    @ApiModelProperty(hidden = true)
    private Integer userId;
    /**
     * 租户ID
     */
    @ApiModelProperty(hidden = true)
    private String tenantId;
    /**
     * 昵称
     */
    @ApiModelProperty(hidden = true)
    private String userName;
    /**
     * 账号
     */
    @ApiModelProperty(hidden = true)
    private String account;
    /**
     * 角色id
     */
    @ApiModelProperty(hidden = true)
    private String roleId;
    /**
     * 角色名
     */
    @ApiModelProperty(hidden = true)
    private String roleName;

}

