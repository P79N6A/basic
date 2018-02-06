package com.itcast.basic.jdk.io.io.bytestream;

import java.io.*;
import java.util.Vector;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class InputOutputStreamUtils {

    /**
     * 字节回推流
     */
    public static void operatePushbackStream() throws IOException {
        String url = "www.baidu.com";
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(url.getBytes());
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PushbackInputStream pushbackInputStream = new PushbackInputStream(arrayInputStream);
        int i = 0;
        byte[] bytes = new byte[20];
        while ((i = pushbackInputStream.read()) != -1) {
            if (i == '.') {
                pushbackInputStream.unread('d');
//                System.out.println("text=" + (char) i);
            } else {
                System.out.println("text=" + (char)i);
            }
        }
        pushbackInputStream.close();
    }

    /**
     * 初始化多输入序列
     *
     * @param inputStreams
     * @return
     */
    public static SequenceInputStream operateSequenceInputStream(Vector<InputStream> inputStreams) {
        return new SequenceInputStream(inputStreams.elements());
    }

    /**
     * 管道流
     */
    public static void operatePipedStream() throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);
        pipedOutputStream.write((Thread.currentThread().getName() + "说:你好小姐").getBytes());

        byte[] bytes = new byte[1024];
        pipedInputStream.read(bytes);
        System.out.println("text is " + new String(bytes));
    }


    /**
     * 操作对象流
     *
     * @param path
     * @throws Exception
     */
    public static void operateObjectStream(String path) throws Exception {
        class Person implements Serializable {
            private static final long serialVersionUID = 1l;
            private int id;
            private String name;
            private char sex;

            public Person(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public char getSex() {
                return sex;
            }

            public void setSex(char sex) {
                this.sex = sex;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", sex='" + sex + '\'' +
                        '}';
            }
        }
        checkPath(path);
        File file = new File(path);
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Person person = (Person) objectInputStream.readObject();
            System.out.println("person is " + person);
            objectInputStream.close();
        } else {
            Person person = new Person(1, "admin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        }
    }


    /**
     * 跨平台数据流
     *
     * @param path 文件路径
     * @throws Exception
     */
    public static void operateDataStream(String path) throws Exception {
        checkPath(path);
        File file = new File(path);
        if (file.exists()) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            long time = dataInputStream.readLong();
            System.out.println("time is " + time);
            dataInputStream.close();
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.close();
        }
    }

    /**
     * 文件流操作演示
     *
     * @param path 文件路径
     * @throws Exception
     */
    public static void operateFileStream(String path) throws Exception {
        checkPath(path);
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int position = 0;
            while ((position = fileInputStream.read(bytes)) != -1) {
                System.out.println("text is " + new String(bytes) + " position=" + position);
            }
            fileInputStream.close();
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("hello world".getBytes());
            fileOutputStream.close();
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

    private InputOutputStreamUtils() {
    }
}
