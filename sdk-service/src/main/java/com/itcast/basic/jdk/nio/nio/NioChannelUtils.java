package com.itcast.basic.jdk.nio.nio;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by treey.qian on 2018/2/7.
 */
public class NioChannelUtils {


    /**
     * 大文件映射
     *
     * @param path 文件路径
     */
    public static void mapBigFile(String path) throws Exception {

        int bufferSize = 30 * 1024 * 1024;
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        int size = (int) fileChannel.size();
        long loopNum = (size % bufferSize == 0 ? size / bufferSize : size / bufferSize + 1);
        for (int i = 0; i < loopNum; i++) {
            int offerset = i * bufferSize;
            int limit = bufferSize;
            if (i == loopNum - 1) {
                limit = size - offerset;
            }
            //获取私有缓存区  此处返回对象是java.nio.directbytebuffer实例
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.PRIVATE, offerset, limit);
            //输出次数
            int count = limit / 1024;
            for (int k = 0; k < count; k++) {
                //输出缓存区内容
                byte[] bytes = new byte[1024];
                int j = 0;
                while (j < bytes.length && mappedByteBuffer.hasRemaining()) {
                    bytes[j++] = mappedByteBuffer.get();
                }
                System.out.println("text is " + new String(bytes));
            }
            //释放缓存区
            clear(mappedByteBuffer);
        }
        System.out.println("size is " + size + " loopNum=" + loopNum);
        fileChannel.close();
        randomAccessFile.close();
//        System.out.println("delete is " + file.delete());
    }

    /**
     * 释放mappedbytebuffer占用的内存
     *
     * @param byteBuffer
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void clear(ByteBuffer byteBuffer) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getCleanerMethod = byteBuffer.getClass().getMethod("cleaner", null);
        getCleanerMethod.setAccessible(true);
        sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(byteBuffer, null);
        cleaner.clean();
    }

    /**
     * 复制文件
     *
     * @param source 源文件地址
     * @param target 目标文件地址
     */
    public static void copyFromFile(String source, String target) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(target);
        FileChannel fileChannel = fileOutputStream.getChannel();
        FileInputStream fileInputStream = new FileInputStream(source);
        FileChannel fileChannelSource = fileInputStream.getChannel();
        fileChannel.transferFrom(fileChannelSource, 0, fileChannelSource.size());
        fileOutputStream.close();
    }


    /**
     * 复制文件
     *
     * @param source 源文件地址
     * @param target 目标文件地址
     */
    public static void copyToFile(String source, String target) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(source);
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.transferTo(0, fileChannel.size(), new FileOutputStream(target).getChannel());
        fileInputStream.close();
    }

    /**
     * 打开文件通道
     *
     * @param path
     * @throws IOException
     */
    public static void openFileChannel(String path) throws IOException {
        if (path == null) {
            throw new NullPointerException(path);
        }
        File file = new File(path);
        if (file.isDirectory()) {
            throw new IllegalArgumentException(path + "is not a file");
        }
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer);
            System.out.println("text is " + new String(byteBuffer.array()));
            fileChannel.close();
            fileInputStream.close();
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.write(ByteBuffer.wrap("i am lily hello everyone".getBytes()));
            fileChannel.close();
            fileOutputStream.close();
        }

    }

    private NioChannelUtils() {

    }
}
