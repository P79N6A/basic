package com.itcast.basic.mybatis.cachedetail.cache;

import com.google.gson.Gson;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by treey.qian on 2018/1/12.
 */
public class SimpleSessionFactoryCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Gson gson = new Gson();

    private String id;

    private Jedis jedis;

    private String host;
    private int port;

    public SimpleSessionFactoryCache(String id) {
        this.id = id;
        jedis = new Jedis("127.0.0.1", 6379);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        String valueJson = gson.toJson(value);
        System.out.println("valueJson= " + valueJson);
        jedis.set(key.toString(), valueJson);
    }

    @Override
    public Object getObject(Object key) {
        Object valueObj = jedis.get(key.toString());
        System.out.println("valueObj= " + valueObj);
        List list = gson.fromJson("", List.class);
        return list.get(0);
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
}
