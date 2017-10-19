package com.itcast.basic.spring.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by treey.qian on 2017/10/18.
 */
public class UserQueryMapper implements RowMapper {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(Integer.valueOf(rs.getInt("id")));
        student.setName(rs.getString("name"));
        student.setSchool(rs.getString("school"));
        student.setBirth(rs.getDate("birth"));
        return student;
    }
}
