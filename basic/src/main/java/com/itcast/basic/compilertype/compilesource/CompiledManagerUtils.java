package com.itcast.basic.compilertype.compilesource;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import com.sun.tools.javac.Main;


/**
 * Created by qfl on 16/5/15.
 * 本类演示java代码编译java源代码的方法
 */
public class CompiledManagerUtils {

    /**
     * 编译指定路径的java源代码
     *
     * @param from
     * @param to
     */
    public static void compileSource(String from, String to) {

        checkVaildFile(from, to);
        File file = new File(from);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        ArrayList<String> fileLists = new ArrayList<String>();
        int result = 0;
        String[] compileParams = {};
        initFileLists(file, fileLists);
        for (String path : fileLists) {
            compileParams = new String[]{"-encoding", "UTF-8", "-d", to, path};
            result = compiler.run(null, null, null, new String[]{"-encoding", "UTF-8", "-d", to, path});
            result = Main.compile(compileParams);
            compileParams = new String[]{"javac", "-encoding", "UTF-8", "-d", to, path};
            ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"javac", "-encoding", "UTF-8", "-d", to, path});
            try {
                processBuilder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println((result == 0 ? "sucess" : "compile " + path + " fails"));
        }
    }

    /**
     * 生成jar包文件
     *
     * @param from
     * @param to
     */
    public static void compressJarFile(String from, String to) {
        checkVaildFile(from, to);
        File file = new File(to + File.separator + "target.jar");
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        try {
            JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file), manifest);
            initCompress(new File(from), jarOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化jar包
     *
     * @param dir
     * @param jarOutputStream
     */
    private static void initCompress(File dir, JarOutputStream jarOutputStream) {

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory())
                    initCompress(file, jarOutputStream);
                else if (file.isFile())
                    compile(file, jarOutputStream);
            }

        } else if (dir.isFile()) {
            compile(dir, jarOutputStream);
        }
    }

    /**
     * jar包压缩核心
     *
     * @param file
     * @param jarOutputStream
     */
    private static void compile(File file, JarOutputStream jarOutputStream) {
        try {
            BufferedInputStream reader = null;
            jarOutputStream.putNextEntry(new JarEntry(file.getPath()));
            reader = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            while (true) {
                int count = reader.read(buffer);
                if (count == -1)
                    break;
                jarOutputStream.write(buffer, 0, count);
            }
            jarOutputStream.closeEntry();
            if (reader != null)
                reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 迭代文件路径
     *
     * @param dir
     * @param list
     */
    private static void initFileLists(File dir, ArrayList list) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files)
                if (file.isFile())
                    list.add(file.getPath());
                else if (file.isDirectory())
                    initFileLists(file, list);
        } else if (dir.isFile()) {
            list.add(dir.getPath());
        }
    }

    /**
     * 验证参数的合法性
     *
     * @param from
     * @param to
     */
    private static void checkVaildFile(String from, String to) {
        if (from == null || to == null)
            throw new NullPointerException("路径不能为空");
        File file = new File(to);
        if (!file.isDirectory())
            throw new IllegalArgumentException("请输入正确的路径");
        if (!file.exists())
            file.mkdirs();
    }

}
