package com.itcast.basic.mybatis.dynamicsqldetail;

import com.itcast.basic.mybatis.dynamicsqldetail.model.User;
import com.itcast.basic.mybatis.dynamicsqldetail.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/14.
 */
public class DynamicSqlDetailsMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DynamicSqlDetailsMain");
            Reader reader = Resources.getResourceAsReader("mybatis/dynamicsqldetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            UserParams userParams = new UserParams();
//            userParams.setName("lily0");
//            userParams.setSchool("school0");
//            System.out.println("userParams=" + userParams);
//            List<User> userList = userMapper.selectUserByCondition(userParams);
//            System.out.println("size is " + userList.size());
//            for (User user : userList) {
//                System.out.println("user=" + user);
//            }

//            List<User> usersList = userMapper.selectUserByName("lily");
//            System.out.println("size is " + usersList.size());
//            for (User user : usersList) {
//                System.out.println("user=" + user);
//            }

//            UserParams dynaParams = new UserParams();
//            dynaParams.setId(4);
//            dynaParams.setName("lily0");
//            dynaParams.setSchool("school0");
//            dynaParams.setNickName("nickName5");
//            List<User> dynaParamsUsersList = userMapper.selectUser(dynaParams);
//            System.out.println("size is " + dynaParamsUsersList.size());
//            for (User user : dynaParamsUsersList) {
//                System.out.println("user=" + user);
//            }

            User user = userMapper.selectUserById(5);
            System.out.println("user=" + user);


//            UserParams updateParam = new UserParams();
//            updateParam.setId(1);
//            updateParam.setName("lily");
//            updateParam.setSchool("beijing");
//            System.out.println("updateParam=" + updateParam);
//            int result = userMapper.updateUserById(updateParam);
//            System.out.println("result=" + result);
//            if (result > 0) {
//                sqlSession.commit();
//            } else {
//                sqlSession.rollback();
//            }

//            List<Long> ids = new ArrayList<>();
//            ids.add(1l);
//            ids.add(2l);
//            int result = userMapper.deleteByIds(ids);
//            if (result > 0) {
//                sqlSession.commit();
//            } else {
//                sqlSession.rollback();
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
