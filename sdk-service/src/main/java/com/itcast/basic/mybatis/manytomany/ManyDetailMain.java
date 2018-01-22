package com.itcast.basic.mybatis.manytomany;

import com.itcast.basic.mybatis.manytomany.model.Role;
import com.itcast.basic.mybatis.manytomany.model.User;
import com.itcast.basic.mybatis.manytomany.service.RoleMapper;
import com.itcast.basic.mybatis.manytomany.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ManyDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ManyDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/manytomany/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            int result = 0;
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            List<Role> roleList = roleMapper.findRolesByUserId(1);
            Role role = roleMapper.findRoleById(1);
            System.out.println("role=" + role);
//            System.out.println("size of roleList is " + roleList.size());
//            for (int i = 0; i < 10; i++) {
//                Role role = new Role();
//                role.setRoleName("t_role" + i);
//                role.setNote("this is a t_role" + i);
//                role.setUserId(1);
//                result += roleMapper.insertRole(role);
//            }
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            List<User> userList = userMapper.findUsersByRoleId(1);
//            System.out.println("size of userList is " + userList.size());
            User user = userMapper.findUserById(1);
            System.out.println("user=" + user);
//            for (int i = 0; i < 10; i++) {
//                User user = new User();
//                user.setNote("this is user"+i);
//                user.setName("name"+i);
//                user.setSchool("school"+i);
//                user.setNickName("nickName"+i);
//                user.setRoleId(1);
//                result += userMapper.insertUser(user);
//            }
            System.out.println("result=" + result);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
