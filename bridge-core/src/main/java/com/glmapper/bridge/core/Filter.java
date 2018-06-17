package com.glmapper.bridge.core;

/**
 * 过滤器
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/18
 */
public interface Filter {

    /**
     * 执行任务
     *
     * @param task 任务信息
     * @return 执行结果
     */
    Result execute(Task task);
}
