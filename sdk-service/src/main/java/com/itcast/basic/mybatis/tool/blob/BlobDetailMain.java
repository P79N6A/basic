package com.itcast.basic.mybatis.tool.blob;

import com.itcast.basic.mybatis.tool.blob.mapper.FileMapper;
import com.itcast.basic.mybatis.tool.blob.model.File;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/21.
 */
public class BlobDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into BlobDetailMain");
//            File file = new File("e:\\01.lua");
//            FileInputStream inputStream = new FileInputStream(file);
//            byte[] content = new byte[1024];
//            inputStream.read(content);
//            com.itcast.basic.mybatis.tool.blob.model.File fileModel = new com.itcast.basic.mybatis.tool.blob.model.File();
//            fileModel.setName(file.getName());
//            fileModel.setContent(content);

            //构建sqlSession
            Reader reader = Resources.getResourceAsReader("mybatis/tool/blob/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
            int result = 0;
//            result = fileMapper.insertFile(fileModel);
            File fileModel = fileMapper.findFileById(1);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
            System.out.println("result=" + result + " fileModel=" + fileModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
