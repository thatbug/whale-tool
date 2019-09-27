package org.thatbug.whale.core.secure.auth;

import org.thatbug.whale.core.secure.utils.SecureUtil;
import org.thatbug.whale.core.tool.constant.RoleConstant;
import org.thatbug.whale.core.tool.utils.CollectionUtil;
import org.thatbug.whale.core.tool.utils.Func;
import org.thatbug.whale.core.tool.utils.StringUtil;

/**
 * 权限判断
 *
 * @author qzl
 * @date 15:55 2019/9/17
 */
public class AuthFun {

    /**
     * 放行所有请求
     *
     * @return {boolean}
     */
    public boolean permitAll() {
        return true;
    }

    /**
     * 只有超管角色才可访问
     *
     * @return {boolean}
     */
    public boolean denyAll() {
        return hasRole(RoleConstant.ADMIN);
    }

    /**
     * 判断是否有该角色权限
     *
     * @param role 单角色
     * @return {boolean}
     */
    public boolean hasRole(String role) {
        return hasAnyRole(role);
    }

    /**
     * 判断是否有该角色权限
     *
     * @param role 角色集合
     * @return {boolean}
     */
    public boolean hasAnyRole(String... role) {
        String userRole = SecureUtil.getUser().getRoleName();
        if (StringUtil.isBlank(userRole)) {
            return false;
        }
        String[] roles = Func.toStrArray(userRole);
        for (String r : role) {
            if (CollectionUtil.contains(roles, r)) {
                return true;
            }
        }
        return false;
    }

}
