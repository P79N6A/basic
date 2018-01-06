package com.itcast.basic.designpatterntype.strategy;

import com.itcast.basic.designpatterntype.strategy.impl.OperationAdd;
import com.itcast.basic.designpatterntype.strategy.impl.OperationMultiply;
import com.itcast.basic.designpatterntype.strategy.impl.OperationSubstract;

public class StrategyServiceClient {
    public static void main(String[] args) {
        try {
            Context context = new Context(new OperationAdd());
            System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

            context = new Context(new OperationSubstract());
            System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

            context = new Context(new OperationMultiply());
            System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}