package com.itcast.basic.jpa;

import com.itcast.basic.jpa.domain.User;
import com.itcast.basic.jpa.service.user.UserService;
import com.itcast.basic.jpa.service.user.UserServiceImpl;

/**
 * Created by qfl on 16/6/10.
 */
public class JPADemo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User();
//        user.setName("user");
//        user.setSex(Sex.MAN);
//        List<Order> orders = new ArrayList<>();
//        for (int j = 0; j < 3; j++) {
//            Order order = new Order();
//            order.setPrice(new BigDecimal(200+j));
//            order.setUser(user);
//            order.setNumber(1234567 + j);
//            order.setName("order" + j);
//            orders.add(order);
//        }
//        user.setOrders(orders);
//        userService.saveUser(user);
//        User user = userService.findUserById(5);
//        User user = userService.findUserByName("user");
//        User user = (User) userService.findUsersByCondition("select u from User u where u.id  = 5").get(0);
//        System.out.println(user.getName());
        user.setName("小米");
        userService.saveUser(user);
    }
}
