package com.itcast.basic.mybatis.joindetail;

import com.itcast.basic.mybatis.joindetail.model.*;
import com.itcast.basic.mybatis.joindetail.service.LessonMapper;
import com.itcast.basic.mybatis.joindetail.service.TeacherCardMapper;
import com.itcast.basic.mybatis.joindetail.service.TeacherHealthMapper;
import com.itcast.basic.mybatis.joindetail.service.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class JoinDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JoinDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/joindetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
//            int result = 0;
//            result += insertManData(sqlSession);
//            result += insertFelameData(sqlSession);
//            System.out.println("result=" + result);
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            //noe to one config
            Teacher teacher = teacherMapper.selectTeacherById(3);
            System.out.println("teacher=" + teacher);

            TeacherHealthMapper teacherHealthMapper = sqlSession.getMapper(TeacherHealthMapper.class);
            ManTeacherHealth manTeacherHealth = teacherHealthMapper.selectManTeacherHealthById(1);
            System.out.println("manTeacherHealth=" + manTeacherHealth);
            FemaleTeacherHealth femaleTeacherHealth = teacherHealthMapper.selectFemaleTeacherHealthById(1);
            System.out.println("femaleTeacherHealth=" + femaleTeacherHealth);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int insertManData(SqlSession sqlSession) {
        int result = 0;
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = new Teacher("lily", Sex.MAN, "武汉");
            result += teacherMapper.insertTeacher(teacher);

            TeacherCardMapper teacherCardMapper = sqlSession.getMapper(TeacherCardMapper.class);
            TeacherCard teacherCard = new TeacherCard("2011416842", "武汉", "签证时间:2010-10-12;到期时间:2018-11-16", teacher.getId());
            result += teacherCardMapper.insertTeacherCard(teacherCard);

            TeacherHealthMapper teacherHealthMapper = sqlSession.getMapper(TeacherHealthMapper.class);
            teacherHealthMapper.insertManTeacherHealth(new ManTeacherHealth(teacher.getId(), "Man健康", "Man健康", "Man健康", "Man健康", "Man健康", "Man健康"));

            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            for (int i = 1; i < 5; i++) {
                result += lessonMapper.insertLesson(new Lesson(teacher.getId(), "lesson" + i, "this is lesson" + i));
            }

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int insertFelameData(SqlSession sqlSession) {
        int result = 0;
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = new Teacher("lily", Sex.WOMAN, "武汉");
            result += teacherMapper.insertTeacher(teacher);

            TeacherCardMapper teacherCardMapper = sqlSession.getMapper(TeacherCardMapper.class);
            TeacherCard teacherCard = new TeacherCard("2011416842", "武汉", "签证时间:2010-10-12;到期时间:2018-11-16", teacher.getId());
            result += teacherCardMapper.insertTeacherCard(teacherCard);

            TeacherHealthMapper teacherHealthMapper = sqlSession.getMapper(TeacherHealthMapper.class);
            teacherHealthMapper.insertFemaleTeacherHealth(new FemaleTeacherHealth(teacher.getId(), "Female健康", "Female健康", "Female健康", "Female健康", "Female健康", "Female健康"));

            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            for (int i = 1; i < 5; i++) {
                result += lessonMapper.insertLesson(new Lesson(teacher.getId(), "lesson" + i, "this is lesson" + i));
            }

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
