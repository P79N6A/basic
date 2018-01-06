package com.itcast.basic.designpatterntype.status;

import com.itcast.basic.designpatterntype.status.impl.StartState;
import com.itcast.basic.designpatterntype.status.impl.StopState;

public class StateServiceClient {
    public static void main(String[] args) {
        try {
            Context context = new Context();

            StartState startState = new StartState();
            startState.doAction(context);

            System.out.println(context.getState().toString());

            StopState stopState = new StopState();
            stopState.doAction(context);

            System.out.println(context.getState().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}