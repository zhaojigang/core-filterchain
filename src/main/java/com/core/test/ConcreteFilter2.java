package com.core.test;

import com.core.Filter;
import com.core.Invoker;
import com.core.Request;
import com.core.Response;

/**
 * @author zhaojigang
 * @date 2019/1/31
 */
public class ConcreteFilter2 implements Filter {
    @Override
    public boolean needToLoad() {
        return true;
    }

    @Override
    public Response filter(Request request, Invoker nextInvoker) {
        System.out.println("filter2 - before " + request);
        Response response = nextInvoker.invoke(request);
        System.out.println("filter2 - after " + request);
        return response;
    }
}
