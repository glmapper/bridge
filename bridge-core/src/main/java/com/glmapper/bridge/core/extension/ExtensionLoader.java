package com.glmapper.bridge.core.extension;

/**
 * 扩展加载器，SPI 机制
 *
 * @author: Jerry
 * @date: 2018/6/18
 */
public class ExtensionLoader {

    /**
     * 通用的加载扩展服务的目录
     */
    private static final String SERVICES_DIRECTORY        = "META-INF/services/";

    /**
     * bridge 特有的加载扩展服务的目录
     */
    private static final String BRIDGE_DIRECTORY          = "META-INF/bridge/";

    /**
     * bridge 内置的服务所在目�?
     */
    private static final String BRIDGE_INTERNAL_DIRECTORY = BRIDGE_DIRECTORY + "internal/";
}
