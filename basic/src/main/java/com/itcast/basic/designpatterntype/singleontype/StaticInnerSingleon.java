package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 */
public class StaticInnerSingleon {

    public static StaticInnerSingleon getStaticInnerSingleon() {
        return HelperUtils.staticInnerSingleon;
    }

    private StaticInnerSingleon() {

    }

    static class HelperUtils {
        //        private static StaticInnerSingleon staticInnerSingleon = new StaticInnerSingleon();
        private static StaticInnerSingleon staticInnerSingleon;

        static {
            staticInnerSingleon = new StaticInnerSingleon();
        }
    }

    public void connect() {

    }

    public void operate() {

    }
}
