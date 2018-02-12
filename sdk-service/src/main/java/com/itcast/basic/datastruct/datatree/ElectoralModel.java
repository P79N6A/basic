package com.itcast.basic.datastruct.datatree;

/**
 * Created by treey.qian on 2018/2/12.
 */
public enum ElectoralModel {
    LEFT(0), RIGHT(1);

    private int index;

    public int getIndex() {
        return index;
    }

    ElectoralModel(int index) {
        this.index = index;
    }
}
