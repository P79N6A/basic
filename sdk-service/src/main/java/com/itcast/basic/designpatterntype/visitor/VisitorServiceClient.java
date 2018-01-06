package com.itcast.basic.designpatterntype.visitor;

import com.itcast.basic.designpatterntype.visitor.impl.Computer;
import com.itcast.basic.designpatterntype.visitor.service.ComputerPart;

public class VisitorServiceClient {
    public static void main(String[] args) {
        try {
            ComputerPart computer = new Computer();
            computer.accept(new ComputerPartDisplayVisitor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}