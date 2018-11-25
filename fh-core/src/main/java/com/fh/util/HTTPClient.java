package com.fh.util;

import com.fh.common.ServerResponse;
import com.google.gson.Gson;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HTTPClient {

    /**
     * HTTPClient 查询
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static ServerResponse getHttp(String url, Map<String,String> params, Map<String,String> headers,boolean isValidate){
        CloseableHttpClient httpClient  = HttpClientBuilder.create().build();
        List<NameValuePair> pairs=new ArrayList<>();
        buildParams(params, pairs);
        try {
            UrlEncodedFormEntity urlEntity=new UrlEncodedFormEntity(pairs);
            String result = EntityUtils.toString(urlEntity, "utf-8");
            url += "?"+result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpGet httpGet = new HttpGet(url);
        buildHeaders(headers, httpGet,isValidate);
        CloseableHttpResponse response=null;
        String string="";
        try {
            response = httpClient.execute(httpGet);
            string = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            buildClose(httpClient, response , httpGet,null,null,null);
        }
        Gson gson=new Gson();
        return gson.fromJson(string, ServerResponse.class);
    }

    /**
     * httpClient 删除
     * @param url
     * @param id
     * @param headers
     * @return
     */
    public static ServerResponse sendDelete(String url,Integer id,Map<String,String> headers,boolean isValidate) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //如果请求路径没有后缀则不需要添加.jhtml
        HttpDelete httpDelete = new HttpDelete(url+"/"+id+".jhtml");
        buildHeaders(headers, httpDelete,isValidate);
        CloseableHttpResponse response=null;
        String string="";
        try {
            response = client.execute(httpDelete);
            string = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            buildClose(client, response , null,null,null,httpDelete);
        }

        Gson gson = new Gson();
        return gson.fromJson(string,ServerResponse.class);
    }


    public static void main(String[] args) {
      /* Map<String,String> map=new HashMap<>();
        map.put("id",8+"");
        map.put("brandName","惠普");
        map.put("logo","/upload/1d11fd6f-f1ac-46c3-bee3-0aebc18589e4.gif");
        map.put("brandDescribe","upload");
        String url="http://localhost:8082/brands.jhtml";
        ServerResponse response = sendPut(url, map, null);
        System.out.println(response);*/

        /*String url="http://localhost:8082/brands";
        ServerResponse response = sendDelete(url, 8, null);
        System.out.println(response);*/

       /* Map<String,String> map=new HashMap<>();
        map.put("brandName","惠普");
        map.put("logo","/upload/1d11fd6f-f1ac-46c3-bee3-0aebc18589e4.gif");
        map.put("brandDescribe","upload");
        String url="http://localhost:8082/brands.jhtml";
        ServerResponse response = sendPost(url, map, null);
        System.out.println(response);*/

        String url="http://localhost:8082/brands.jhtml";
        Map<String,String> map=new HashMap<>();
        map.put("id",26+"");
        ServerResponse response = getHttp(url, map, null,false);
        System.out.println(response);


    }


    /**
     * HTTPClient  修改
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static ServerResponse sendPut(String url,Map<String,String> params,Map<String,String> headers,boolean isValidate){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(url);
        Gson gson = new Gson();
        if (params!=null && !params.isEmpty()){
            String jsonParams = gson.toJson(params);
            StringEntity entity = new StringEntity(jsonParams,"utf-8");
            entity.setContentType("application/json");
            httpPut.setEntity(entity);
        }
        buildHeaders(headers, httpPut,isValidate);
        CloseableHttpResponse response=null;
        String string="";
        try {
            response = client.execute(httpPut);
            string = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            buildClose(client, response , null,null,httpPut,null);
        }

        return  gson.fromJson(string,ServerResponse.class);
    }


    /**
     * HTTPClient  添加
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static ServerResponse sendPost(String url, Map<String,String> params,Map<String,String> headers,boolean isValidate){
        //模拟浏览器
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //声明请求方法
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> pairList = new ArrayList<>();
        //参数
        buildParams(params, pairList);
        UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(pairList,"utf-8");
            httpPost.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        buildHeaders(headers, httpPost,isValidate);
        CloseableHttpResponse response=null;
        String string="";
        try {
            response = client.execute(httpPost);
            string = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            buildClose(client, response , null,httpPost,null,null);
        }
        Gson gson=new Gson();
        return gson.fromJson(string, ServerResponse.class);
    }


    /**
     * 关流
     * @param httpClient
     * @param response
     * @param httpGet
     * @param httpPost
     */
    private static void buildClose(CloseableHttpClient httpClient,  CloseableHttpResponse response,
                       HttpGet httpGet,HttpPost httpPost,HttpPut httpPut,HttpDelete httpDelete) {
        if (null!=response){
            try {
                response.close();
                response=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null!=httpGet){
            httpGet.releaseConnection();
            httpGet=null;
        }
        if (null!=httpPost){
            httpPost.releaseConnection();
            httpPost=null;
        }
        if (null!=httpPut){
            httpPut.releaseConnection();
            httpPut=null;
        }
        if (null!=httpDelete){
            httpDelete.releaseConnection();
            httpDelete=null;
        }
        if (null!=httpClient){
            try {
                httpClient.close();
                httpClient=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给header赋值
     * @param headers
     * @param request
     */
    private static void buildHeaders(Map<String, String> headers, HttpRequest request,boolean isValidate) {
        if (headers!=null && !headers.isEmpty()){
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                request.addHeader(next.getKey(),next.getValue());
            }
        }
        if (isValidate){
            String nonce = UUID.randomUUID().toString()+":"+RandomStringUtils.randomAlphanumeric(10)+":"+System.currentTimeMillis();
            long time = new Date().getTime();
            String appKey = "b5d69cd6-2961-49b9-ab9e-f3234be13c3e";
            String sign = CheckSumBuilder.getCheckSum("67dde407-4571-4587-8a28-9dc1329c9521", nonce, time + "");
            request.addHeader(SystemUtil.APP_APPKEY,appKey);
            request.addHeader(SystemUtil.APP_NONCE,nonce);
            request.addHeader(SystemUtil.APP_TIME,time+"");
            request.addHeader(SystemUtil.APP_SIGN,sign);
        }
    }

    /**
     * 赋值body
     * @param params
     * @param pairList
     */
    private static void buildParams(Map<String, String> params, List<NameValuePair> pairList) {
        if (params!=null && params.size()>0){
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                pairList.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
    }

}
