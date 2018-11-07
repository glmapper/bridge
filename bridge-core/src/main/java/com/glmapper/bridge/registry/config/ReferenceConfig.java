package com.glmapper.bridge.registry.config;

import com.glmapper.bridge.registry.ZookeeperRegistry;
import org.springframework.beans.factory.InitializingBean;

/**
 * ReferenceConfig 服务引用配置类
 *
 * <bridge:reference/>
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 上午11:14
 **/
public class ReferenceConfig {

    private String id;

    private String interfaceName;

    private String group;

    private String targetUrl;

    private int timeout;

    private int retries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
}
