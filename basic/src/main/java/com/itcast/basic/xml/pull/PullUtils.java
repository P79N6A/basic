package com.itcast.basic.xml.pull;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by qfl on 16/6/9.
 */
public class PullUtils {
    public static void readXML(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        if (!path.endsWith(".xml"))
            throw new IllegalArgumentException("文件格式不正确");
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(new FileInputStream(file), "UTF-8");
            int event = pullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        System.out.println("开始解析文档");
                        break;
                    case XmlPullParser.START_TAG:
                        System.out.println("---------------" + pullParser.getName() + "-----------------");
                        for (int i = 0; i < pullParser.getAttributeCount(); i++)
                            System.out.println(pullParser.getAttributeName(i) + " =========> " + pullParser.getAttributeValue(i));
                        break;
                    case XmlPullParser.TEXT:
                        String text = pullParser.getText();
                        if (text != null)
                            System.out.println(" ========> " + text);
                        break;
                    case XmlPullParser.END_TAG:
                        if (pullParser.getAttributeCount() > 0)
                            System.out.println("---------------" + pullParser.getName() + "-----------------");
                        break;
                }

                event = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
