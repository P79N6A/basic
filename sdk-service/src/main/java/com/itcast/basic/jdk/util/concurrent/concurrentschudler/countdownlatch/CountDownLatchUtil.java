package com.itcast.basic.jdk.util.concurrent.concurrentschudler.countdownlatch;

import com.itcast.basic.jdk.util.concurrent.concurrentschudler.model.Person;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class CountDownLatchUtil {
    private static final List<Person> persons = new ArrayList();

    private static int defaultSize = 10000;

    private static List initPersons() {
        for (int i = 1; i < 65001; i++) {
            persons.add(new Person(i, "我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子我是一个好孩子" + i, "这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校这是我的学校" + i, "我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子我真的是一个好孩子" + i, "我是男人" + i, "山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号" + i, "无业农民" + i, "山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号山东省枣庄市山亭区桑村镇马场村361号" + i));
        }
        return persons;
    }

    public static void quickDownLoad() {
        try {
            long beginTime = System.currentTimeMillis();
            List<Person> persons = initPersons();
            //模拟分页查询
            int page = 1;
            int total = persons.size();
            int pageSize = defaultSize;
            int totalPage = (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
            //线程数
            CountDownLatch countDownLatch = new CountDownLatch(totalPage);
            //返回结果
            List<String> results = new ArrayList<>();
            //线程池
            for (int j = 0; j < totalPage; j++) {
                int offset = (page - 1) * pageSize;
                int subSize = offset + pageSize;
                if (subSize > total) {
                    subSize = total;
                }
                String fileName = new StringBuilder("E:\\persons").append(page).append(".xls").toString();
                File file = new File(fileName);
                final List<Person> subList = persons.subList(offset, subSize);
                new Thread(() -> {
                    String result = " success";
                    String threadName = Thread.currentThread().getName();
                    try {
                        downCore(file, subList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        result = " fail";
                    }
                    results.add(threadName + result);
                    countDownLatch.countDown();
                }).start();
                page++;
            }
            countDownLatch.await();
            System.out.println("耗时:" + (System.currentTimeMillis() - beginTime) + "ms");
            for (String result : results) {
                System.out.println("result is " + result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void downCore(File file, List<Person> personList) throws WriteException, IOException {
        //创建excel文件
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        //创建tab
        WritableSheet writableSheet = workbook.createSheet("用户信息表", 0);
        //创建表头
        writableSheet.addCell(new Label(0, 0, "编号"));
        writableSheet.addCell(new Label(1, 0, "用户名"));
        writableSheet.addCell(new Label(2, 0, "学校"));
        writableSheet.addCell(new Label(3, 0, "昵称"));
        writableSheet.addCell(new Label(4, 0, "性别"));
        writableSheet.addCell(new Label(5, 0, "籍贯"));
        writableSheet.addCell(new Label(6, 0, "职业"));
        writableSheet.addCell(new Label(7, 0, "现居城市"));
        for (int i = 0, size = personList.size(); i < size; i++) {
            Person person = personList.get(i);
            int k = i + 1;
            if (person != null) {
                writableSheet.addCell(new Label(0, k, String.valueOf(person.getId())));
                writableSheet.addCell(new Label(1, k, person.getName()));
                writableSheet.addCell(new Label(2, k, person.getSchool()));
                writableSheet.addCell(new Label(3, k, person.getNickName()));
                writableSheet.addCell(new Label(4, k, person.getSex()));
                writableSheet.addCell(new Label(5, k, person.getBirthCity()));
                writableSheet.addCell(new Label(6, k, person.getJob()));
                writableSheet.addCell(new Label(7, k, person.getLiveCity()));
            }
        }
        workbook.write();
        workbook.close();
    }

    public static void downLoad(File file) {
        try {
            long beginTime = System.currentTimeMillis();
            //创建excel文件
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建tab
            WritableSheet writableSheet = workbook.createSheet("用户信息表", 0);
            //创建表头
            writableSheet.addCell(new Label(0, 0, "编号"));
            writableSheet.addCell(new Label(1, 0, "用户名"));
            writableSheet.addCell(new Label(2, 0, "学校"));
            writableSheet.addCell(new Label(3, 0, "昵称"));
            writableSheet.addCell(new Label(4, 0, "性别"));
            writableSheet.addCell(new Label(5, 0, "籍贯"));
            writableSheet.addCell(new Label(6, 0, "职业"));
            writableSheet.addCell(new Label(7, 0, "现居城市"));
            List<Person> persons = initPersons();
            for (int i = 0, size = persons.size(); i < size; i++) {
                Person person = persons.get(i);
                writableSheet.addCell(new Label(0, i + 1, String.valueOf(person.getId())));
                writableSheet.addCell(new Label(1, i + 1, person.getName()));
                writableSheet.addCell(new Label(2, i + 1, person.getSchool()));
                writableSheet.addCell(new Label(3, i + 1, person.getNickName()));
                writableSheet.addCell(new Label(4, i + 1, person.getSex()));
                writableSheet.addCell(new Label(5, i + 1, person.getBirthCity()));
                writableSheet.addCell(new Label(6, i + 1, person.getJob()));
                writableSheet.addCell(new Label(7, i + 1, person.getLiveCity()));
            }
            workbook.write();
            workbook.close();
            System.out.println("耗时:" + (System.currentTimeMillis() - beginTime) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
