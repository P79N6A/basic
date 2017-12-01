package com.itcast.basic.designpatterntype.template;

import com.itcast.basic.designpatterntype.template.impl.Cricket;
import com.itcast.basic.designpatterntype.template.impl.Football;
import com.itcast.basic.designpatterntype.template.service.Game;

public class TemplateServiceClient {
    public static void main(String[] args) {

        try {
            Game game = new Cricket();
            game.play();
            System.out.println();
            game = new Football();
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}