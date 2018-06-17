package com.glmapper.bridge.core;

import java.util.List;

/**
 * 存放 Soldier 清单
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/17
 */
public interface Catalog<T> extends Target {

    /**
     * 获取服务接口
     *
     * @return 服务接口的类信息
     */
    Class<T> getInterface();

    /**
     * 获取可执行任务的 Soldiers
     *
     * @return Soldiers
     */
    List<Soldier> list();
}
