package com.itcast.basic.controller.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/1/27.
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    private static Log logger = LogFactory.getLog(CommonController.class);

    @RequestMapping(value = "/create/logfile", method = RequestMethod.POST)
    @ResponseBody
    public String createLogFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("enter into CommonController,creating log file ");
            String name = request.getParameter("name");
            String value = request.getParameter("value");
            request.getSession().setAttribute(name, value);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return "success";
    }

}
