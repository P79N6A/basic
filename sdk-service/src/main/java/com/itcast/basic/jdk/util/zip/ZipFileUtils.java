package com.itcast.basic.jdk.util.zip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2018/2/10.
 */
public class ZipFileUtils {


    /**
     * 解压zip包
     *
     * @param path
     * @throws IOException
     */
    public static void deCompressZip(String path) throws IOException {
        ZipFile zipFile = new ZipFile(new File(path));
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
            String fileName = zipEntry.getName();
            InputStream zipInputStream = zipFile.getInputStream(zipEntry);
            FileOutputStream fileOutputStream = new FileOutputStream("e:\\files\\" + fileName);
            int i = 0;
            while ((i = zipInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
            zipInputStream.close();
            fileOutputStream.close();
        }
    }


    /**
     * 压缩成zip包
     *
     * @param path
     */
    public static void compressZip(String path) throws IOException {
        File file = new File(path);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("e:\\files.zip"));
        initFiles(file, zipOutputStream);
        zipOutputStream.close();
        System.out.println("compress finish");
    }

    /**
     * 逐个压缩
     *
     * @param file
     * @param zipOutputStream
     */
    private static void initFiles(File file, ZipOutputStream zipOutputStream) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files) {
                if (subFile.isDirectory()) {
                    initFiles(subFile, zipOutputStream);
                } else {
                    process(subFile, zipOutputStream);
                }
            }
        } else {
            process(file, zipOutputStream);
        }
    }


    /**
     * 压缩核心方法
     *
     * @param file
     * @param zipOutputStream
     * @throws IOException
     */
    private static void process(File file, ZipOutputStream zipOutputStream) throws IOException {
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOutputStream.putNextEntry(zipEntry);
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        while ((i = fileInputStream.read()) != -1) {
            zipOutputStream.write(i);
        }
        fileInputStream.close();
    }


    private ZipFileUtils() {

    }
}
