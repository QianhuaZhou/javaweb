package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")//拦截所有请求
public class DemoFilter implements Filter {
    @Override//初始化方法,只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始化方法执行了");
        //Filter.super.init(filterConfig);
    }

    @Override//拦截到请求之后调用,调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DemoFilter拦截到了请求...放行前逻辑");

        chain.doFilter(request, response);//放行

        System.out.println("DemoFilter拦截到了请求...执行放行后逻辑...");
    }

    @Override//销毁方法,只调用一次
    public void destroy() {
        System.out.println("destroy方法执行了");
        //Filter.super.destroy();
    }
}
