package com.itcast.basic.test.jvm;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by treey.qian on 2017/9/5.
 */
public class TestJVMConfig {

    class OOMObject {
        private byte[] placeholder = new byte[64 * 1024];
    }

    private void testJvm() {
        try {
            List<OOMObject> list = new ArrayList<OOMObject>();
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(50);
                list.add(new OOMObject());
                if (i == 64) {
                    System.out.println("date is " + new Date());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testJVM0() {
        //100 * 1024 * 1024 = 104857600
        //64 * 1024 * 10000 = 655360000
        //64 * 1024 * 1600  = 104857600
        try {
            Thread.sleep(10000);
            System.out.println("jvm begin");
            testJvm();
            System.gc();
            System.out.println("jvm end");
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJVM1() {

    }



}
