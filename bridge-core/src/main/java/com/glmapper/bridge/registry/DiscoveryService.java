package com.glmapper.bridge.registry;

import java.util.List;

/**
 * DiscoveryService
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午12:04
 **/
public interface DiscoveryService {

    /**
     * 订阅服务
     * @param url
     */
    void subscribe(URL url);

    /**
     * 取消订阅
     * @param url
     */
    void unsubscribe(URL url);

    /**
     * 发现服务列表
     * @param url
     * @return
     */
    List<URL> discover(URL url);
}
