package com.itcast.basic.designpatterntype.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qfl on 16/6/3.
 */
public class FlyWeight {
    private Map<String, Subject> map = new HashMap();

    public Subject getSubject(String name) {
        Subject subject = map.get(name);
        if (subject == null) {
            subject = new SubjectA(name);
            map.put(name, subject);
        }
        return subject;
    }
}
