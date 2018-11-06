package com.glmapper.bridge.client.proxy;

import com.glmapper.bridge.core.BridgeUrl;
import com.glmapper.bridge.core.Invoker;

/**
 * ProxyFactory
 *
 * @author zhenyu.szy
 * @date 2018/11/3
 */
public interface ProxyFactory {

    /**
     * @param invoker
     * @param <T>
     * @return
     */
    <T> T getProxy(Invoker<T> invoker);

    /**
     *
     * @param proxy
     * @param type
     * @param url
     * @param <T>
     * @return
     */
    <T> Invoker<T> getInvoker(T proxy, Class<T> type, BridgeUrl url);
}
