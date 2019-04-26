package com.itcast.basic.web.controller.freemarker;

import com.itcast.basic.web.util.TowCodeCreateUtil;
import com.itcast.basic.web.vo.UserInfoVO;
import com.sdk.common.util.ImageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * Created by treey.qian on 2017/10/31.
 */
@RequestMapping("freemarker")
@Controller
public class FreemarkerController {
    private static Log logger = LogFactory.getLog(FreemarkerController.class);


    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView();
        UserInfoVO userInfo = new UserInfoVO(2011416842, "Lily", "wuhan");
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/code", method = {RequestMethod.GET})
    public ModelAndView getCode() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("code");
        return modelAndView;
    }

    //访问二维码登录页面
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/img", method = {RequestMethod.GET})
    public void img(HttpServletResponse response, @RequestParam("uuid") String uuid) {
        try {
            logger.info("enter img  uuid" + uuid);
            String content = "http://10.108.29.240:8080/sdk-service/freemarker/check?uuid=" + uuid, imgType = "png";
            //利用图片工具生成图片实例
            BufferedImage bufferedImage = TowCodeCreateUtil.qRCodeCommon(content, imgType, null);
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

    @RequestMapping(value = "/reset", method = {RequestMethod.GET})
    @ResponseBody
    public String reset() {
        StringBuilder jsonStr = new StringBuilder();
        try {
            logger.info("enter reset");
            String uuid = "5c9a34340bbc44b69563745c93603524";
            String content = "http://10.108.29.240:8080/sdk-service/freemarker/img?uuid=" + uuid;
            jsonStr.append("uuid=").append(uuid).append(";qrCodeImg=").append(content);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return jsonStr.toString();
    }


    @RequestMapping(value = "/check", method = {RequestMethod.GET})
    public ModelAndView check(@RequestParam("uuid") String uuid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uuid", uuid);
        modelAndView.setViewName("check");
        return modelAndView;
    }

    @RequestMapping(value = "/auth", method = {RequestMethod.POST})
    public ModelAndView auth(@RequestParam("uuid") String uuid, @RequestParam("loginName") String loginName) {
        boolean isSuccess = redisTemplate.hasKey(uuid);
        logger.info("uuid=" + uuid + " loginName=" + loginName + " isSuccess=" + isSuccess);
        ModelAndView modelAndView = new ModelAndView();
        if (isSuccess) {
            modelAndView.setViewName("fail");
            return modelAndView;
        }
        UserInfoVO userInfo = new UserInfoVO(2011416842, loginName, "wuhan");
        redisTemplate.opsForValue().set(uuid, userInfo.toString());
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/authUser", method = {RequestMethod.GET})
    @ResponseBody
    public String authUser(@RequestParam("uuid") String uuid) {
        long timeOut = 5 * 60 * 1000, waitTime = 0;
        while (true) {
            Object object = redisTemplate.opsForValue().get(uuid);
            logger.info("authUser=" + object + " uuid=" + uuid);
            if (object == null) {
                try {
                    Thread.sleep(500);
                    waitTime += 5000;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (waitTime >= timeOut) {
                    return "fail";
                }
            } else {
                redisTemplate.delete(uuid);
                return "success";
            }
        }
    }
}
