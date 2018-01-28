package com.itcast.basic.threadtype.concurrentthread.singlemodelclass;

/**
 * Created by qfl on 16/4/25.
 */
public class StaticInnerSingleModelClass {
    public static void main(String[] args) {

    }
}

//(内部类实现单例)变形1
class FirstStaticInnerConnectionUtils {


    public void connect() {
    }

    public void close() {
    }

    static class DataManager {

        private static FirstStaticInnerConnectionUtils firstStaticInnerConnectionUtils = new FirstStaticInnerConnectionUtils();

        public static FirstStaticInnerConnectionUtils getFirstStaticInnerConnectionUtils() {
            return firstStaticInnerConnectionUtils;
        }
    }
}


//(内部类实现单例)变形2
class SecondStaticInnerConnectionUtils {
    public void connect() {
    }

    public void close() {
    }

    static class DataManager {

        private static SecondStaticInnerConnectionUtils secondStaticInnerConnectionUtils;

        static {
            secondStaticInnerConnectionUtils = new SecondStaticInnerConnectionUtils();
        }

        public static SecondStaticInnerConnectionUtils getSecondStaticInnerConnectionUtils() {
            return secondStaticInnerConnectionUtils;
        }
    }
}