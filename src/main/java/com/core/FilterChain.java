package com.core;

import com.core.test.ConcreteFilter1;
import com.core.test.ConcreteFilter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链
 *
 * @author zhaojigang
 * @date 2019/1/30
 */
public class FilterChain {
    public Invoker buildFilterChain(Invoker lastInvoker) {
        Invoker invokerChainHeader = lastInvoker;
        // 1. 查询出所有的过滤器
        List<Filter> filterList = selectFilterList();
        if (filterList != null && filterList.size() > 0) {
            for (int i = filterList.size() - 1; i >= 0; i--) {
                Filter filter = filterList.get(i);
                Invoker nextInvoker = invokerChainHeader;
                invokerChainHeader = request -> filter.filter(request, nextInvoker);
            }
        }
        return invokerChainHeader;
    }

    /**
     * 实际使用中，可以根据SPI机制与自动激活点机制等去获取filter链
     */
    private List<Filter> selectFilterList() {
        List<Filter> filterList = new ArrayList<>();
        ConcreteFilter1 filter1 = new ConcreteFilter1();
        ConcreteFilter2 filter2 = new ConcreteFilter2();
        if (filter1.needToLoad()) {
            filterList.add(filter1);
        }
        if (filter2.needToLoad()) {
            filterList.add(filter2);
        }
        return filterList;
    }
}
