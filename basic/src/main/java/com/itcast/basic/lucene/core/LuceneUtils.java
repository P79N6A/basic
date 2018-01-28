package com.itcast.basic.lucene.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.function.CustomScoreProvider;
import org.apache.lucene.search.function.CustomScoreQuery;
import org.apache.lucene.search.function.FieldScoreQuery;
import org.apache.lucene.search.function.ValueSourceQuery;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @CreatedBy qfl
 */
public class LuceneUtils {

    private volatile static IndexWriter writer;
    private IndexReader reader;
    private Directory directory;
    private IndexWriterConfig indexWriterConfig;

    public LuceneUtils() {
        this(null, new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35)), true);
    }

    public LuceneUtils(IndexWriterConfig config) {
        this(null, config, true);
    }

    public LuceneUtils(String path) {
        this(path, new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35)), false);
    }

    public LuceneUtils(String path, IndexWriterConfig config) {
        this(path, config, false);
    }

    public LuceneUtils(String path, IndexWriterConfig config, boolean isMemory) {
        if (config == null)
            throw new NullPointerException("IndexWriterConfig不能为null");
        this.indexWriterConfig = config;

        if (isMemory) {
            this.directory = new RAMDirectory();
            return;
        }

        if (path == null)
            throw new NullPointerException("路径不能为null");
        if (!(new File(path)).isDirectory())
            throw new IllegalArgumentException("请输入正确的路径");

        try {
            this.directory = FSDirectory.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public IndexWriter getIndexWriter() {
        if (writer == null)
            synchronized (this) {
                if (writer == null)
                    try {
                        writer = new IndexWriter(directory, indexWriterConfig);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        return writer;
    }

    /**
     * 批量索引文档
     *
     * @param documents
     * @return
     */
    public boolean indexDocumets(List<Document> documents) {

        checkIndexWriter(writer);
        checkDocuments(documents);
        boolean success = true;
        try {
            writer.addDocuments(documents);
            writer.commit();
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }
        return success;

    }

    /**
     * 索引文档
     *
     * @param document
     * @return
     */
    public boolean indexDocument(Document document) {
        checkIndexWriter(writer);
        checkDocument(document);
        boolean success = true;
        try {
            writer.addDocument(document);
            writer.commit();
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 得到搜索引擎实例
     *
     * @return
     */
    public IndexSearcher getIndexSearcher() {

        try {
            if (reader == null)
                reader = IndexReader.open(directory, false);
            else {
                IndexReader newReader = IndexReader.openIfChanged(reader);
                if (newReader != null) {
                    reader.close();
                    reader = newReader;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new IndexSearcher(reader);

    }

    /**
     * 返回索引文档的数目
     *
     * @param type 0 表示全部索引文档数目 1表示删除的索引文档数目
     * @return
     */
    public int getIndexNumberByType(int type) {
        checkIndexReader(reader);
        int number = 0;
        switch (type) {
            case 0:
                number = reader.numDeletedDocs();
                break;
            case 1:
                number = reader.numDocs();
                break;
            case 2:
                number = reader.maxDoc();
                break;
            default:
                throw new IllegalArgumentException("参数异常");
        }
        return number;
    }

    /**
     * 同步锁
     *
     * @param documentId 要删除的文档的编号
     * @return
     */
    public boolean deleteIndexById(int documentId) {
        checkIndexReader(reader);
        checkIndex(documentId);
        boolean success = true;
        try {
            reader.deleteDocument(documentId);
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 批量删除索引文档
     *
     * @param diskDel 是否物理删除
     * @param terms   查询条件集合
     * @return
     */
    public boolean deleteIndexByConditions(boolean diskDel, Term... terms) {
        checkIndexWriter(writer);
        boolean success = true;
        try {
            writer.deleteDocuments(terms);
            if (diskDel)
                writer.forceMergeDeletes();
            writer.commit();
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 还原回收站中的索引
     *
     * @return
     */
    public boolean unDeleteIndex() {
        checkIndexReader(reader);
        boolean success = true;
        try {
            reader.undeleteAll();
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 批量更新索引文档
     *
     * @param term
     * @param documents
     * @return
     */
    public boolean updateDocuments(Term term, List documents) {
        checkIndexWriter(writer);
        boolean success = true;
        try {
            writer.updateDocuments(term, documents);
            writer.commit();
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 同步锁条件删除
     *
     * @param term term完全匹配查询
     * @return
     */
    public boolean deleteIndexByCondition(Term term) {
        checkIndexReader(reader);
        boolean success = true;
        try {
            reader.deleteDocuments(term);
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * 根据查询条件返回指定条数的查询结果
     *
     * @param searcher
     * @param query
     * @param limits
     * @return
     */
    public List getIndexScoreDocuments(IndexSearcher searcher, Query query, int limits) {
        ArrayList<Document> lists = new ArrayList<Document>();
        try {
            TopDocs topDocs = searcher.search(query, limits);
            if (topDocs != null)
                for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                    lists.add(searcher.doc(scoreDoc.doc));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    private void checkDocuments(List<Document> documents) {
        if (documents.isEmpty())
            throw new IllegalArgumentException("documents不能为空");
    }

    private void checkIndexWriter(IndexWriter writer) {
        if (writer == null)
            throw new NullPointerException("IndexWriter不能为null");
    }

    private void checkIndexReader(IndexReader reader) {
        if (reader == null)
            throw new NullPointerException("IndexReader不能null");
    }

    private void checkDocument(Document document) {
        if (document == null)
            throw new NullPointerException("Document不能为null");
    }

    private void checkIndex(int index) {
        if (index < 0 || index > getIndexNumberByType(1))
            throw new IndexOutOfBoundsException("不存在该索引文档");
    }

    private void checkPageIndexAndPageSize(int pageIndex, int pageSize) {
        if (pageIndex < 1 || pageSize < 0)
            throw new IllegalArgumentException("参数异常");
    }

    /**
     * 枚举所有索引文档
     *
     * @param classes
     * @param condition
     */
    public void sysAllDocumentsByJavaInfo(Class<?> classes, String condition) {

        if (classes == null || condition == null)
            throw new NullPointerException("参数不能为null");
        try {
            Field[] fields = classes.getFields();
            if (fields.length == 0)
                throw new NullPointerException("属性不能为空");
            QueryParser parser = new QueryParser(Version.LUCENE_35, fields[0].getName(), new StandardAnalyzer(Version.LUCENE_35));
            Query query = parser.parse(condition);
            List<Document> documents = getIndexScoreDocuments(getIndexSearcher(), query, getIndexNumberByType(1));
            for (Document document : documents) {
                for (Field field : fields)
                    System.out.println(field.getName() + " -> " + document.get(field.getName()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据条件得到指定拦截器
     *
     * @param type
     * @return
     */
    public Filter getFilterByType(String field, String keywords, String lowerTerm, String uperTerm, boolean includeLower, boolean includeUper, int type) {
        Filter filter = null;
        switch (type) {
            case 0:
                filter = new QueryWrapperFilter(getQueryByCondition(type, field, null, keywords, lowerTerm, uperTerm, includeLower, includeUper));
                break;
            case 1:
                filter = new TermRangeFilter(field, lowerTerm, uperTerm, includeLower, includeUper);
                break;
            case 2:
                filter = NumericRangeFilter.newDoubleRange(field, Double.parseDouble(lowerTerm), Double.parseDouble(uperTerm), includeLower, includeUper);
                break;
        }
        return filter;
    }

    /**
     * 枚举所有索引
     */
    @Deprecated
    public void sysAllDocuments() {
        try {
            QueryParser parser = new QueryParser(Version.LUCENE_35, "id", new StandardAnalyzer(Version.LUCENE_35));
            Query query = parser.parse("company:handu");
            List<Document> documents = getIndexScoreDocuments(getIndexSearcher(), query, getIndexNumberByType(1));
            for (Document document : documents) {
                System.out.println(document.get("language"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据条件得到不同的查询语句
     * TermQuery:词元查询
     * TermRangeQuery:词元范围查询
     * NumericRangeQuery:数字范围查询
     * FuzzyQuery:模糊查询
     * PrefixQuery:前缀查询
     * WildcardQuery:通配符查询
     * BooleanQuery:组合查询
     * PhraseQuery:短语查询
     * QueryParser:万能匹配查询
     *
     * @param type         查询语句的类型
     * @param field        查询域
     * @param keywords     查询关键字
     * @param includeLower 是否包含下边界
     * @param includeUper  是否包含上边界
     * @return
     */
    public Query getQueryByCondition(int type, String field, QueryParser queryParser, String keywords, String lowerTerm, String uperTerm, boolean includeLower, boolean includeUper) {

        Query query = null;
        switch (type) {
            case 0:
                query = new TermQuery(new Term(field, keywords));
                break;
            case 1:
                query = new TermRangeQuery(field, lowerTerm, uperTerm, includeLower, includeUper);
                break;
            case 2:
                query = NumericRangeQuery.newLongRange(field, Long.parseLong(lowerTerm), Long.parseLong(uperTerm), includeLower, includeUper);
                break;
            case 3:
                query = new FuzzyQuery(new Term(field, keywords), 0.1f);
                break;
            case 4:
                query = new PrefixQuery(new Term(field, keywords));
                break;
            case 5:
                query = new WildcardQuery(new Term(field, keywords));
                break;
            case 6:
                BooleanQuery booleanQuery = new BooleanQuery();
                booleanQuery.add(new TermQuery(new Term(field, lowerTerm)), BooleanClause.Occur.MUST);
                booleanQuery.add(new TermQuery(new Term(field, uperTerm)), BooleanClause.Occur.MUST_NOT);
                booleanQuery.add(new TermQuery(new Term(field, keywords)), BooleanClause.Occur.SHOULD);
                query = booleanQuery;
                break;
            case 7:
                PhraseQuery phraseQuery = new PhraseQuery();
                phraseQuery.add(new Term(field, lowerTerm));
                phraseQuery.add(new Term(field, uperTerm));
                phraseQuery.setSlop(2);//slop表示lowerTerm和uperTerm之间词条的间隔数目
                query = phraseQuery;
                break;
            case 8:
                try {
                    /**
                     * queryParser.parse("*")默认域全匹配
                     * queryParser.parse("name:Lily*")前缀匹配
                     * queryParser.parse("-name:Lily +sex:man")组合查询
                     * queryParser.parse("id:[1 TO 10]")闭区间范围查询
                     * queryParser.parse("id:{1 TO 10}")开区间范围查询
                     * queryParser.parse("\"java\"")term完全匹配
                     * queryParser.parse("name:lily~")模糊匹配
                     */
                    queryParser.setDefaultOperator(QueryParser.Operator.AND);//设置空格 默认操作符
                    queryParser.setAllowLeadingWildcard(true);//开启通配符首字符匹配
                    query = queryParser.parse(keywords);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
        return query;
    }

    /**
     * 分页查询
     *
     * @param query
     * @param pageIndex
     * @param pageSize
     * @param type
     * @return
     */
    public List getSearchResults(Query query, int pageIndex, int pageSize, int type, Sort sort) {
        checkPageIndexAndPageSize(pageIndex, pageSize);
        List<Document> results = new ArrayList<Document>();
        IndexSearcher searcher = getIndexSearcher();
        switch (type) {
            case 0:
                compressDocumentLists(query, (pageIndex - 1) * pageSize, pageIndex * pageSize, results, searcher, sort);
                break;
            case 1:
                compressDocumentListsBySearchAfter(query, pageIndex, pageSize, results, searcher);
                break;
        }
        return results;
    }

    /**
     * searchAfter分页搜索核心代码
     *
     * @param query
     * @param pageIndex
     * @param pageSize
     * @param results
     * @param searcher
     */
    private void compressDocumentListsBySearchAfter(Query query, int pageIndex, int pageSize, List results, IndexSearcher searcher) {
        ScoreDoc scoreDoc = null;
        try {
            if (pageIndex != 1) {
                int num = (pageIndex - 1) * pageSize;
                scoreDoc = searcher.search(query, num).scoreDocs[num - 1];
            }
            ScoreDoc[] scoreDocs = searcher.searchAfter(scoreDoc, query, pageSize).scoreDocs;
            for (ScoreDoc doc : scoreDocs)
                results.add(searcher.doc(doc.doc));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分页搜索核心代码
     *
     * @param query
     * @param start
     * @param end
     * @param results
     */
    private void compressDocumentLists(Query query, int start, int end, List results, IndexSearcher searcher, Sort sort) {
        try {
            ScoreDoc[] scoreDocs = searcher.search(query, end, sort).scoreDocs;
            for (int i = start; i < end; i++)
                results.add(searcher.doc(scoreDocs[i].doc));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造多字段排序器
     *
     * @param beans
     * @return
     */
    public Sort getSort(List<SortFieldBean> beans) {
        List<SortField> sortFileds = new ArrayList();
        for (SortFieldBean bean : beans)
            sortFileds.add(new SortField(bean.sortField, bean.sortFieldType, bean.asc));
        return new Sort((SortField[]) sortFileds.toArray());
    }

    /**
     * 自定义评分器
     *
     * @param field 评分字段
     * @param type  评分字段类型
     * @param query 基础查询器
     * @return
     */
    public Query getCustomScoreQuery(String field, FieldScoreQuery.Type type, Query query) {
        return new SimpleScoreQuery(query, field, new FieldScoreQuery(field, type));
    }

    /**
     * 得到高亮文本域
     * QueryScorer scorer = new QueryScorer(query);
     * Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
     * Formatter formatter = new SimpleHTMLFormatter(preTag, postTag);
     * Highlighter highlighter = new Highlighter(formatter, scorer);
     * highlighter.setTextFragmenter(fragmenter);
     * return highlighter.getBestFragment(analyzer, "", document.get(field));
     *
     * @param field
     * @param query
     * @param analyzer
     * @param document
     * @param preTag
     * @param postTag
     * @return
     */
    public String getHighResults(String field, Query query, Analyzer analyzer, Document document, String preTag, String postTag) {
        String text = "";
        try {
            QueryScorer scorer = new QueryScorer(query);
            Highlighter highlighter = new Highlighter(new SimpleHTMLFormatter(preTag, postTag), scorer);
            highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
            text = highlighter.getBestFragment(analyzer, "", document.get(field));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 排序器元素类
     */
    class SortFieldBean {
        private String sortField;
        private int sortFieldType;
        private boolean asc;

        public SortFieldBean(String sortField, boolean asc, int sortFieldType) {
            this.sortField = sortField;
            this.asc = asc;
            this.sortFieldType = sortFieldType;
        }
    }

    /**
     * 自定义评分器
     */
    class SimpleScoreQuery extends CustomScoreQuery {

        private String field;

        public SimpleScoreQuery(Query subQuery, String field, ValueSourceQuery... valSrcQueries) {
            super(subQuery, valSrcQueries);
            this.field = field;
        }

        @Override
        protected CustomScoreProvider getCustomScoreProvider(IndexReader reader) throws IOException {
            return new SimpleCustomProvider(reader, field);
        }
    }

    /**
     * 评分器核心组件
     */
    class SimpleCustomProvider extends CustomScoreProvider {

        private int scores[] = {};

        public SimpleCustomProvider(IndexReader reader, String field) {
            super(reader);
            try {
                scores = FieldCache.DEFAULT.getInts(reader, field);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public float customScore(int doc, float subQueryScore, float valSrcScore) throws IOException {
            return scores[doc] / 10.0f;
        }

    }

    /**
     * 得到切词后的词元
     *
     * @param analyzer 分词器
     * @param content  文本
     * @return
     */
    public static String tokenStream(Analyzer analyzer, String content) {
        StringBuilder stringBuilder = new StringBuilder();
        TokenStream tokenStream = analyzer.tokenStream("", new StringReader(content));
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        try {
            while (tokenStream.incrementToken())
                stringBuilder.append("[" + charTermAttribute + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}









