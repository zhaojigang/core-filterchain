package com.core;

/**
 * 过滤器
 *
 * @author zhaojigang
 * @date 2019/1/30
 */
public interface Filter {

    /**
     * 是否需要加载该 filter
     */
    boolean needToLoad();

    /**
     * 过滤
     */
    Response filter(Request request, Invoker nextInvoker);
}
