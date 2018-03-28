package com.itcast.basic.jdk.util.properties;

import com.itcast.basic.jdk.util.hashtable.JDKHashTable;

import java.io.*;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKProperties extends JDKHashTable {

    public JDKProperties() {
    }

    public synchronized Object setProperty(Object key, Object value) {
        return put(key, value);
    }

    public synchronized Object getProperty(Object key) {
        return get(key);
    }


    public synchronized Object getProperty(Object key, Object value) {
        Object v = get(key);
        return v == null ? value : v;
    }

    public synchronized boolean store(OutputStream outputStream) {
        if (size() > 0) {
            Node[] tables = tables();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < capacity(); i++) {
                Node h = tables[i];
                while (h != null) {
                    stringBuilder.append(h.getKey()).append("=").append(h.getValue()).append("\n");
                    h = h.getNext();
                }
            }
            try {
                outputStream.write(stringBuilder.toString().getBytes());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public synchronized void load(InputStream inputStream) {
        load0(new InputStreamReader(inputStream));
    }


    public synchronized void load(Reader reader) {
        load0(reader);
    }

    private void load0(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String text = null;
        try {
            while ((text = bufferedReader.readLine()) != null) {
                String[] entry = text.split("=");
                if (entry.length == 2) {
                    put(entry[0], entry[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
