package com.itcast.basic.controller.authlogin;

import com.itcast.basic.controller.util.Image;
import com.itcast.basic.controller.util.ImageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/1/27.
 */
@Controller
@RequestMapping("/image")
public class AuthImageController {
    private static Log logger = LogFactory.getLog(AuthImageController.class);

    //图片验证码生成器
    @RequestMapping("/create")
    public void valicode(HttpServletResponse response, HttpSession session)   {
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
