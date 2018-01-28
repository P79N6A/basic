package com.itcast.basic.mybatis.tool.blob.model;

/**
 * Created by Administrator on 2018/1/21.
 */
public class File {

    private long id;
    private String name;
    private byte[] content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content=" + new String(content) +
                '}';
    }
}
