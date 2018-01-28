package com.itcast.basic.lucene.core;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by qfl on 16/5/12.
 */
public class LuceneUtilsDemo {
    public static void main(String[] args) throws IOException, ParseException {
        String[] arr = {"java", "ruby", "lucene", "elasticsearch", "javascript", "c", "c++", "php", "swift", "android", "scala", "hadoop", "spark"};
        LuceneUtils utils = new LuceneUtils();
        IndexWriter writer = utils.getIndexWriter();
        for (int i = 0; i < arr.length; i++) {
            Document document = new Document();
            document.add(new Field("id", String.valueOf(i + 1), Field.Store.YES, Field.Index.NO));
            document.add(new Field("language", arr[i], Field.Store.YES, Field.Index.ANALYZED));
            document.add(new Field("company", "handu", Field.Store.YES, Field.Index.ANALYZED));
            document.add(new NumericField("attach", Field.Store.YES, false).setIntValue(i + 1));
            document.setBoost((float) Math.random());
            writer.addDocument(document);
        }
        writer.commit();
//        utils.deleteIndexByConditions(true, new Term("language", "java"));
//        if (writer != null)
//            writer.close();
        IndexSearcher searcher = utils.getIndexSearcher();
        QueryParser parser = new QueryParser(Version.LUCENE_35, "language", new StandardAnalyzer(Version.LUCENE_35));
        Query query = parser.parse("java");
        List<Document> lists = utils.getIndexScoreDocuments(searcher, query, 5);
        for (Document doc : lists)
            System.out.println(doc.get("language"));
//        utils.deleteIndexById(0);
//        utils.deleteIndexByCondition(new Term("language", "java"));
//        utils.indexDocument(writer, null);
//        utils.sysAllDocuments();
//        System.out.println("document index number is " + utils.getIndexNumberByType(1));
//        System.out.println("deleted document index number is " + utils.getIndexNumberByType(0));
//        utils.unDeleteIndex();
//        System.out.println("document index number is " + utils.getIndexNumberByType(1));
//        System.out.println("deleted document index number is " + utils.getIndexNumberByType(0));
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "com.itcast.basic.lucene".replace(".", File.separator);
        System.out.println("path" + path);
        String content = "I liking china,this is great tools and i think it is best language of lucene,what do you think,我喜欢中国,你喜欢中国吗";
//        StandardAnalyzer standardAnalyzer = new StandardAnalyzer(Version.LUCENE_35, new File(path));
//        SimpleStopAnalyzer standardAnalyzer = new SimpleStopAnalyzer(new File(path + File.separator + "stopToken.txt"), path + File.separator + "data");
//        MMSegAnalyzer segAnalyzer = new MMSegAnalyzer(Dictionary.getInstance(path));
//        System.out.println(LuceneUtils.tokenStream(standardAnalyzer, content));
//        Iterator iterators = standardAnalyzer.STOP_WORDS_SET.iterator();
//        while (iterators.hasNext()) {
//            char[] chars = (char[]) iterators.next();
//            System.out.println("stop words is " + new String(chars));
//        }
        path = path + File.separator + "simplesameanalyzer" + File.separator + "sameToken.txt";

    }
}
