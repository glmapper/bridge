package com.glmapper.bridge.client.proxy;

import com.glmapper.bridge.core.BridgeUrl;
import com.glmapper.bridge.core.Invoker;

/**
 * JdkProxyFactory
 *
 * @author zhenyu.szy
 * @date 2018/11/3
 */
public class JdkProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(Invoker<T> invoker) {
        return null;
    }

    @Override
    public <T> Invoker<T> getInvoker(T proxy, Class<T> type, BridgeUrl url) {
        return null;
    }

}
