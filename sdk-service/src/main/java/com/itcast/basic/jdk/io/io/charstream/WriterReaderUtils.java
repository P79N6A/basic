package com.itcast.basic.jdk.io.io.charstream;

import java.io.*;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class WriterReaderUtils {


    /**
     * 字符字节转换
     *
     * @param path 路径
     * @throws Exception
     */
    public static void convertCharByte(String path) throws Exception {
        checkPath(path);
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            char[] chars = new char[1024];
            while (inputStreamReader.read(chars) != -1) {
                System.out.println("text is " + new String(chars));
            }
            inputStreamReader.close();
        } else {
            String text = "你好 我叫强强";
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(text);
            outputStreamWriter.close();
        }
    }

    /**
     * 字符回推流
     */
    public static void operatePushbackReader() throws IOException {
        String url = "www.baidu.com";
        CharArrayReader charArrayReader = new CharArrayReader(url.toCharArray());
        PushbackReader pushbackReader = new PushbackReader(charArrayReader);
        int i = 0;
        while ((i = pushbackReader.read()) != -1) {
            if (i == '.') {
                pushbackReader.unread(',');
            } else {
                System.out.println("i=" + (char) i);
            }
        }
        charArrayReader.close();
        pushbackReader.close();
    }

    /**
     * 字符管道流
     *
     * @throws IOException
     */
    public static void operatePipedStream() throws IOException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        pipedWriter.connect(pipedReader);
        pipedWriter.write("hello i am lily");
        char[] chars = new char[30];
        pipedReader.read(chars);
        System.out.println("text is " + new String(chars));
        pipedReader.close();
        pipedWriter.close();
    }


    /**
     * 字符流
     *
     * @param path
     * @throws Exception
     */
    public static void operateFileStream(String path) throws Exception {
        checkPath(path);
        File file = new File(path);
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            char[] chars = new char[1024];
            while (bufferedReader.read(chars) != -1) {
                System.out.println("text is " + new String(chars));
            }
            bufferedReader.close();
        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("你好 我叫强强");
            bufferedWriter.close();
        }
    }

    private static void checkPath(String path) throws Exception {
        if (path == null) {
            throw new NullPointerException(path);
        }

        File file = new File(path);

        if (file.isDirectory()) {
            throw new Exception(path + "不是一个文件路径");
        }
    }

    private WriterReaderUtils() {

    }
}
