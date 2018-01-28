package com.itcast.basic.classtype.enumtype;

/**
 * Created by qfl on 16/4/23.
 */

public class DataUtils {
    private static final DataConnection connection;

    static {
        connection = new DataConnection();
    }

    public DataUtils() {
    }

    public DataConnection getConnection() {
        return connection;
    }

    private static class DataConnection {
        public DataConnection() {
        }
    }
}

