package com.itcast.basic.controller.util;

import java.awt.image.BufferedImage;

//图片类
public class Image {
    private String code;
    private BufferedImage bufferedImage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public Image(String code, BufferedImage bufferedImage) {
        this.code = code;
        this.bufferedImage = bufferedImage;
    }
}