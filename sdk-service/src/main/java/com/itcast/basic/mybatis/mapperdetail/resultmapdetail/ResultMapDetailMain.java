package com.itcast.basic.mybatis.mapperdetail.resultmapdetail;

import com.itcast.basic.mybatis.mapperdetail.resultmapdetail.model.Student;
import com.itcast.basic.mybatis.mapperdetail.resultmapdetail.service.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Map;
import java.util.Set;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class ResultMapDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ResultMapDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/mapperdetail/resultmapdetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectUserById(2018010001);
            student = studentMapper.selectUserAliasById(2018010002);
            System.out.println("student=" + student);
            Map map = studentMapper.selectMapById(2018010002);
            Set<Map.Entry> set = map.entrySet();
            for (Map.Entry entry : set) {
                System.out.println(entry.getKey() + " ===> " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
