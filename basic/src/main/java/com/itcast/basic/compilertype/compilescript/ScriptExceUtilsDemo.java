package com.itcast.basic.compilertype.compilescript;

import sun.tools.jar.Main;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;

/**
 * Created by qfl on 16/5/14.
 */
public class ScriptExceUtilsDemo {

    public static void main(String[] args) {
        String fileName = "src.com.itcast.basic.compilertype.compilescript.".replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + fileName + "language.js";
        System.out.println(ScriptExceUtils.getMethodResult("add", new Object[]{2, 3}, path, "js"));
        /**
         * 通过接口绑定方式调用JavaScript方法
         */
        ScriptEngine engine = ScriptExceUtils.getScriptEngine("js");
        try {
            engine.eval(ScriptExceUtils.getReaderByPath(path));
            Greeter greeter = ((Invocable) engine).getInterface(Greeter.class);
            System.out.println("result is " + greeter.add(22, 33));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}


