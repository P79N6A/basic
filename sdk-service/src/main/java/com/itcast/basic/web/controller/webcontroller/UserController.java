package com.itcast.basic.web.controller.webcontroller;

import com.itcast.basic.web.response.HttpStatus;
import com.itcast.basic.web.response.ResponseEntity;
import com.itcast.basic.web.vo.UserVO;
import com.sdk.model.UserModel;
import com.sdk.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/1/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private MapperFacade beanMapper;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseEntity createUser(UserVO userVO) {
        int result = 0;
        try {
            logger.info("enter into create user controller");
            result = userService.insert(beanMapper.map(userVO, UserModel.class));
            logger.info("insert user data success, result=" + result);
        } catch (Exception e) {
            logger.info("error message is {}", e);
            return new ResponseEntity(HttpStatus.ERROR, "创建用户失败");
        }
        return new ResponseEntity(HttpStatus.OK, "创建用户成功");
    }

}
