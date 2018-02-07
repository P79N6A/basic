package com.itcast.basic.jdk.io.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class RandomAccessFileUtils {

    public static volatile long defaultThreadFileSize = 50 * 1024 * 1024;

    /**
     * 多线程下载
     *
     * @param path 文件路径
     * @throws IOException
     */
    public static void copyFile(String path) throws IOException {
        if (path == null) {
            throw new NullPointerException(path);
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        if (file.isDirectory()) {
            throw new IllegalAccessError("path不是一个文件路径");
        }

        RandomAccessFile randomAccessFileReader = new RandomAccessFile(file, "r");

        long fileSize = randomAccessFileReader.length();

        long threadSize = ((fileSize % defaultThreadFileSize) == 0 ? fileSize / defaultThreadFileSize : fileSize / defaultThreadFileSize + 1);

        RandomAccessFile randomAccessFileWriter = new RandomAccessFile(new File("e:\\copy.txt"), "rw");
        randomAccessFileWriter.setLength(fileSize);
        System.out.println("fileSize=" + fileSize + " writerSize=" + randomAccessFileWriter.length());
        randomAccessFileWriter.close();
        for (int i = 0; i < threadSize; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        RandomAccessFile randomAccessFileCurrentWriter = new RandomAccessFile(new File("e:\\copy.txt"), "rw");
                        long bTime = System.currentTimeMillis();
                        long pos = index * defaultThreadFileSize;
                        randomAccessFileReader.seek(pos);
                        randomAccessFileCurrentWriter.seek(pos);
                        byte[] bytes = new byte[1024];
                        int hasRead = 0;
                        int len = 0;
                        while (len < defaultThreadFileSize && (hasRead = randomAccessFileReader.read(bytes)) != -1) {
                            randomAccessFileCurrentWriter.write(bytes);
                            len += hasRead;
                        }
                        randomAccessFileCurrentWriter.close();
                        System.out.println("thread id is " + Thread.currentThread().getName() + " len=" + len + " finish " + (System.currentTimeMillis() - bTime) + "ms");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
