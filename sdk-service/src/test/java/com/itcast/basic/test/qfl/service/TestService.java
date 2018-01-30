package com.itcast.basic.test.qfl.service;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;

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
}
