package com.itcast.basic.designpatterntype.visitor.service;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}