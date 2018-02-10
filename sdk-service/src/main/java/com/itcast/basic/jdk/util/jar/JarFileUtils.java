package com.itcast.basic.jdk.util.jar;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.*;

/**
 * Created by Administrator on 2018/2/10.
 */
public class JarFileUtils {

    /**
     * 生成jar
     *
     * @param source
     * @param target
     */
    public static void compressJarFile(String source, String target) throws IOException {
        File file = new File(source);
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(target), manifest);
        initFiles(file, jarOutputStream);
        jarOutputStream.close();
        System.out.println("压缩完毕");
    }

    /**
     * 逐个打包
     *
     * @param file
     * @param jarOutputStream
     */
    private static void initFiles(File file, JarOutputStream jarOutputStream) throws IOException {
        if (file.isFile()) {
            process(file, jarOutputStream);
        } else {
            File[] files = file.listFiles();
            for (File subFile : files) {
                if (subFile.isDirectory()) {
                    initFiles(subFile, jarOutputStream);
                } else {
                    process(subFile, jarOutputStream);
                }
            }
        }
    }

    /**
     * 打包核心方法
     *
     * @param source
     * @param jarOutputStream
     */
    private static void process(File source, JarOutputStream jarOutputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(source);
        JarEntry jarEntry = new JarEntry(source.getName());
        jarOutputStream.putNextEntry(jarEntry);
        int i = 0;
        while ((i = fileInputStream.read()) != -1) {
            jarOutputStream.write(i);
        }
        fileInputStream.close();
    }

    /**
     * 解压jar包
     *
     * @param path
     * @throws IOException
     */
    public static void deCompressJarFlie(String path) throws IOException {
        File jar = new File(path);
        JarFile jarFile = new JarFile(jar);
        Enumeration<JarEntry> enumeration = jarFile.entries();
        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = enumeration.nextElement();
            String fileName = jarEntry.getName();
            if (fileName.contains("META-INF")) {
                continue;
            }
            System.out.println("file name is " + fileName);
            String dir = new StringBuilder("e:\\jar\\").append(fileName.substring(0, fileName.lastIndexOf("/"))).toString();
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            InputStream jarInputStream = jarFile.getInputStream(jarEntry);
            File file = new File("E:\\jar\\" + fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int i = 0;
            while ((i = jarInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
            jarInputStream.close();
            fileOutputStream.close();
        }
        System.out.println("deCompress jar finish");
    }


    private JarFileUtils() {

    }
}
