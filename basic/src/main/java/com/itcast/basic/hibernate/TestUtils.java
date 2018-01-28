package com.itcast.basic.hibernate;

import com.itcast.basic.hibernate.hibernatebasicconfig.usertype.NameStrategy;
import com.itcast.basic.hibernate.hibernatebasicconfig.usertype.SimpleInterceptor;
import com.itcast.basic.hibernate.hibernateobjectrationalmapper.many2many.Category;
import com.itcast.basic.hibernate.hibernateobjectrationalmapper.many2many.Product;
import com.itcast.basic.hibernate.inheritance.abstractclass.CustomerOrder;
import com.itcast.basic.hibernate.inheritance.abstractclass.Order;
import com.itcast.basic.hibernate.inheritance.abstractclass.ProductOrder;
import com.itcast.basic.hibernate.inheritance.abstractclass.User;
import com.itcast.basic.hibernate.propertiesconfig.Name;
import com.itcast.basic.hibernate.propertiesconfig.UserInfo;
import com.itcast.basic.hibernate.usertypeconfig.AddressType;
import com.itcast.basic.hibernate.usertypeconfig.OrderList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by qfl on 16/7/5.
 */
public class TestUtils {
    public static void main(String[] args) {
//        Configuration configuration = new Configuration()
//                .setNamingStrategy(new SimpleNameStrategy())
//                .setInterceptor(new DataInteceptor())
//                .configure("com/itcast/basic/hibernate/namingstrategy/hibernate.cfg.xml");
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.begin();
//        User user = new User();
//        user.setName("lily");
//        user.setBirthday(new Date());
//        user.setDescription("这是一个测试hibernate的仿佛");
//        user.setSex(Sex.MAN);
//        session.save(user);
//        Customer customer = new Customer();
//        customer.setName("lucy");
//        Address address = new Address();
//        address.setProvince("山东");
//        address.setCity("济南");
//        address.setDistrict("高新区");
//        customer.setHomeAddress(address);
//        session.save(customer);
//        transaction.commit();
//        session.close();
//        Customer u = (Customer) session.initdata(Customer.class, 1);
//        System.out.println(u.getName());
//        Properties properties = new Properties();
//        try {
//            properties.initdata(new FileInputStream("src/com/itcast/basic/hibernate/propertiesconfig/hibernate.properties"));
//            Configuration configuration = new Configuration()
//                    .setProperties(properties)
//                    .addResource("com/itcast/basic/hibernate/propertiesconfig/userInfo.hbm.xml")
//                    .configure();
//            SessionFactory factory = configuration.buildSessionFactory();
//            Session session = factory.openSession();
//            Transaction transaction = session.beginTransaction();
//            transaction.begin();
//            UserInfo info = new UserInfo();
//            Name name = new Name("钱", "福利");
//            info.setDescription("这是一个测试hibernate的方法");
//            info.setNumber("2011416842");
//            info.setSchool("无业游民");
//            info.setName(name);
//            session.save(info);
//            transaction.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Configuration configuration = new Configuration()
//                .configure("com/itcast/basic/hibernate/usertypeconfig/hibernate.cfg.xml");
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.begin();
//        OrderList orderList = new OrderList(21, "taobao购物车", "2011416842", new BigDecimal("9.88"));
//        AddressType address = new AddressType("山东", "济南", "高新区");
//        orderList.setAddress(address);
//        session.save(orderList);
//        transaction.commit();
//        session.close();

//        Configuration configuration = new Configuration()
//                .setInterceptor(new SimpleInterceptor())
//                .setNamingStrategy(new NameStrategy())
//                .configure("com/itcast/basic/hibernate/hibernatebasicconfig/hibernate.cfg.xml");
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        session.close();


        Configuration configuration = new Configuration()
                .configure("com/itcast/basic/hibernate/hibernateobjectrationalmapper/hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Category java = new Category();
        java.setName("java");
        Category ruby = new Category();
        ruby.setName("ruby");
        Category swift = new Category();
        swift.setName("swift");

        Set<Category> categories = new HashSet<>();
        categories.add(java);
        categories.add(ruby);
        categories.add(swift);

        Product product = new Product();
        product.setName("hibernate");

        product.setCategories(categories);

        session.save(java);
        session.save(product);

        transaction.commit();
        session.close();
//        User user = new User();
//        user.setName("lily");
//        UserInfo userInfo = new UserInfo();
//        userInfo.setNickName("扫地僧");
//        userInfo.setAge(22);
//        userInfo.setCompanyName("韩都衣舍");
//        userInfo.setSchool("曲阜师范大学");
//        userInfo.setUser(user);
//        session.save(userInfo);
//        session.save(user);
//        transaction.commit();
//        session.close();
//        UserInfo info = (UserInfo) session.initdata(UserInfo.class, 1);
//        System.out.println(info.getUser().getName());
//        System.out.println(info.getUser().getUserInfo().getAge());


//        Configuration configuration = new Configuration()
//                .configure("com/itcast/basic/hibernate/inheritance/hibernate.cfg.xml");
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.begin();
//
//        User user = new User("lily");
//
//        Order productOrder = new ProductOrder("product", user, 11, new BigDecimal("99.89"), new Date());
//        Order customerOrder = new CustomerOrder("customer", user, 22, new BigDecimal("87.33"), new Date());
//
//        session.save(user);
//        session.save(productOrder);
//        session.save(customerOrder);
//
//        transaction.commit();
//        session.close();

        //        Configuration configuration = new Configuration()
//                .configure("com/itcast/basic/hibernate/inheritance/hibernate.cfg.xml");
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.begin();
//
//        User user = new User("lily");
//
//        Order productOrder = new ProductOrder("product", user, 11, new BigDecimal("99.89"), new Date());
//        Order customerOrder = new CustomerOrder("customer", user, 22, new BigDecimal("87.33"), new Date());
//
//        session.save(user);
//        session.save(productOrder);
//        session.save(customerOrder);
//
//        transaction.commit();
//        session.close();


        //        Set<Item> itemSet = new HashSet<Item>();
//        for (int i = 0; i < 5; i++) {
//            Item item = new Item("item" + i, new BigDecimal("33.90"), "这是一个item" + i, 22);
//            itemSet.add(item);
//        }
//
//        Set<Order> orders = new HashSet<Order>();
//        for (int j = 0; j < 4; j++) {
//            Order order = new Order("1232434" + j, new BigDecimal("32.33"), itemSet);
//            orders.add(order);
//        }
//
//        User user = new User("lily", UtilHelper.getByteFromImageFile("src/com/itcast/basic/hibernate/queryway/initdata/a.png"), orders);
//        Address jinan = new Address("山东", user, "济南", "高新");
//        Address rizhao = new Address("山东", user, "日照", "东港");
//        Address zhaozhuang = new Address("山东", user, "枣庄", "市中");
//
//        session.save(jinan);
//        session.save(rizhao);
//        session.save(zhaozhuang);
//        session.save(user);
//
//        transaction.commit();
//        session.close();

//        User user = (User) session.initdata(User.class, 1);
//        System.out.println(user.getOrders().size());
    }
}
