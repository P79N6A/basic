package com.itcast.basic.designpatterntype.visitor.impl;

import com.itcast.basic.designpatterntype.visitor.service.ComputerPart;
import com.itcast.basic.designpatterntype.visitor.service.ComputerPartVisitor;

public class Mouse  implements ComputerPart {

   @Override
   public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
   }
}