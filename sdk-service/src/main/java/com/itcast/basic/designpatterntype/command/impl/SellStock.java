package com.itcast.basic.designpatterntype.command.impl;

import com.itcast.basic.designpatterntype.command.Stock;
import com.itcast.basic.designpatterntype.command.service.Order;

public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}