package com.itcast.basic.mybatis.tool.procedure;

import com.itcast.basic.mybatis.tool.procedure.model.ParamModel;
import com.itcast.basic.mybatis.tool.procedure.service.ProcedureMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ProcedureDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ProcedureDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/produce/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            ProcedureMapper procedureMapper = sqlSession.getMapper(ProcedureMapper.class);
            ParamModel paramModel = new ParamModel();
            paramModel.setCondition("lily");
            procedureMapper.count(paramModel);
            int count = paramModel.getCount();
            System.out.println("count=" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
