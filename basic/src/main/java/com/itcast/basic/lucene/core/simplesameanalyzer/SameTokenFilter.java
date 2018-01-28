package com.itcast.basic.lucene.core.simplesameanalyzer;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.util.AttributeSource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qfl on 16/5/18.
 */

public class SameTokenFilter extends TokenFilter {

    private Map<String, String[]> sameTokenMaps;
    // 保存相应的词汇
    private CharTermAttribute cta;
    // 保存词与词之间的位置增量
    private PositionIncrementAttribute pia;
    // 定义一个状态
    private AttributeSource.State current;
    // 用栈保存同义词集合
    private Stack<String> sames;

    public SameTokenFilter(TokenStream input, String path, String preSplitTag, String postSplitTag) {
        super(input);
        initSameTokens(path, preSplitTag, postSplitTag);
        sames = new Stack<String>();
        cta = input.addAttribute(CharTermAttribute.class);
        pia = input.addAttribute(PositionIncrementAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {

        if (!sames.isEmpty()) {
            String token = sames.pop();
            // 还原状态
            restoreState(current);
            // 先清空,再添加
            cta.setEmpty();
            cta.append(token);
            // 设置位置为0,表示同义词
            pia.setPositionIncrement(0);
            return true;
        }

        if (!this.input.incrementToken())
            return false;

        if (isIncludeSameToken(cta.toString()))
            current = captureState();

        return true;
    }

    /**
     * 判断是否包含同义词词元
     *
     * @param token
     * @return
     */
    private boolean isIncludeSameToken(String token) {

        if (!sameTokenMaps.isEmpty()) {
            for (String s : sameTokenMaps.get(token))
                sames.push(s);
        }
        if (sames.isEmpty())
            return false;
        return true;
    }

    /**
     * 初始化同义词库
     *
     * @param path
     * @param preSplitTag
     * @param postSplitTag
     */
    private void initSameTokens(String path, String preSplitTag, String postSplitTag) {
        if (path == null)
            throw new NullPointerException("路径不能为null");
        File file = new File(path);
        if (!file.isFile())
            throw new IllegalArgumentException("文件路径不正确");
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String text = "";
            sameTokenMaps = new HashMap<String, String[]>();
            while ((text = reader.readLine()) != null) {
                String[] strs = text.split(preSplitTag);
                sameTokenMaps.put(strs[0], strs[1].split(postSplitTag));
            }
            if (reader != null)
                reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
