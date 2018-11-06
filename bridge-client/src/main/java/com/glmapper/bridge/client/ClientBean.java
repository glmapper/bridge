package com.glmapper.bridge.client;

import com.glmapper.bridge.client.proxy.JdkProxyFactory;
import com.glmapper.bridge.client.proxy.ProxyFactory;
import com.glmapper.bridge.core.Invoker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

/**
 * ClientBean
 *
 * @author zhenyu.szy
 * @date 2018/11/4
 */
public class ClientBean<T> implements FactoryBean, ApplicationContextAware,
                           InitializingBean, DisposableBean, Serializable {

    private static final long             serialVersionUID = -3946021378087142449L;

    private static final ProxyFactory     proxyFactory     = new JdkProxyFactory();

    private ApplicationContext            applicationContext;

    private String                        interfaceName;

    private Class<?>                      interfaceClass;

    private transient volatile T          clientBean;

    private transient volatile Invoker<T> invoker;

    private transient volatile boolean    destroyed;

    private transient volatile boolean    initialized;

    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        // destroy action
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    private synchronized T get() {
        if (destroyed) {
            throw new IllegalStateException("client bean already destroyed!");
        }
        if (clientBean == null) {
            init();
        }
        return clientBean;
    }

    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;
        if (interfaceName == null || interfaceName.length() == 0) {
            throw new IllegalStateException("ClientBean interface not allow null!");
        }
        try {
            interfaceClass = Class.forName(interfaceName, true, Thread.currentThread()
                .getContextClassLoader());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        clientBean = proxyFactory.getProxy(invoker);
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public T getClientBean() {
        return clientBean;
    }

    public void setClientBean(T clientBean) {
        this.clientBean = clientBean;
    }

    public Invoker<T> getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker<T> invoker) {
        this.invoker = invoker;
    }
}
