package com.glmapper.bridge.registry.config;

/**
 * ServiceConfig  服务提供配置类
 *
 * <bridge:service/>
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 上午11:12
 **/
public class ServiceConfig {

    private String interfaceName;

    private String ref;

    private String group;

    private String loadBalance;

    private int timeout;

    private int retries;

    private int weight;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(String loadBalance) {
        this.loadBalance = loadBalance;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
