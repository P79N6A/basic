package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/7.
 */
public class SimpleDatabaseIdProvider implements DatabaseIdProvider {

    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String dbName = dataSource.getConnection().getMetaData().getDatabaseProductName();
        return properties.get(dbName).toString();
    }
}
