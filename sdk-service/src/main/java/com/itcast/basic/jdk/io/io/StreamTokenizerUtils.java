package com.itcast.basic.jdk.io.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class StreamTokenizerUtils {

    public static void operateStreamTokenizer() throws IOException {
        String text = "i am lily,i 100 like swimming;i think 205 this is fine and what about you? 200 ";
        CharArrayReader charArrayReader = new CharArrayReader(text.toCharArray());
        BufferedReader bufferedReader = new BufferedReader(charArrayReader);
        StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[3];
        double[] doubles = new double[3];
        int i = 0;
        int j = 0;
        //字符缓冲流
        while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            //在调用 nextToken 方法之后，ttype字段将包含刚读取的标记的类型
            switch (streamTokenizer.ttype) {
                //TT_EOL指示已读到行末尾的常量。
                case StreamTokenizer.TT_EOL:
                    System.out.println("文本解析完毕");
                    break;
                //TT_NUMBER指示已读到一个数字标记的常量
                case StreamTokenizer.TT_NUMBER:
                    //如果当前标记是一个数字，nval字段将包含该数字的值
                    doubles[i++] = streamTokenizer.nval;
                    break;
                //TT_WORD指示已读到一个文字标记的常量
                case StreamTokenizer.TT_WORD:
                    stringBuilder.append(streamTokenizer.sval);
                    break;
                default:
                    //如果以上3中类型都不是，则为英文的标点符号
                    chars[j++] = (char) streamTokenizer.ttype;
                    break;
            }
        }
        System.out.println("text is " + stringBuilder.toString()
                + "\n chars is " + Arrays.toString(chars)
                + "\n doubles is " + Arrays.toString(doubles));
    }
}
