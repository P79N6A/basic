package com.itcast.basic.io.inputandoutputstream;

import java.io.*;

/**
 * Created by qfl on 16/4/28.
 */
public class OutputAndInputStreamClass {

    public static void main(String[] args) {
        final String path = "/Users/qfl/java/android/";
        //InputStreamUtils.operateFileStream(path + "a.txt");
        //InputStreamUtils.operateDataStream(path + "b.txt");
        //InputStreamUtils.operateObjectStream(path + "c.txt");
        //InputStreamUtils.operateSequenceStream(path + "a.txt", path + "b.txt");
        InputStreamUtils.operatePushbackStream(path + "a.txt");
    }

}

class InputStreamUtils {

    public static void operateFileStream(String path) {

        if (path != null || !path.equals(""))
            try {
                File file = new File(path);
                if (file.exists()) {
                    FileInputStream inputStream = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int i = 0;
                    while ((i = inputStream.read(buffer)) != -1) {
                        System.out.println("text of file is " + new String(buffer));
                    }
                    inputStream.close();
                } else {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    outputStream.write("hello world".getBytes());
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static void operateDataStream(String path) {
        if (path != null || !path.equals(""))
            try {
                File file = new File(path);
                if (file.exists()) {
                    DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                    System.out.println(dataInputStream.readLong());
                    dataInputStream.close();
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                    dataOutputStream.writeLong(System.currentTimeMillis());
                    dataOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void operateObjectStream(String path) {
        if (path != null || !path.equals(""))
            try {
                File file = new File(path);
                if (file.exists()) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    System.out.println(objectInputStream.readObject().toString());
                    objectInputStream.close();
                } else {
                    Person person = new Person(12345, "Lily");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    objectOutputStream.writeObject(person);
                    objectOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static void operateSequenceStream(String firstPath, String secondPath) {
        if (!firstPath.equals("") && !secondPath.equals(""))
            try {
                File firstFile = new File(firstPath);
                File secondFile = new File(secondPath);

                if (firstFile.exists() && secondFile.exists()) {
                    SequenceInputStream sequenceInputStream = new SequenceInputStream(new FileInputStream(firstFile), new FileInputStream(secondFile));
                    int i = 0;
                    byte[] buffer = new byte[1024];
                    while ((i = sequenceInputStream.read(buffer)) != -1) {
                        System.out.println(new String(buffer));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static void operatePushbackStream(String path) {
        if (!path.equals(""))
            try {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream(path));
                byte[] buffer = new byte[1024];
                int i = 0;
                while ((i = pushbackInputStream.read(buffer)) != -1) {
                    if ((char) i == 'h') {
                        System.out.println((char) i);
                        pushbackInputStream.unread(i);
                    } else {
                        System.out.println(new String(buffer));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    public static void operatePipedInputStream(PipedInputStream pipedInputStream) {

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        try {
            pipedOutputStream.connect(pipedInputStream);
            pipedOutputStream.write((Thread.currentThread().getName() + ": hello world").getBytes());
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void operatePipedOutputStream(PipedOutputStream pipedOutputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        try {
            pipedInputStream.connect(pipedOutputStream);
            int i = 0;
            byte[] buffer = new byte[1024];
            while ((i = pipedInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer));
            }
            pipedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

