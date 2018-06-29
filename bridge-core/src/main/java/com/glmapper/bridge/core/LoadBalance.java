package com.glmapper.bridge.core;

import java.util.List;

/**
 * @author: Jerry
 * @date: 2018/6/29
 */
public interface LoadBalance {

    /**
     *
     * @param soldiers
     * @param location
     * @param task
     * @return
     */
    <T> Soldier<T> select(List<Soldier<T>> soldiers, Location location, Task task);
}
