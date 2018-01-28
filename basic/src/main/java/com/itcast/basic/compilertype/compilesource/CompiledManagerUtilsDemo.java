package com.itcast.basic.compilertype.compilesource;

import java.io.File;

/**
 * Created by qfl on 16/5/15.
 */
public class CompiledManagerUtilsDemo {
    public static void main(String[] args) {
        String sourcePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "com.itcast.basic.compilertype.compilesource.compilesourcefile".replace(".", File.separator);
        String compiledPath = sourcePath.replace("compilesourcefile", "compileclassfile");
        System.out.println(sourcePath);
        CompiledManagerUtils.compileSource(sourcePath + File.separator + "AnimalActions.java", compiledPath);
        CompiledManagerUtils.compressJarFile(sourcePath + File.separator + "AnimalActions.java",compiledPath);
    }
}
