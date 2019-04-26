package com.itcast.basic.jdk.lang.classloader.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by treey.qian on 2018/2/2.
 */
public final class SimpleClassLoader extends ClassLoader {

    private final String USER_DIR = new StringBuilder("E:")
            .append(File.separator)
            .append("github")
            .append(File.separator)
            .append("sdk-service")
            .append(File.separator)
            .append("target")
            .append(File.separator)
            .append("classes")
            .toString();

    private final String FILE_TYPE = ".class";

    private final Class defineClass;

    public SimpleClassLoader(Class defineClass) {
        this.defineClass = defineClass;
    }

    public SimpleClassLoader(ClassLoader parent, Class defineClass) {
        super(parent);
        this.defineClass = defineClass;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("loading " + name + "class");
        byte[] bytes = {};
        try {
            bytes = loadClassFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(defineClass.getName(), bytes, 0, bytes.length);
    }


    private byte[] loadClassFile() throws IOException {
        if (defineClass != null) {
            String filePath = new StringBuilder(USER_DIR)
                    .append(File.separator)
                    .append(defineClass.getName().replace(".", File.separator))
                    .append(FILE_TYPE)
                    .toString();
            System.out.println(" filePath=" + filePath);
            File file = new File(filePath);
            byte[] bytes = {};
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                int i = 0;
                while ((i = fileInputStream.read()) != -1) {
                    byteArrayOutputStream.write(i);
                }
                bytes = byteArrayOutputStream.toByteArray();
                fileInputStream.close();
                byteArrayOutputStream.close();
            } else {
                throw new IllegalArgumentException("文件不存在");
            }
            return bytes;
        } else {
            throw new IllegalArgumentException("参数异常");
        }
    }


}
