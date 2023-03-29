package com.gpt.filter;

import com.gpt.holder.RequestHolder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;

@WebFilter(filterName = "requestFilter",urlPatterns = "/*")
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将ServletRequest转换为HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 将HttpServletRequest封装为HttpServletRequestWrapper
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpServletRequest);
        // 将HttpServletRequestWrapper存储到ThreadLocal中
        RequestHolder.set(requestWrapper);
        // 继续执行后续过滤器或Servlet
        chain.doFilter(requestWrapper, response);
        // 在请求处理完成后清除ThreadLocal中的HttpServletRequestWrapper对象
        RequestHolder.remove();
    }
}
