package com.itcast.basic.designpatterntype.visitor;

import com.itcast.basic.designpatterntype.visitor.impl.Computer;
import com.itcast.basic.designpatterntype.visitor.impl.Keyboard;
import com.itcast.basic.designpatterntype.visitor.impl.Monitor;
import com.itcast.basic.designpatterntype.visitor.impl.Mouse;
import com.itcast.basic.designpatterntype.visitor.service.ComputerPartVisitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}