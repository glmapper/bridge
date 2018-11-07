package com.glmapper.bridge.registry;

import java.util.Collection;

/**
 * RegistryService
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午12:03
 **/
public interface RegistryService {

    /**
     * 向注册中心注册服务
     * @param url
     */
    void register(URL url);

    /**
     * 从注册中心摘除服务
     * @param url
     */
    void unregister(URL url);

    /**
     * 将服务设置为可用，供客户端调用
     * @param url
     */
    void available(URL url);

    /**
     * 禁用服务，客户端无法发现该服务
     * @param url
     */
    void unavailable(URL url);

    /**
     *  获取已注册服务的集合
     * @return
     */
    Collection<URL> getRegisteredServiceUrls();
}
