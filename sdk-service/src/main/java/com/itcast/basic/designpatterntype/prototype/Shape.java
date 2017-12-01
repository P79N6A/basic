package com.itcast.basic.designpatterntype.prototype;

/**
 * Created by treey.qian on 2017/11/28.
 */
public abstract class Shape implements Cloneable {

    private long id = System.currentTimeMillis();

    protected String type;

    public String getType() {
        return type;
    }


    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    abstract protected void draw();
}
