package com.glmapper.bridge.core;

/**
 * 封装靶子信息
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/17
 */
public interface Target {

    /**
     * 获取目标的定位 Location
     *
     * @return Location
     */
    Location getLocation();

    /**
     * 目标是否存活
     *
     * @return 存活状态
     */
    boolean isAlive();

    /**
     * 击杀目标
     */
    void kill();
}
