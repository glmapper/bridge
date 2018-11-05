package com.glmapper.bridge.client.proxy;

import com.glmapper.bridge.common.BridgeUrl;
import com.glmapper.bridge.common.Invoker;

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

//    @SuppressWarnings("unchecked")
//    public <T> T create(Class<T> interfaceClass) {
//        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
//                new Class[]{interfaceClass}, this);
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        // 1. 获取远程服务地址
//
//        // 2. 调用远程服务
//
//        // 3. 返回调用结果
//        return null;
//    }
}
