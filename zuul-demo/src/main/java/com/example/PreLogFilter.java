package com.example;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class PreLogFilter extends ZuulFilter {

    /**
     * pre请求之前
     * route用于将请求路由转到微服务
     * post路由到微服务以后执行
     * error在其他阶段发生错误的时候执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * true返回一个boolean判断该过滤器是否要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器执行具体内容
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("---》路由获取所有参数值" + request.getParameterMap().toString());
        System.out.println(request.getHeader("token"));

        return "没权限";
    }
}
