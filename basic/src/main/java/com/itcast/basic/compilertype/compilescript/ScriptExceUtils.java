package com.itcast.basic.compilertype.compilescript;

import com.sun.script.javascript.RhinoScriptEngine;

import javax.script.*;
import java.io.*;

/**
 * Created by qfl on 16/5/14.
 */
public class ScriptExceUtils {

    private static ScriptEngineManager manager;

    static {
        manager = new ScriptEngineManager();
        for (ScriptEngineFactory factory : manager.getEngineFactories())
            System.out.println(factory.getEngineName() + " " + factory.getEngineVersion() + " " + factory.getLanguageName() + " " + factory.getLanguageVersion());
    }

    /**
     * 得到相应脚本语言的执行引擎
     *
     * @param language 脚本语言名称
     * @return
     */
    public static ScriptEngine getScriptEngine(String language) {
        ScriptEngine engine = manager.getEngineByName(language);
        if (engine == null)
            throw new NullPointerException("脚本引擎获取失败");
        return engine;
    }

    /**
     * 返回指定文件路径下的输入字符流
     *
     * @param fileFullPath
     * @return
     */
    public static Reader getReaderByPath(String fileFullPath) {

        Reader reader = null;
        try {
            File file = new File(fileFullPath);
            if (!file.isFile())
                throw new IllegalArgumentException("文件路径不正确");
            reader = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }

    /**
     * 执行javascript脚本文件中的js函数
     *
     * @param methodName   方法名称
     * @param params       方法参数
     * @param fileFullPath 脚本文件全路径
     * @param lanauage     被执行的脚本
     * @return
     */
    public static Object getMethodResult(String methodName, Object[] params, String fileFullPath, String lanauage) {

        Object result = null;
        CompiledScript compiledScript = null;
        ScriptEngine engine = getScriptEngine(lanauage);
        Class classType = engine.getClass();
        while (classType != null) {
            System.out.println("class type is " + classType.getName());
            classType = classType.getSuperclass();
        }
        try {
            Reader reader = getReaderByPath(fileFullPath);
            if (engine instanceof Compilable)
                compiledScript = ((Compilable) engine).compile(reader);
            if (compiledScript == null)
                engine.eval(reader);
            else
                compiledScript.eval();
            if (engine instanceof Invocable)
                result = ((Invocable) engine).invokeFunction(methodName, params);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }

}
