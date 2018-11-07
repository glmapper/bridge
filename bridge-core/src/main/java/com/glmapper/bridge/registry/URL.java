package com.glmapper.bridge.registry;

import java.util.Map;

/**
 * URL
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午12:00
 **/
public class URL {
    /** 协议名称 */
    private String protocol;
    private String host;
    private int port;
    /** interfaceName */
    private String interfaceName;
    private Map<String, String> parameters;
    private volatile transient Map<String, Number> numbers;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(Map<String, Number> numbers) {
        this.numbers = numbers;
    }
}
