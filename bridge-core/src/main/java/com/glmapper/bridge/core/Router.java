package com.glmapper.bridge.core;

import java.util.List;

/**
 * 路由器 Router
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/18
 */
public interface Router {

    /**
     * 获取 router 的定位
     *
     * @return 定位 Location
     */
    Location getLocation();

    /**
     * 路由
     *
     * @param soldiers 执行器信息
     * @param location 定位信息
     * @param task     任务详情
     * @return 执行器列表
     */
    <T> List<Soldier<T>> route(List<Soldier<T>> soldiers, Location location, Task task);
}
