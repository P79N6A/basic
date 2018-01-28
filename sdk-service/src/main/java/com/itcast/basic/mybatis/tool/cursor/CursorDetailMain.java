package com.itcast.basic.mybatis.tool.cursor;

import com.itcast.basic.mybatis.tool.cursor.model.ParamModel;
import com.itcast.basic.mybatis.tool.cursor.service.CursorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/21.
 */
public class CursorDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into CursorDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/cursor/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            CursorMapper cursorMapper = sqlSession.getMapper(CursorMapper.class);
            ParamModel paramModel = new ParamModel();
            paramModel.setCondition("lily");
            cursorMapper.query(paramModel);
            int count = paramModel.getCount();
            System.out.println("count=" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
