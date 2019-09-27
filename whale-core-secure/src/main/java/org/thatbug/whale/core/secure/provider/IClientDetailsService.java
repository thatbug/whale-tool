package org.thatbug.whale.core.secure.provider;

/**
 * 多终端注册接口
 *
 * @author qzl
 * @date 15:28 2019/9/17
 */
public interface IClientDetailsService {

    /**
     * 根据clientId获取Client详情
     *
     * @param clientId 客户端id
     * @return IClientDetails
     */
    IClientDetails loadClientByClientId(String clientId);

}
