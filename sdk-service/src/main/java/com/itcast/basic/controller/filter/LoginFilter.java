package com.itcast.basic.controller.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("enter into LoginFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("enter into LoginFilter destroy");
    }
}
