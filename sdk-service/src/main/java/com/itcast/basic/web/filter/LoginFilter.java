package com.itcast.basic.web.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/27.
 */
public class LoginFilter implements Filter {

    private static Log logger = LogFactory.getLog(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("enter into LoginFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUrl = request.getRequestURI();
        logger.info("enter into LoginFilter doFilter,request url is " + requestUrl);
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("enter into LoginFilter destroy");
    }
}
