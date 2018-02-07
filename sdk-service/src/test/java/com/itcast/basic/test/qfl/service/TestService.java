package com.itcast.basic.test.qfl.service;

import com.itcast.basic.jdk.lang.classloader.classloader.ClassFileObject;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class TestService {

    @Test
    public void sysService() {
        short x = 0;
        try {
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    switch (x) {
//                        case 2:
//                            break;
//                    }
//                    System.out.println("j****" + j);
//                }
//                System.out.println("i=" + i);
//            }
            boolean isTrue = !true ? false : true;

            System.out.println("isTrue=" + isTrue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLetter() {
        try {
//            boolean isLetter = Character.isLetter(',');
//            System.out.println("isLetter=" + isLetter);
            String dir = System.getProperty("user.dir");
            System.out.println("dir=" + dir + " class name is " + ClassFileObject.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testStringBuilder() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\1.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("admin");
            objectOutputStream.writeObject(stringBuilder);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClone() {
        try {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("admin");
//            Person person = new Person();
//            person.setName("admin");
//            Person person1 = (Person) person.clone();
//            person.sys(null);
//            System.out.println("person =" + person1);
//            int i = 0;
//            int j=0;
//            int k=i++;
//            System.out.println("k="+k);
//            System.out.println("i++ " + (i++) + " ++j " + (++j));

//            int result = Sex.MAN.compareTo(Sex.WOMAN);
//            System.out.println("result is " + result);
//            File[] files = new File("E:\\技术文档").listFiles();
//            for (File file : files) {
//                System.out.println("file name is " + file.getName() + " path is " + file.getPath());
//            }

//            int a = 1 | 2;
//            System.out.println("a=" + a);
            //1802032187887460100 1802032187901610200
            Long num = Long.valueOf("1802032187887460100");
            System.out.println("num=" + Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
