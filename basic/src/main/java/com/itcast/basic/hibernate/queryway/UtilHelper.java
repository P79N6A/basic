package com.itcast.basic.hibernate.queryway;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;

/**
 * Created by qfl on 16/7/8.
 */
public class UtilHelper {

    public static byte[] getByteFromImageFile(String path) {
        byte[] buffer = null;
        File file = new File(path);
        try {
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                if (fileInputStream != null)
                    fileInputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static boolean getImageFileFromByte(String path, byte[] buffer) {
        boolean success = false;
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(buffer);
            if (outputStream != null)
                outputStream.close();
            success = false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static Session getQuerySession(String path) {
        return getSessionFactory(path).getCurrentSession();
    }

    public static Session getUpdateSession(String path) {
        return getSessionFactory(path).getCurrentSession();
    }

    private static SessionFactory getSessionFactory(String path) {
        return new Configuration()
                .configure(path)
                .buildSessionFactory();
    }
}
