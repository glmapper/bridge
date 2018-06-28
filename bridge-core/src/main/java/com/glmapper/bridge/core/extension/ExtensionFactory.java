package com.glmapper.bridge.core.extension;

/**
 * 扩展工厂
 *
 * @author: Jerry
 * @date: 2018/6/18
 */
@SPI
public interface ExtensionFactory {

    /**
     * 获取扩展实例.
     *
     * @param type 扩展类的对象.
     * @param name 扩展类的全类目.
     * @return 扩展对象实例.
     */
    <T> T getExtension(Class<T> type, String name);

}
