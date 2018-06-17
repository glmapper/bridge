package com.glmapper.bridge.core;

/**
 * 封装了暴露的服务信息
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/17
 */
public interface Soldier<T> extends Target {

    /**
     * 获取服务接口信息
     *
     * @return 服务接口信息
     */
    Class<T> getInterface();

    /**
     * 执行任务
     *
     * @param task 任务信息
     * @return 执行结果
     */
    Result execute(Task task);
}
