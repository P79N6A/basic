package com.itcast.basic.web.controller.common;

import com.sdk.common.model.Image;
import com.sdk.common.util.ImageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/1/27.
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    private static Log logger = LogFactory.getLog(CommonController.class);

    //验证referer
    @RequestMapping(value = "/show/referer", method = RequestMethod.POST)
    @ResponseBody
    public String showReferer(HttpServletRequest request) {
        try {
            logger.info("enter into CommonController,  show Referer ");
            String referer = request.getHeader("Referer");
            logger.info("referer= " + referer);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return "success";
    }

    //验证session
    @RequestMapping(value = "/create/session", method = RequestMethod.POST)
    @ResponseBody
    public String createLogFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("enter into CommonController,create session ");
            String name = request.getParameter("name");
            String value = request.getParameter("value");
            request.getSession().setAttribute(name, value);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return "success";
    }


    //图片验证码生成器
    @RequestMapping(value = "/create/valicode", method = RequestMethod.GET)
    public void valicode(HttpServletResponse response, HttpSession session) {
        try {
            logger.info("enter create image ");
            //利用图片工具生成图片实例
            Image image = ImageUtil.createImage();
            //获取图片验证码
            String imageCode = image.getCode();
            //将验证码存入Session
            session.setAttribute(ImageUtil.IMAGE_CODE, imageCode);
            //获取图片流
            BufferedImage bufferedImage = image.getBufferedImage();
            //设置content-type
            response.setContentType(ImageUtil.PNG_TYPE);
            //获得写入流
            OutputStream outputStream = response.getOutputStream();
            //写入图片验证吗
            ImageIO.write(bufferedImage, ImageUtil.PNG, outputStream);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }

}
