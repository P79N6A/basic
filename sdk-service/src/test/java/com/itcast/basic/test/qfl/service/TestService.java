package com.itcast.basic.test.qfl.service;

import com.itcast.basic.jdk.lang.classloader.classloader.ClassFileObject;
import org.junit.Test;

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
            System.out.println("dir=" + dir+" class name is "+ ClassFileObject.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
