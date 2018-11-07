package com.glmapper.bridge.registry;

import com.glmapper.bridge.registry.config.RegistryConfig;

/**
 * RegistryFactory
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午1:59
 **/
public class RegistryFactory {

    private static volatile Registry registry = null;

    public static synchronized Registry getRegistry(RegistryConfig registryConfig){
        if (registry == null){
            synchronized (RegistryFactory.class){
                if (registry==null){
                    registry = new ZookeeperRegistry(registryConfig);
                }
            }
        }
        return registry;
    }
}
