package com.itcast.basic.jdk.io.io.charstream;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class WriterReaderMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into WriterReaderMain");
//            WriterReaderUtils.operateFileStream("e:\\01.txt");
//            WriterReaderUtils.operatePipedStream();
//            WriterReaderUtils.operatePushbackReader();
            WriterReaderUtils.convertCharByte("e:\\02.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
