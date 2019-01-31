package com.core.test;

import com.core.FilterChain;
import com.core.Invoker;
import com.core.Request;
import com.core.Response;

/**
 * @author zhaojigang
 * @date 2019/1/31
 */
public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        Invoker invoker = filterChain.buildFilterChain(request -> {
            Response resp = new Response("lastInvoker msg");
            System.out.println("trueInvoker - " + resp);
            return resp;
        });
        Response response = invoker.invoke(new Request("req msg"));
        System.out.println(response);
    }
}
