package com.glmapper.bridge.core;

/**
 * 首席指挥官，指定Soldier执行任务
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/17
 */
public interface Chief {

    /**
     * 指定执行者
     *
     * @param catalog
     * @return
     */
    <T> Soldier<T> assign(Catalog<T> catalog);
}
