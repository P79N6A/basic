package com.itcast.basic.jdk.beans.beans;

import java.beans.*;

/**
 * Created by qfl on 16/5/10.
 * 本类演示对javaBean属性的各种操作:
 * 单一属性 索引属性 绑定属性 约束属性
 */
public class Person {

    private int id;
    private String name;
    private char sex;
    private boolean winner;
    private long[] numbers = {};
    //绑定属性管理器
    private PropertyChangeSupport propertyChangeSupport;
    //约束属性管理器
    private VetoableChangeSupport vetoableChangeSupport;

    public Person() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        vetoableChangeSupport = new VetoableChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName != null && !newName.equals(name)) {
            String oldName = getName();
            setVetoableChangeStatus("name", oldName, newName);
            name = newName;
            setPropertyChangeStatus("name", oldName, newName);
        }

    }

    private void setPropertyChangeStatus(String properName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(properName, oldValue, newValue);
    }

    private void setVetoableChangeStatus(String properName, Object oldValue, Object newValue) {
        try {
            vetoableChangeSupport.fireVetoableChange(properName, oldValue, newValue);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    //注册绑定属性监听器
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    //移除绑定属性监听器
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    //注册约束属性监听器
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    //删除约束属性监听器
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

    public void setNumbersProperty(int index, long newValue) {
        if (index < 0 || index >= numbers.length)
            throw new ArrayIndexOutOfBoundsException("数组越界");
        numbers[index] = newValue;
    }

    public long getNumbersProperty(int index) {
        if (index < 0 || index >= numbers.length)
            throw new ArrayIndexOutOfBoundsException("数组越界");
        return numbers[index];
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public VetoableChangeSupport getVetoableChangeSupport() {
        return vetoableChangeSupport;
    }

    public void setVetoableChangeSupport(VetoableChangeSupport vetoableChangeSupport) {
        this.vetoableChangeSupport = vetoableChangeSupport;
    }

    public long[] getNumbers() {
        return numbers;
    }

    public void setNumbers(long[] numbers) {
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

}
