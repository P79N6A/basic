package com.itcast.basic.mybatis.mybatisspring.transactionmanager.service;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import com.itcast.basic.mybatis.mybatisspring.transactionmanager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by treey.qian on 2018/1/15.
 */
@Service("userService")
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;

    /**
     * 测试事务配置已生效
     *
     * @return
     */
    @Transactional
    public int testTransaction() {
        System.out.println("enter into testTransaction");
        int result = 0;
        User user = new User();
        user.setId(3);
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("root");
        userDao.updateUser(user);
        System.out.println("enter into testTransaction sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into testTransaction commit");
        return result;
    }

    /**
     * 测试事务是基于userServiceProxy生效
     *
     * @return
     */
    @Transactional
    public int testTrtansactionTarget1() {
        System.out.println("enter into testTrtansactionTarget1");
        int result = 0;
        User user = new User();
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("lucy");
        result += userService.insertUser(user);
        System.out.println("enter into testTrtansactionTarget1 insert end");
        user.setId(5);
        result += userDao.updateUser(user);
        System.out.println("enter into testTrtansactionTarget1 sleep");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into testTrtansactionTarget1 commit");
        return result;
    }

    /**
     * 测试事务是基于userServiceProxy生效
     *
     * @return
     */
    @Transactional
    public int testTrtansactionTarget0() {
        System.out.println("enter into testTrtansactionTarget0");
        int result = 0;
        User user = new User();
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("lucy");
        result += insertUser(user);
        System.out.println("enter into testTrtansactionTarget0 insert end");
        user.setId(4);
        result += userDao.updateUser(user);
        System.out.println("enter into testTrtansactionTarget0 sleep");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into testTrtansactionTarget0 commit");
        return result;
    }

    /**
     * 测试事务在线程中的传播
     *
     * @return
     */
    public int testTransactionInThread() {
        int result = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter into thread transaction");
                User user = new User();
                user.setId(6);
                user.setName("admin");
                user.setSchool("wuhan");
                user.setNickName("lucy");
                userService.updateUserInThread(user);
            }
        }).start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 测试事务在同service方法间传播
     *
     * @return
     */
    public int testTransactionServiceMethod() {
        int result = 0;
        User user = new User();
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("lucy");
        userService.insertUser(user);
        System.out.println("enter into testTransactionServiceMethod insert end");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.setId(7);
        userService.updateUser(user);
        System.out.println("enter into testTransactionServiceMethod update end");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Transactional
    public int updateUserInThread(User user) {
        int result = userDao.updateUser(user);
        System.out.println("enter into thread transaction sleep");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into thread transaction commit");
        return result;
    }

    /**
     * 测试嵌套事务的传播
     *
     * @return
     */
    @Transactional
    public int testNestedTransaction() {
        int result = 0;
        User user = new User();
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("lucy");
        result += userService.insertUserInNested(user);
        System.out.println("enter into testNestedTransaction nested transaction end");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into testNestedTransaction  transaction end");
        return result;
    }


    /**
     * 测试嵌套事务回滚机制
     *
     * @return
     */
    @Transactional
    public int testRollbackNestedTransaction() {
        int result = 0;
        User user = new User();
        user.setName("admin");
        user.setSchool("wuhan");
        user.setNickName("lucy");
        try {
            result += userService.rollbackInsertUserInNested(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("message is " + e.getMessage());
        }
        System.out.println("enter into testRollbackNestedTransaction nested transaction end");
        result += userDao.insertUser(user);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("enter into testRollbackNestedTransaction  transaction end");
        return result;
    }


    @Transactional
    public int updateUser(User user) {
        int result = userDao.updateUser(user);
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertUser(User user) {
        int result = userDao.insertUser(user);
        return result;
    }

    @Transactional(propagation = Propagation.NESTED)
    public int insertUserInNested(User user) {
        int result = userDao.insertUser(user);
        return result;
    }


    @Transactional(propagation = Propagation.NESTED)
    public int rollbackInsertUserInNested(User user) {
        int result = userDao.insertUser(user);
        throw new IllegalArgumentException("rollback");
    }
}
