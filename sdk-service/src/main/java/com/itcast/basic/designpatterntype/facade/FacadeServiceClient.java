package com.itcast.basic.designpatterntype.facade;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class FacadeServiceClient {

    public static void main(String[] args) {
       try {
           ShapeFacade shapeFacade = new ShapeFacade();

           shapeFacade.drawCircle();
           shapeFacade.drawRectangle();
           shapeFacade.drawSquare();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
