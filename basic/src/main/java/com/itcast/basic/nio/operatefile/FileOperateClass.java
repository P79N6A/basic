package com.itcast.basic.nio.operatefile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.*;

import static java.nio.channels.FileChannel.MapMode.*;

/**
 * Created by qfl on 16/4/29.
 */
public class FileOperateClass {
    public static void main(String[] args) throws IOException {
//        FileOperateUtils.readFileText("/Users/qfl/java/android/a.txt");
//        FileOperateUtils.writeFileText("/Users/qfl/java/android/a.txt");
//        FileOperateUtils.loadBigFile("/Users/qfl/java/android/a.txt");
//        FileOperateUtils.compressFiles("/Users/qfl/java/android/");
        FileOperateUtils.decompression("/Users/qfl/java/android/", "files.zip");
    }
}

class FileOperateUtils {

    public static void readFileText(String path) {

        try {
            FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int i = 0;
            while ((i = fileChannel.read(byteBuffer)) != -1) {
                System.out.println(new String(byteBuffer.array()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeFileText(String path) {

        try {
            FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
            fileChannel.write(ByteBuffer.wrap("i am Lily".getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadBigFile(String path) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(READ_WRITE, 0, randomAccessFile.length());
            fileChannel.write(mappedByteBuffer);
            System.out.println(mappedByteBuffer.array());

//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            byteBuffer.put("hello world this is very beautiful".getBytes());
//            System.out.println("text is " + new String(byteBuffer.array()));
//            byteBuffer.flip();
//            FileChannel fileChannel = FileChannel.open(Paths.get("/Users/qfl/java/android/a.txt"), StandardOpenOption.WRITE);
//            fileChannel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void compressFiles(String path) {

        try {
            File f = new File(path);
            File zip = new File(path + File.separator + "files.zip");
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                for (File file : files) {
                    System.out.println("file name is " + file.getName());
                    FileInputStream fis = new FileInputStream(file);
                    out.putNextEntry(new ZipEntry(file.getName()));
                    int i = 0;
                    while ((i = fis.read()) != -1) {
                        out.write(i);
                    }
                    fis.close();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decompression(String path, String zipFileName) {
        try {
            ZipFile zipFile = new ZipFile(path + zipFileName);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File(path + zipFileName)));
            ZipEntry entry = null;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                FileOutputStream out = new FileOutputStream(path + entry.getName());
                InputStream input = (InputStream) zipFile.getInputStream(entry);
                int i = 0;
                while ((i = input.read()) != -1) {
                    out.write(i);
                }
                out.close();
                input.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
