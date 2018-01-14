package com.itcast.basic.mybatis.mapperdetail.insertdetail;


import com.itcast.basic.mybatis.mapperdetail.insertdetail.model.Sex;
import com.itcast.basic.mybatis.mapperdetail.insertdetail.model.Student;
import com.itcast.basic.mybatis.mapperdetail.insertdetail.service.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by treey.qian on 2018/1/9.
 */
public class InsertDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into InsertDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/mapperdetail/insertdetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student("Lily", Sex.MAN, "2011416842", "QFU");
            int result = 0;
//            result=studentMapper.insertStudent(student);
            result = studentMapper.insertShareStudent(student);
            result = studentMapper.deleteStudentById(2018010000);
            result = studentMapper.updateNameAndSexOfStudentById("treey", Sex.WOMAN, 2018010001);
            System.out.println("result=" + result + " student=" + student);
            if (result >= 1) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
