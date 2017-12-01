package com.itcast.basic.designpatterntype.command.impl;

import com.itcast.basic.designpatterntype.command.Stock;
import com.itcast.basic.designpatterntype.command.service.Order;

public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}