package com.itcast.basic.designpatterntype.builder;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class BuilderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into BuilderServiceClient");
            PersonBuilder personBuilder = new PersonBuilder();
            personBuilder.buildBody("man body");
            personBuilder.buildHead("man head");
            personBuilder.buildHander("man hander");
            personBuilder.buildFoot("man foot");
            System.out.println(personBuilder.buildObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
