package com.itcast.basic.web.controller.webcontroller;

import com.itcast.basic.web.response.HttpStatus;
import com.itcast.basic.web.response.PageResult;
import com.itcast.basic.web.response.ResponseEntity;
import com.itcast.basic.web.vo.UserVO;
import com.sdk.common.model.ConditionParam;
import com.sdk.common.model.QueryConditionParam;
import com.sdk.common.model.SortColumn;
import com.sdk.model.UserModel;
import com.sdk.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.itcast.basic.web.response.Page.DEFAULT_CURRENT_PAGE;
import static com.itcast.basic.web.response.Page.DEFAULT_PAGE_SIZE;
import static com.itcast.basic.web.util.BeanFactoryUtil.createResultColumns;
import static com.itcast.basic.web.util.BeanFactoryUtil.createSortColumns;

/**
 * Created by Administrator on 2018/1/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private MapperFacade beanMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(UserVO userVO) {
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

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseEntity detail(@RequestParam("id") long id) {
        UserVO userVO = null;
        try {
            logger.info("enter into detail user controller");
            UserModel userModel = userService.findUserModelById(id);
            userVO = beanMapper.map(userModel, UserVO.class);
            logger.info("find user data success, userVO=" + userVO);
        } catch (Exception e) {
            logger.info("error message is {}", e);
            return new ResponseEntity(HttpStatus.ERROR, "查询用户失败");
        }
        return new ResponseEntity(HttpStatus.OK, userVO);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(UserVO userVO) {
        int result = 0;
        try {
            logger.info("enter into update user controller");
            result = userService.updateUserModelById(beanMapper.map(userVO, UserModel.class));
            logger.info("update user data success, result=" + result);
        } catch (Exception e) {
            logger.info("error message is {}", e);
            return new ResponseEntity(HttpStatus.ERROR, "更新用户失败");
        }
        return new ResponseEntity(HttpStatus.OK, "更新用户成功");
    }

    @RequestMapping(value = "/condition", method = RequestMethod.POST)
    public ResponseEntity condition(UserVO userVO) {
        try {
            logger.info("enter into condition user controller");
            List<UserVO> userVOList = new ArrayList<>();
            PageResult pageResult = new PageResult();
            int pageSize = userVO.getPageSize();
            pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
            int currentPage = userVO.getCurrentPage();
            currentPage = currentPage > 0 ? currentPage : DEFAULT_CURRENT_PAGE;
            int offset = (currentPage - 1) * pageSize;
            int fetchSize = pageSize;
            ConditionParam conditionParam = new ConditionParam(offset, fetchSize, userVO);
            int total = userService.countCondition(conditionParam);
            int totalPages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
            if (totalPages == 0) {
                currentPage = 1;
            } else {
                currentPage = currentPage > totalPages ? totalPages : currentPage;
                List<String> resultColumnsList = new ArrayList<>();
                List<SortColumn> sortColumnList = new ArrayList<>();
                createSortColumns(userVO.getResultColumns(), resultColumnsList, userVO.getSortColumn(), sortColumnList);
                QueryConditionParam queryConditionParam = new QueryConditionParam(offset, fetchSize, createResultColumns(resultColumnsList, UserVO.class), createSortColumns(sortColumnList, UserVO.class));
                queryConditionParam.setCondition(userVO);
                userVOList = beanMapper.mapAsList(userService.findUserModelsByCondition(queryConditionParam), UserVO.class);
            }
            pageResult.setTotal(total);
            pageResult.setTotalPages(totalPages);
            pageResult.setCurrentPage(currentPage);
            pageResult.setPageSize(pageSize);
            pageResult.setResult(userVOList);
            logger.info("condition user data success, size of results is " + total);
            return new ResponseEntity(HttpStatus.OK, pageResult);
        } catch (Exception e) {
            logger.info("error message is {}", e);
            return new ResponseEntity(HttpStatus.ERROR, "用户条件查询失败");
        }
    }

}
