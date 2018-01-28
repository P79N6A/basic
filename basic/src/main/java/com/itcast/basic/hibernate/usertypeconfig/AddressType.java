package com.itcast.basic.hibernate.usertypeconfig;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by qfl on 16/7/5.
 */
public class AddressType implements Serializable, CompositeUserType {

    private static final long serivalVersionUID = 123456789l;

    private String province;
    private String city;
    private String district;

    public AddressType() {
    }

    public AddressType(String province, String city, String district) {
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressType that = (AddressType) o;

        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return district != null ? district.equals(that.district) : that.district == null;

    }

    @Override
    public int hashCode() {
        int result = province != null ? province.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"province", "city", "district"};

    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[]{Hibernate.STRING, Hibernate.STRING, Hibernate.STRING};
    }

    @Override
    public Object getPropertyValue(Object component, int property) throws HibernateException {
        AddressType address = validAddressType(component);
        String result = "";
        switch (property) {
            case 0:
                result = address.getProvince();
                break;
            case 1:
                result = address.getCity();
                break;
            case 2:
                result = address.getDistrict();
                break;
            default:
                throw new IllegalArgumentException("unknown property " + property);
        }
        return result;
    }

    @Override
    public void setPropertyValue(Object component, int property, Object value) throws HibernateException {
        AddressType address = validAddressType(component);
        String propertyValue = (String) value;
        switch (property) {
            case 0:
                address.setProvince(propertyValue);
                break;
            case 1:
                address.setCity(propertyValue);
                break;
            case 2:
                address.setDistrict(propertyValue);
                break;
            default:
                throw new IllegalArgumentException("unknown property " + property);
        }
    }

    private AddressType validAddressType(Object component) {
        AddressType address = (AddressType) component;
        if (address == null)
            throw new NullPointerException("component is null");
        return address;
    }

    @Override
    public Class returnedClass() {
        return this.getClass();
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
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        if (resultSet.wasNull())
            return null;
        String province = resultSet.getString(strings[0]);
        String city = resultSet.getString(strings[1]);
        String district = resultSet.getString(strings[2]);
        if (province == null || city == null || district == null)
            return null;
        return new AddressType(province, city, district);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.VARCHAR);
            preparedStatement.setNull(i + 1, Types.VARCHAR);
            preparedStatement.setNull(i + 2, Types.VARCHAR);
        }
        AddressType address = (AddressType) o;
        preparedStatement.setString(i, address.getProvince());
        preparedStatement.setString(i + 1, address.getCity());
        preparedStatement.setString(i + 2, address.getDistrict());
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null)
            return null;
        AddressType address = (AddressType) value;
        return new AddressType(address.getProvince(), address.getCity(), address.getDistrict());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o, SessionImplementor sessionImplementor) throws HibernateException {
        return (Serializable) deepCopy(o);
    }

    @Override
    public Object assemble(Serializable serializable, SessionImplementor sessionImplementor, Object o) throws HibernateException {
        return deepCopy(serializable);
    }

    @Override
    public Object replace(Object o, Object o1, SessionImplementor sessionImplementor, Object o2) throws HibernateException {
        return deepCopy(o);
    }
}
