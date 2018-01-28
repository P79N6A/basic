package com.itcast.basic.classloadertype;

import java.io.*;

/**
 * Created by qfl on 16/5/15.
 * 这是一个自定义的类加载器
 */
public class SimpleClassLoader extends ClassLoader {

    private String path = "com.itcast.basic.classloadertype";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadFile(name);
        return defineClass(path + "." + name, bytes, 0, bytes.length);
    }

    /**
     * 根据类文件路径读取字节流数组
     *
     * @param name
     * @return
     */
    private byte[] loadFile(String name) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + this.path.replace(".", File.separator) + File.separator + name + ".class";
        File file = new File(path);
        if (!file.isFile())
            throw new IllegalArgumentException("文件路径不正确");
        byte[] bytes = {};
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            bytes = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
