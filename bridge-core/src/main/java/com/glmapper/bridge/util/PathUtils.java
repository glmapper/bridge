package com.glmapper.bridge.util;

import com.glmapper.bridge.registry.config.ReferenceConfig;
import com.glmapper.bridge.registry.config.ServiceConfig;
/**
 * PathUtils
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/6 下午10:53
 **/
public class PathUtils {

    public static String buildProviderPath(String rootPath, ServiceConfig config) {
        return rootPath + "bridge-rpc/" + config.getInterfaceName() + "/providers";
    }

    public static String buildConsumerPath(String rootPath, ReferenceConfig config) {
        return rootPath + "bridge-rpc/" + config.getInterfaceName() + "/consumers";
    }


}
