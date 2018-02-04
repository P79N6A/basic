package com.itcast.basic.jdk.script.script.util;

import javax.script.*;
import java.util.List;

/**
 * Created by Administrator on 2018/2/4.
 */
public class ScriptEngineManagerUtil {

    private static final ScriptEngineManager scriptEngineManager;

    static {
        scriptEngineManager = new ScriptEngineManager();
        if (scriptEngineManager != null) {
            List<ScriptEngineFactory> factories = scriptEngineManager.getEngineFactories();
            for (ScriptEngineFactory factory : factories) {
                System.out.println("engine name is " + factory.getEngineName() + " engine version is " + factory.getEngineVersion()
                        + " language name is " + factory.getLanguageName() + " language version is" + factory.getLanguageVersion()
                        + " engine extensions is " + factory.getExtensions() + " engine mime is " + factory.getMimeTypes());
            }
        }
    }

    /**
     * 简单脚本执行器
     *
     * @param scriptType 脚本类型
     * @param script     脚本内容
     * @throws ScriptException
     */
    public static void exeScript(String scriptType, String script) throws ScriptException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(scriptType);
        scriptEngine.eval(script);
    }

    /**
     * 返回值脚本执行器
     *
     * @param scriptType 脚本类型
     * @param script     脚本内容
     * @param <T>        返回值类型
     * @return 返回值
     * @throws ScriptException
     */
    public static <T> T exeScriptResult(String scriptType, String script) throws ScriptException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(scriptType);
        return (T) scriptEngine.eval(script);
    }

    /**
     * 输入输出脚本引擎
     *
     * @param scriptType 脚本类型
     * @param script     脚本
     * @param input      脚本入参
     * @param inputValue 脚本入参值
     * @param output     脚本出参
     * @param <T>        脚本出参类型
     * @return 脚本出参返回值
     * @throws ScriptException
     */
    public static <T> T exeScriptInOut(String scriptType, String script, String input, Object inputValue, String output) throws ScriptException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(scriptType);
        scriptEngine.put(input, inputValue);
        scriptEngine.eval(script);
        return (T) scriptEngine.get(output);
    }

    /**
     * 脚本编译器
     *
     * @param scriptType 脚本类型
     * @param script     脚本
     * @return 编译后的脚本对象
     * @throws ScriptException
     */
    public static CompiledScript initCompileScript(String scriptType, String script) throws ScriptException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByExtension(scriptType);
        if (scriptEngine instanceof Compilable) {
            Compilable compilable = (Compilable) scriptEngine;
            return compilable.compile(script);
        } else {
            throw new ScriptException("该脚本语言不支持编译,编译失败");
        }
    }

    /**
     * 脚本方法回调
     *
     * @param scriptType  脚本类型
     * @param script      脚本
     * @param funName     方法名
     * @param inputValues 入参
     * @param <T>         返回值类型
     * @return 返回值
     * @throws ScriptException
     * @throws NoSuchMethodException
     */
    public static <T> T invokeFunction(String scriptType, String script, String funName, Object... inputValues) throws ScriptException, NoSuchMethodException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByExtension(scriptType);
        scriptEngine.eval(script);
        if (scriptEngine instanceof Invocable) {
            Invocable invocable = (Invocable) scriptEngine;
            return (T) invocable.invokeFunction(funName, inputValues);
        } else {
            throw new ScriptException("该脚本语言不支持方法回调,回调失败");
        }
    }

    /**
     * 接口绑定回调
     *
     * @param scriptType 脚本类型
     * @param script     脚本
     * @param type       接口类型
     * @param <T>        返回值类型
     * @return 返回值
     * @throws ScriptException
     */
    public static <T> T getMapper(String scriptType, String script, Class type) throws ScriptException {
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByExtension(scriptType);
        scriptEngine.eval(script);
        if (scriptEngine instanceof Invocable) {
            Invocable invocable = (Invocable) scriptEngine;
            return (T) invocable.getInterface(type);
        } else {
            throw new ScriptException("该脚本语言不支持方法接口绑定,回调失败");
        }
    }

    private ScriptEngineManagerUtil() {

    }

}

















