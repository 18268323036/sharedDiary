package com.heartBar.sharedDiary.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxy 2017/11/27 16:38
 */
@RestController
public class SolrController {

    @Autowired
    private SolrClient client;

    @RequestMapping("/solr/test")
    public String testSolr() throws IOException, SolrServerException {
        SolrDocument document = client.getById("2");
        System.out.println(document);
        return document.toString();
    }


    @RequestMapping("/solr/add")
    public String addSolr() throws IOException, SolrServerException {
        List<SolrInputDocument> inputDocuments = new ArrayList<>();
        SolrInputDocument inputDocument = new SolrInputDocument();
        inputDocument.setField("id","235");
        inputDocument.setField("name","bilibi2li");
        inputDocument.setField("folderId","1700");
        inputDocument.setField("diaryTitle","solr插we入试");
        inputDocument.setField("diaryTitle","solr插q入");
        inputDocument.setField("diaryContent","脸上肯定减r肥IQ噢今儿个是你的");
        inputDocuments.add(inputDocument);
        SolrInputDocument inputDocument2 = new SolrInputDocument();
        inputDocument2.setField("id","666");
        inputDocument2.setField("name","bilibili2");
        inputDocument2.setField("folderId","1003");
        inputDocument2.setField("diaryTitle","solr插入试12");
        inputDocument2.setField("diaryTitle","solr插31入");
        inputDocument2.setField("diaryContent","脸上肯定减肥IweQ噢今儿个是你的");
        inputDocuments.add(inputDocument2);
        UpdateResponse updateResponse = client.add(inputDocuments);
        client.commit();
        client.close();
        return updateResponse.toString();
    }

    @RequestMapping("/solr/query")
    public Object querySolr() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        //下面设置solr查询参数
        query.set("q", "*:*");// 参数q  查询所有
//        query.set("q","周星驰");//相关查询，比如某条数据某个字段含有周、星、驰三个字  将会查询出来 ，这个作用适用于联想查询
        //参数fq, 给query增加过滤查询条件
        //query.addFilterQuery("id:[0 TO 11111]");//id为0-4
        //给query增加布尔过滤条件
        //query.addFilterQuery("description:演员");  //description字段中含有“演员”两字的数据
        //参数df,给query设置默认搜索域
        query.set("df", "name");
        //参数sort,设置返回结果的排序规则
        //query.setSort("id",SolrQuery.ORDER.desc);
        //设置分页参数
        query.setStart(0);
        query.setRows(10);//每一页多少值
        QueryResponse queryResponse = client.query(query);
        return queryResponse.getResults();
    }


}
