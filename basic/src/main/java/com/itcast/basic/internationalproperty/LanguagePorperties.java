package com.itcast.basic.internationalproperty;

import java.util.ListResourceBundle;

/**
 * Created by qfl on 16/5/10.
 */
public class LanguagePorperties extends ListResourceBundle {

    //{key value}
    private Object[][] contents = {
            {"China", "chinese"},
            {"England", "english"},
            {"Japan", "Japanese"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
