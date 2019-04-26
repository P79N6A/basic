package com.itcast.basic.test.qfl.util;

import org.junit.Test;

import java.io.FileNotFoundException;

import static com.itcast.basic.web.util.TowCodeCreateUtil.encoderQRCode;

/**
 * Created by treey.qian on 2018/5/30.
 */
public class TestUtils {

    @Test
    public void testCode() throws FileNotFoundException {
        try {
            String url = "http://10.108.29.240:8080/sdk-service/freemarker/user";
//            encoderQRCode(url, new FileOutputStream("e:\\01.jpg"), "jpg");
//            String content = decoderQRCode("e:\\01.jpg");
//            System.out.println("content=" + content);
            encoderQRCode(url, "e:\\01.jpg", "jpg", "e:\\02.jpg");
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
