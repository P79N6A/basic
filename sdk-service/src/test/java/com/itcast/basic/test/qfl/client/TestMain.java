package com.itcast.basic.test.qfl.client;

/**
 * Created by treey.qian on 2017/11/7.
 */
public class TestMain {
    public static void main(String[] args) {
        try {
//            System.out.println("enter test main");
////            String text = "[2017-11-14 22:27:37.936] [INFO] [traceId=][org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer#2-3] [c.b.p.r.trans.customer.RefundSendBankQueueCustomer] >>> refundDetailsService sendBank invoke before 当前时间为1510669657936";
////            System.out.println("time is " + text.substring(text.length() - 13, text.length()));
//            File file = new File("E:\\log.txt");
//            StringBuilder stringBuilder = new StringBuilder("ssss");
//            LineNumberReader reader = new LineNumberReader(new FileReader(file));
//            for (int i = 0; i < 498; i++) {
//                reader.setLineNumber(i);
//                String text = reader.readLine();
//
//                reader.setLineNumber(i + 1);
//                String text1 = reader.readLine();
//                Long textNum = Long.valueOf(text.substring(text.lastIndexOf("当前时间为") + 5, text.length()));
//                Long textNum1 = Long.valueOf(text1.substring(text1.lastIndexOf("当前时间为") + 5, text1.length()));
//                System.out.println(textNum1 + "\n" + textNum + " " + (textNum1 - textNum) + " " + i);
//                System.out.println("*****************************");
////                System.out.println((textNum1 - textNum) + " " + i);
//                if ((textNum1 - textNum) < 600) {
//                    stringBuilder.append(text.substring(text.lastIndexOf("当前时间为") + 5, text.length())).append("\n");
//                    stringBuilder.append(text1.substring(text1.lastIndexOf("当前时间为") + 5, text1.length())).append("\n");
//                }
//            }
//            FileOutputStream fileOutputStream = new FileOutputStream("E:\\batch.log");
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//            fileOutputStream.close();

            long num = 1000;
//            StringBuilder
            System.out.println("num" + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Person person = new Person(new Person.EventSource() {
//            @Override
//            public void registerListener(Person.EventListener e) {
//                   e.onEvent();
//            }
//        });

        SaveService saveService = new PersonSave();
        saveService.sys();
    }
}
