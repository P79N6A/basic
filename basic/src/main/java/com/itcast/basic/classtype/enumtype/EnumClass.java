package com.itcast.basic.classtype.enumtype;

/**
 * Created by qfl on 16/4/22.
 */
public enum EnumClass {

    ONE, TOW, THREE, FOUR,
    SIX {
        private void sysWorld() {
            System.out.println("Hello World,i am Lily");
        }
    };
    private int i = 100;

    EnumClass() {
    }

    public static final String UUID = "enum";
    private static final DataUtils dataUtils = new DataUtils();

    private static DataUtils getDataUtils() {
        return dataUtils;
    }

    public int getI() {
        return i;
    }

    public static void sysHello() {
        System.out.println("Hello World");
    }

    public void jump() {
        System.out.println("jumping");
    }
}

