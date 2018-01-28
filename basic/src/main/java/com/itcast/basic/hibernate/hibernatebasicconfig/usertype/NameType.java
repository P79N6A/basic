package com.itcast.basic.hibernate.hibernatebasicconfig.usertype;

import com.itcast.basic.hibernate.propertiesconfig.Name;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by qfl on 16/7/6.
 */
public class NameType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return Name.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y)
            return true;
        if (x == null || y == null)
            return false;
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, Object o) throws HibernateException, SQLException {
        if (resultSet.wasNull())
            return null;
        String firstName = resultSet.getString(strings[0]);
        String lastName = resultSet.getString(strings[1]);
        return new Name(firstName, lastName);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.VARCHAR);
            preparedStatement.setNull(i + 1, Types.VARCHAR);
        }
        Name name = (Name) o;
        String firstName = name.getFirstName();
        String lastName = name.getLastName();
        preparedStatement.setString(i, firstName);
        preparedStatement.setString(i + 1, lastName);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
