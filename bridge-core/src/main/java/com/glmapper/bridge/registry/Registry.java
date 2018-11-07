package com.glmapper.bridge.registry;

import com.glmapper.bridge.registry.config.RegistryConfig;

/**
 * Registry
 *
 * 将 Registry 抽离出来为了后面提供多注册中心支持
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午2:00
 **/
public abstract class Registry {
    /**
     * 注册中心服务配置
     */
    protected RegistryConfig registryConfig;

    /**
     * 注册中心配置
     *
     * @param registryConfig 注册中心配置
     */
    protected Registry(RegistryConfig registryConfig) {
        this.registryConfig = registryConfig;
    }

    /**
     * 启动
     *
     * @return is started
     */
    public abstract boolean start();
}
