package com.glmapper.bridge.registry.config;

import com.glmapper.bridge.registry.ZookeeperRegistry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * RegistryConfig 注册中心配置类
 *
 * <bridge:registry/>
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 上午11:10
 **/
public class RegistryConfig implements InitializingBean {

    private String id;

    private String address;

    private int port;

    private int timeout;

    private int session;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
