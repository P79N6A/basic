package com.itcast.basic.designpatterntype.visitor.service;

import com.itcast.basic.designpatterntype.visitor.impl.Computer;
import com.itcast.basic.designpatterntype.visitor.impl.Keyboard;
import com.itcast.basic.designpatterntype.visitor.impl.Monitor;
import com.itcast.basic.designpatterntype.visitor.impl.Mouse;

public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}