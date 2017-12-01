package com.itcast.basic.designpatterntype.status.service;

import com.itcast.basic.designpatterntype.status.Context;

public interface State {
    void doAction(Context context);
}