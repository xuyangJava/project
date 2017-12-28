package com.siping.lucene;

import java.io.File;
import java.io.FileReader;
import java.nio.file.FileSystems;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneTester {
    String indexDir = "D:/Luene/Index";
    String dataDir = "D:/Luene/Data";

    public static void main(String[] args) {
        LuceneTester tester;
        tester = new LuceneTester();
        int numIndexed;
        long startTime = System.currentTimeMillis();
        numIndexed = tester.index();
        long endTime = System.currentTimeMillis();
        System.out.println(numIndexed + " File indexed, time taken: " + (endTime - startTime) + " ms");
        tester.search("日期");
    }

    public int index() {
        IndexWriter indexWriter = null;
        try {
            // 1、创建Directory--此类表示索引的存储位置
            // JDK 1.7以后 open只能接收Path
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(indexDir));
            // 2、创建IndexWriter--此类充当创造/在索引过程中更新指标的核心组成部分
            Analyzer analyzer = new StandardAnalyzer();// --Analyzer类负责分析一个文件，并从将被索引的文本获取令牌/字。不加分析完成后，IndexWriter不能创建索引
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();// 清除以前的index
            // 要搜索的File路径
            File dFile = new File(dataDir);
            File[] files = dFile.listFiles();
            for (File file : files) {
                // 3、创建Document对象
                Document document = new Document();
                // 4、为Document添加Field--Document代表一个虚拟文档与字段，其中字段是可包含在物理文档的内容，元数据等对象。Analyzer只能理解文档。
                // Field -- Field是最低单元或索引过程的起点。它代表其中一个键被用于识别要被索引的值的键值对关系。用于表示一个文件内容的字段将具有键为“内容”，值可以包含文本或文档的数字内容的部分或全部。 Lucene能索引仅文本或仅数字内容。
                // 第三个参数是FieldType 但是定义在TextField中作为静态变量，看API也不好知道怎么写
                document.add(new TextField("content", new FileReader(file)));
                // 假如要保存content，可以将content通过流转成字符串再存储
                document.add(new TextField("filename", file.getName(), Field.Store.YES));
                document.add(new TextField("filepath", file.getAbsolutePath(), Field.Store.YES));

                // 5、通过IndexWriter添加文档到索引中
                indexWriter.addDocument(document);
            }
            return indexWriter.numDocs();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (indexWriter != null) {
                    indexWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void search(String keyWord) {
        DirectoryReader directoryReader = null;
        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(indexDir));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

            // 4、创建搜索的Query
            Term t = new Term("content", keyWord);
            Query query = new TermQuery(t);

            // 5、根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(query, 10);
            System.out.println("查找到的文档总共有：" + topDocs.totalHits);

            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {

                // 7、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);

                // 8、根据Document对象获取需要的值
                System.out.println(document.get("filename") + " " + document.get("filepath"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (directoryReader != null) {
                    directoryReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
