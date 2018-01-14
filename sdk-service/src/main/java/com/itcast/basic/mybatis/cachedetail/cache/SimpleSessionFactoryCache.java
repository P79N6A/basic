package com.itcast.basic.mybatis.cachedetail.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by treey.qian on 2018/1/12.
 */
public class SimpleSessionFactoryCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final ObjectMapper jsonMapper = new ObjectMapper();

    private String id;

    private Jedis jedis;

    private String host;
    private int port;
    private String genType;

    public SimpleSessionFactoryCache() {
        System.out.println("enter into not param");
    }

    public SimpleSessionFactoryCache(String id) {
        this.id = id;
        System.out.println("enter into  params");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        System.out.println("enter into set host");
        this.host = host;
    }

    public String getGenType() {
        return genType;
    }

    public void setGenType(String genType) {
        System.out.println("enter into set genType");
        this.genType = genType;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        System.out.println("enter into set port");
        this.port = port;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        String valueJson = null;
        try {
            valueJson = jsonMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("key class type is " + key.getClass().getName() + " value class type is " + value.getClass().getName() + " valueJson= " + valueJson);
        jedis.set(key.toString(), valueJson);
    }

    @Override
    public Object getObject(Object key) {
        List list = null;
        try {
            if (jedis == null) {
                jedis = new Jedis(getHost(), getPort());
            }
            String valueObj = jedis.get(key.toString());
            System.out.println("valueObj is  " + valueObj);
            if (valueObj != null) {
                JavaType javaType = jsonMapper.getTypeFactory().constructParametricType(ArrayList.class, Class.forName(getGenType()));
                list = jsonMapper.readValue(valueObj, javaType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Object removeObject(Object key) {
        return jedis.del(key.toString());
    }

    @Override
    public void clear() {
        jedis.flushDB();
    }

    @Override
    public int getSize() {
        return jedis.keys("*").size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


    @Override
    public String toString() {
        return "SimpleSessionFactoryCache{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", genType='" + genType + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
