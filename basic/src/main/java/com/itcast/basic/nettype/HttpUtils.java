package com.itcast.basic.nettype;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by qfl on 16/5/4.
 */
public class HttpUtils {

    public static void doGet(String urlStr) {

        try {

            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() >= 300)
                throw new Exception("网络连接错误");
            Set<Map.Entry<String, List<String>>> maps = connection.getHeaderFields().entrySet();
            for (Map.Entry<String, List<String>> map : maps) {
                System.out.print(map.getKey() + " ----> ");
                for (String s : map.getValue()) {
                    System.out.print(s);
                }
                System.out.println();
            }
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String text;
            while ((text = buffer.readLine()) != null) {
                stringBuilder.append(text);
            }
            buffer.close();
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void doPost(String urlStr, Map paramsValue) {

        try {
            if (paramsValue == null || urlStr == null)
                throw new Exception("参数为空");
            StringBuilder stringBuilder = new StringBuilder();
            Set<String> keys = paramsValue.keySet();
            for (String key : keys) {
                if (key != null) {
                    String value = (String) paramsValue.get(key);
                    stringBuilder.append(key).append("=").append(value == null ? "" : value);
                }
            }
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() >= 300)
                throw new Exception("网络连接异常");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
            writer.write(stringBuilder.toString());
            writer.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String text = "";
            StringBuilder builder = new StringBuilder();
            while ((text = reader.readLine()) != null) {
                stringBuilder.append(text);
            }
            reader.close();
            System.out.println(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void sendMail(String mailText, String toMail) {

        Properties config = new Properties();
        config.put("mail.tranport.protocol", "smtps");
        config.put("mail.smtps.auth", true);
        config.put("mail.smtps.user", "1258166167@qq.com");
        config.put("mail.smtps.host", "smtp.gmail.com");
        config.put("mail.smtps.password", "a123456");

        Session sendSession = Session.getDefaultInstance(config);
        MimeMessage sendMessage = new MimeMessage(sendSession);
        try {
            sendMessage.setFrom(new InternetAddress("1258166167@qq.com"));
            sendMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            sendMessage.setSubject("这是邮件主题");
            sendMessage.setText(mailText);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            Transport transport = sendSession.getTransport();
            transport.connect();
            transport.sendMessage(sendMessage, sendMessage.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}




































