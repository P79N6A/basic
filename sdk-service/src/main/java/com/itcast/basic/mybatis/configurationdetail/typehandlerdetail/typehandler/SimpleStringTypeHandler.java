package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/1/7.
 */
public class SimpleStringTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("enter into SimpleStringTypeHandler parameter");
        ps.setString(i, parameter.toString());
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("enter into SimpleStringTypeHandler columnName");
        return rs.getString(columnName);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("enter into SimpleStringTypeHandler columnIndex");
        return rs.getString(columnIndex);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("enter into SimpleStringTypeHandler CallableStatement");
        return cs.getString(columnIndex);
    }
}
