package com.glmapper.bridge.registry;

import com.glmapper.bridge.exception.BridgeRpcRuntimeException;
import com.glmapper.bridge.registry.config.RegistryConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ZookeeperRegistry
 *
 * 负责与 zookeeper 进行交互，完成服务注册、发现、节点监听等
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午12:15
 **/
public class ZookeeperRegistry extends Registry{

    /**
     * slf4j Logger for this class
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ZookeeperRegistry.class);


    private static final String CONTEXT_SEP = "/";

    /**
     * Root path of registry data
     */
    private String                            rootPath = CONTEXT_SEP;

    /**
     * Zookeeper zkClient
     */
    private CuratorFramework curatorClient;

    public ZookeeperRegistry(RegistryConfig registryConfig){
        super(registryConfig);
        this.registryConfig=registryConfig;
        initCuratorClient();
    }

    /**
     * 初始化 zk 客户端
     */
    private synchronized void initCuratorClient() {
        if (curatorClient != null) {
            return;
        }
        // xxx:2181,yyy:2181
        String address = registryConfig.getAddress();
        if (StringUtils.isEmpty(address)) {
            throw new BridgeRpcRuntimeException("Address of zookeeper registry is empty.");
        }
        int idx = address.indexOf(CONTEXT_SEP);
        if (idx > 0){
            throw new BridgeRpcRuntimeException("Address of zookeeper registry is illegal.");
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(
                    "Init ZookeeperRegistry with address {}, root path is {}.",
                    address, rootPath);
        }
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curatorClient = CuratorFrameworkFactory.builder()
                .connectString(address)
                .sessionTimeoutMs(registryConfig.getSession() * 3)
                .connectionTimeoutMs(registryConfig.getTimeout())
                .canBeReadOnly(false)
                .retryPolicy(retryPolicy)
                .defaultData(null)
                .build();
    }

    /**
     * 启动客户端
     * @return
     */
    @Override
    public synchronized boolean start() {
        if (curatorClient == null) {
            LOGGER.warn("Start zookeeper registry must be do init first!");
            return false;
        }
        if (curatorClient.getState() == CuratorFrameworkState.STARTED) {
            return true;
        }
        try {
            curatorClient.start();
        } catch (Exception e) {
            throw new BridgeRpcRuntimeException("Failed to start zookeeper zkClient", e);
        }
        return curatorClient.getState() == CuratorFrameworkState.STARTED;
    }

    /**
     * 关闭客户端
     */
    public void destroy() {
        if (curatorClient != null && curatorClient.getState() == CuratorFrameworkState.STARTED) {
            curatorClient.close();
        }
    }
}
