package com.itcast.basic.designpatterntype.command;

import com.itcast.basic.designpatterntype.command.impl.BuyStock;
import com.itcast.basic.designpatterntype.command.impl.SellStock;

public class CommandServiceClient {

    public static void main(String[] args) {
        try {
            Stock abcStock = new Stock();

            BuyStock buyStockOrder = new BuyStock(abcStock);
            SellStock sellStockOrder = new SellStock(abcStock);

            Broker broker = new Broker();
            broker.takeOrder(buyStockOrder);
            broker.takeOrder(sellStockOrder);

            broker.placeOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}