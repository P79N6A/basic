package com.itcast.basic.spring.tools.mongodb;


import com.itcast.basic.spring.tools.mongodb.service.MongoDBServiceImpl;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by treey.qian on 2018/1/26.
 */
public class MongoDBServiceMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into   MongoDBServiceMain ");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/tools/mongodb/application.xml");
            MongoDBServiceImpl mongoDBService = (MongoDBServiceImpl) applicationContext.getBean("mongoDBService");
//            if (mongoDBService != null) {
//                User user = new User();
//                user.setId(1);
//                user.setSchool("wuhan");
//                user.setName("lily");
//                user.setNumber("1836310143");
//                boolean isSuccess = mongoDBService.insertData(user, "user");
//                System.out.println("isSuccess=" + isSuccess);
//            }
//            File file = new File("e:\\01.lua");
//            mongoDBService.SaveFile("fs", file, "01", "01", file.getName());
            GridFSDBFile gridFSDBFile = mongoDBService.retrieveFileOne("fs", "01");
            System.out.println("file name is " + gridFSDBFile.getFilename());
            FileOutputStream outputStream = new FileOutputStream("e:\\02" + gridFSDBFile.getContentType());
            InputStream inputStream = gridFSDBFile.getInputStream();
            long len=gridFSDBFile.getLength();
            byte[] bytes = new byte[(int) len];
            inputStream.read(bytes);
            inputStream.close();
            outputStream.write(bytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
