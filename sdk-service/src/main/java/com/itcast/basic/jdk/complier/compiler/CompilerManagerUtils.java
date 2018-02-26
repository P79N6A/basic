package com.itcast.basic.jdk.complier.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/2/4.
 * java编译器
 */
public class CompilerManagerUtils {

    private static final String FILE_TYPE = ".java";

    //javax.tools.JavaCompiler
    private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    private static final List<String> compilerTypes = Arrays.asList(new String[]{"main", "tool", "process"});

    /**
     * 编译java源文件
     *
     * @param from         java源文件或存放java源文件的文件夹
     * @param to           class文件或存放class文件的文件夹
     * @param compilerType 编译器类别
     * @return 编译是否成功
     */
    public static boolean compilerSource(String from, String to, String compilerType) {
        boolean isSuccess = true;
        List<File> fileList = new ArrayList<>();
        compilerType = (compilerType == null ? "main" : compilerTypes.contains(compilerType.toLowerCase()) ? compilerType.toLowerCase() : "main");
        int result = 0;
        try {
            //路径校验器
            checkPathValid(from, to);
            //组装源文件集
            convertComplierFiles(new File(from), fileList);
            if (fileList.isEmpty()) {
                System.out.println("warn:不存在需要编译的源文件");
            } else {
                for (File file : fileList) {
                    result += compiler(compilerType, to, file.getPath());
                }
            }
            if (result != 0) {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

    /**
     * 编译器
     *
     * @param compilerType 编译器类型
     * @param target       class文件存放路径
     * @param source       java源文件路径
     * @return
     */
    private static int compiler(String compilerType, String target, String source) {
        String[] compileParams = new String[]{"-encoding", "UTF-8", "-d", target, source};
        int result = 0;
        switch (compilerType) {
            case "tool":
                result += compiler.run(null, null, null, compileParams);
                System.out.println("use tool compiler");
                break;
            case "main":
                //com.sun.tools.javac.Main
//                result += Main.compile(compileParams);
                System.out.println("use main compiler");
                break;
            case "process":
                //java.lang.ProcessBuilder
                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"javac", "-encoding", "UTF-8", "-d", target, source});
                try {
                    processBuilder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = -1;
                }
                System.out.println("use process complier");
                break;
        }

        return result;
    }

    /**
     * 组装java源文件集
     *
     * @param file
     * @param fileList
     */
    private static void convertComplierFiles(File file, List<File> fileList) {
        if (file.isFile()) {
            String fileName = file.getName();
            if (fileName.lastIndexOf(FILE_TYPE) > 0) {
                fileList.add(file);
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fil : files) {
                convertComplierFiles(fil, fileList);
            }
        }
    }


    /**
     * 检查路径是否合法
     *
     * @param from 源文件路径
     * @param to   class文件路径
     */
    private static void checkPathValid(String from, String to) throws Exception {
        if (from == null) {
            throw new NullPointerException(from);
        }
        if (to == null) {
            throw new NullPointerException(to);
        }

        File fromFile = new File(from);

        if (!fromFile.exists()) {
            throw new FileNotFoundException(from);
        }

        File toFile = new File(to);
        if (toFile.exists()) {
            if (toFile.isFile()) {
                throw new Exception(toFile.getName() + "必须是一个文件夹");
            } else if (toFile.listFiles().length > 0) {
                throw new Exception(toFile.getName() + "字节码文件夹包含子文件请清空");
            }
        } else if (toFile.isDirectory()) {
            boolean isSuccess = toFile.mkdirs();
            if (!isSuccess) {
                throw new Exception(toFile.getName() + "字节码文件夹创建失败");
            }
        }
    }
}




















