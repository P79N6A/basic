package com.itcast.basic.lucene.core.simpleanalyzer;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.analysis.MMSegTokenizer;
import com.itcast.basic.lucene.core.simplesameanalyzer.SameTokenFilter;
import org.apache.lucene.analysis.*;
import org.apache.lucene.util.Version;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by qfl on 16/5/15.
 */
public class SimpleStopAnalyzer extends Analyzer {

    private Set stopSet;
    private Dictionary dictionary;
    private String path;

    public SimpleStopAnalyzer(File stopTokenFile, String path, String samePath) {
        stopSet = StopFilter.makeStopSet(Version.LUCENE_35, compressStopTokenFromFile(stopTokenFile), true);
        stopSet.addAll(StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        this.dictionary = Dictionary.getInstance(path);
        this.path = samePath;
    }

    /**
     * StopFilter:停用词拦截器
     * LowerCaseFilter:转为小写的拦截器
     * PorterStemFilter:转为词根的拦截器
     * LetterTokenizer:转为单数的分词器
     *
     * @param s
     * @param reader
     * @return
     */
    @Override
    public TokenStream tokenStream(String s, Reader reader) {
        return new SameTokenFilter(new StopFilter(Version.LUCENE_35, new LowerCaseFilter(Version.LUCENE_35, new MMSegTokenizer(new MaxWordSeg(dictionary), reader)), stopSet), path, ":", ";");
    }

    private List<String> compressStopTokenFromFile(File file) {
        List<String> stopTokenLists = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String text = "";
            while ((text = reader.readLine()) != null)
                stopTokenLists.add(text);
            if (reader != null)
                reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopTokenLists;
    }
}
