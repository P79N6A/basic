package com.itcast.basic.web.converters;

import com.sdk.model.Sex;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2018/1/28.
 */
public class SexConverter implements Converter<String, Sex> {

    @Override
    public Sex convert(String s) {
        switch (s){
            case "man":
                return Sex.MAN;
            case "woman":
                return Sex.WOMAN;
            default:
                return null;
        }
    }
}
