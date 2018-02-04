package com.itcast.basic.jdk.lang.abstractstringbuilder.abstractstringbuilder;

/**
 * Created by Administrator on 2018/2/3.
 */
public class JDKStringBuilder extends JDKAbstractStringBuilder {

    public JDKStringBuilder() {
        super(16);
    }

    public JDKStringBuilder(int capacity) {
        super(capacity);
    }

    public JDKString toJDKString() {
        return new JDKString(value, 0, count);
    }


    public JDKStringBuilder append(char c){
        super.append(c);
        return this;
    }

    public void reverse(){
        super.reverse();
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(count);
        s.writeObject(value);
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count = s.readInt();
        value = (char[]) s.readObject();
    }
}
