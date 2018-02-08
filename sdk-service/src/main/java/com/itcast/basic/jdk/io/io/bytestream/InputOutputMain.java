package com.itcast.basic.jdk.io.io.bytestream;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class InputOutputMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into InputOutputMain");
//            InputOutputStreamUtils.operateFileStream("e:\\1.txt");
//            InputOutputStreamUtils.operateDataStream("e:\\2.txt");
//            InputOutputStreamUtils.operateObjectStream("e:\\3.txt");
//              InputOutputStreamUtils.operatePipedStream();
            InputOutputStreamUtils.operatePushbackStream();
//            Vector vector = new Vector();
//            for (int i = 0; i < 5; i++) {
//                vector.add(new FileInputStream("e:\\1.txt"));
//            }
//            InputStream inputStream = InputOutputStreamUtils.operateSequenceInputStream(vector);
//            byte[] bytes = new byte[50];
//            while (inputStream.read(bytes) != -1) {
//                System.out.println("text is " + new String(bytes));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
