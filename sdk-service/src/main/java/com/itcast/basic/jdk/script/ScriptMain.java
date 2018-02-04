package com.itcast.basic.jdk.script;

import com.itcast.basic.jdk.script.script.service.Calculator;
import com.itcast.basic.jdk.script.script.util.ScriptEngineManagerUtil;

import javax.script.CompiledScript;

/**
 * Created by Administrator on 2018/2/4.
 */
public class ScriptMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ScriptMain");
            ScriptEngineManagerUtil.exeScript("js", "print('hello world');");
            Double hours = ScriptEngineManagerUtil.exeScriptResult("js", "var date = new Date();" + "date.getHours();");
            System.out.println("hours= " + hours);
            String output = ScriptEngineManagerUtil.exeScriptInOut("js", "var output='';for (i = 0; i <= name.length; i++) {output = name.charAt(i) + output}", "name", "admin", "output");
            System.out.println("output= " + output);
            CompiledScript compiledScript = ScriptEngineManagerUtil.initCompileScript("js", "var counter=0;function count(){counter++;return counter;};count();");
            for (int i = 0; i < 5; i++) {
                System.out.println("count= " + compiledScript.eval());
            }
            double counter = 10;
            counter = ScriptEngineManagerUtil.invokeFunction("js", "var counter=0;function count(counter){counter++;return counter;}", "count", counter);
            System.out.println("counter= " + counter);
            Calculator calculator = ScriptEngineManagerUtil.getMapper("js", "function add(a,b){return a+b;}", Calculator.class);
            System.out.println("sum= " + calculator.add(1, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
