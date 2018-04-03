package com.itcast.basic.test.qfl.service;

import com.itcast.basic.jdk.lang.classloader.classloader.ClassFileObject;
import com.itcast.basic.jdk.rpc.customer.ServiceCustomer;
import com.itcast.basic.jdk.rpc.service.UserService;
import com.itcast.basic.jdk.util.concurrent.concurrentschudler.model.Person;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class TestService {

    @Test
    public void testAssert() {
        try {
//            int a = 2;
//            assert a == 1;
//            System.out.println("****************");
            //模拟分页查询
            List<Person> persons = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                persons.add(new Person(i, "我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子" + i, "这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校" + i, "我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子" + i, "我是男人" + i, "山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号" + i, "无业农民" + i, "山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号" + i));
            }
            persons.subList(5, 9).set(0, null);

            for (Person person : persons) {
                System.out.println("person is " + person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sysService() {
        short x = 0;
        try {
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    switch (x) {
//                        case 2:
//                            break;
//                    }
//                    System.out.println("j****" + j);
//                }
//                System.out.println("i=" + i);
//            }
            boolean isTrue = !true ? false : true;

            System.out.println("isTrue=" + isTrue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLetter() {
        try {
//            boolean isLetter = Character.isLetter(',');
//            System.out.println("isLetter=" + isLetter);
            String dir = System.getProperty("user.dir");
            System.out.println("dir=" + dir + " class name is " + ClassFileObject.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testStringBuilder() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\1.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("admin");
            objectOutputStream.writeObject(stringBuilder);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClone() {
        try {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("admin");
//            Person person = new Person();
//            person.setName("admin");
//            Person person1 = (Person) person.clone();
//            person.sys(null);
//            System.out.println("person =" + person1);
//            int i = 0;
//            int j=0;
//            int k=i++;
//            System.out.println("k="+k);
//            System.out.println("i++ " + (i++) + " ++j " + (++j));

//            int result = Sex.MAN.compareTo(Sex.WOMAN);
//            System.out.println("result is " + result);
//            File[] files = new File("E:\\技术文档").listFiles();
//            for (File file : files) {
//                System.out.println("file name is " + file.getName() + " path is " + file.getPath());
//            }

//            int a = 1 | 2;
//            System.out.println("a=" + a);
            //1802032187887460100 1802032187901610200
//            Long num = Long.valueOf("1802032187887460100");
//            System.out.println("num=" + Long.MAX_VALUE);
//
//            File file = new File("e:\\1.txt");
//            int fileSize = (int) file.length();
//            byte[] bytes = new byte[fileSize];
//            RandomAccessFile fileInputStream = new RandomAccessFile(file, "r");
//            FileChannel fileChannel = fileInputStream.getChannel();
//            int size = (int) fileChannel.size();
//            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
//            int index = 0;
//            while (mappedByteBuffer.hasRemaining()) {
//                bytes[index++] = mappedByteBuffer.get();
//            }
//            System.out.println("size of buffer is " + size / 1024 / 1024);
//            SocketUtils.startClient("127.0.0.1",2000);
//            SocketChannelBlockUtils.startSocketClient("127.0.0.1", 2000);
//            File file = new File("e:\\01.txt");
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String text = "";
//            int index = 0;
//            StringBuilder stringBuilder = new StringBuilder();
//            while ((text = reader.readLine()) != null) {
//                stringBuilder.append("\'").append(text).append("\'").append(",");
//                index++;
//                while (index > 500) {
//                    break;
//                }
//            }
//            FileOutputStream fileOutputStream = new FileOutputStream("e:\\02.sql");
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//            fileOutputStream.close();
//            Selector selector=Selector.open();
//            Selector selector1=Selector.open();
//            System.out.println(" istrue "+(selector==selector1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSocketChannel() {
        try {
//            SocketUtils.startSocketClient("127.0.0.1", 2000);
//            NIOSocketChannelUtils.startNIOSocketClient("127.0.0.1", 2000);
//            JarFileUtils.deCompressJarFlie("e:\\target.jar");
//            JarFileUtils.compressJarFile("e:\\jar", "e:\\target.jar");
//            ZipFileUtils.compressZip("E:\\zip");
//            ZipFileUtils.deCompressZip("E:\\files.zip");
//            char c = '0';
//            System.out.println(c > '1');
//            MergeSort mergeSort = new MergeSort(Arrays.asList(new Integer[]{5, 8, 7, 2, 10, 6, 3}));
//            mergeSort.sortElements();
//            int[] a = new int[]{5, 8, 7, 2, 10, 6, 3};
//            sort(a, 0, a.length - 1);
//            System.out.println("a is " + Arrays.toString(a));
            List list = new ArrayList(10);
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println("size is " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    @Test
    public void testRPC() {
        try {
            System.out.println("enter into ServiceCustomerMain");
            ServiceCustomer serviceCustomer = new ServiceCustomer();
            UserService userService = (UserService) serviceCustomer.customer(UserService.class, new InetSocketAddress(8888), "userServiceImpl");
            Object result = userService.select();
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
