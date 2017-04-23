package com.apple.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Util method to send get request and map the result with desired class type.
     * @param url
     * @param urlParams
     * @param responseType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T get(String url, List<NameValuePair> urlParams, Class<T> responseType,Map<String,Object> headers) throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (!urlParams.isEmpty()) {
            url = url + "?"+ URLEncodedUtils.format(urlParams, "UTF-8").toString();
        }
        HttpGet getRequest = new HttpGet(url);
        getRequest.setHeader("Accept", "application/json");
        if(headers!=null){
            for (String key:headers.keySet()){
                getRequest.setHeader(key,headers.get(key).toString());
            }
        }
        CloseableHttpResponse httpResponse = httpClient.execute(getRequest);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        T response = null;
        if(responseString!=null && responseType!=null){
            response = mapper.readValue(responseString, responseType);
        }
        return response;
    }

    /**
     * Util method to send post request and map the result with desired class.
     * @param url
     * @param requestBody
     * @param responseType
     * @param <U>
     * @param <V>
     * @return
     * @throws IOException
     */
    public static <U, V> V post(String url, U requestBody, Class<V> responseType, Map<String,String> headers) throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader("Content-Type", "application/json");
        postRequest.setHeader("Accept", "application/json");
        if(headers!=null){
            for(String key:headers.keySet()){
                postRequest.setHeader(key,headers.get(key));
            }
        }
        StringEntity stringEntity = new StringEntity(mapper.writeValueAsString(requestBody),Charsets.UTF_8);
        postRequest.setEntity(stringEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(postRequest);
        verifyResponse(httpResponse);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        V response = null;
        if(!StringUtils.isEmpty(responseString) && responseType!=null){
            response = mapper.readValue(responseString, responseType);
        }
        return response;
    }

    /**
     * This method will call HTTP.Post with named Value params
     * @param url
     * @param nameValuePairs
     * @param responseType
     * @return
     * @throws IOException
     */
    public static <V> V post(String url, List<NameValuePair> nameValuePairs, Class<V> responseType, Map<String,String> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader("Accept", "application/json");
        if(headers!=null){
            for(String key:headers.keySet()){
                postRequest.setHeader(key,headers.get(key));
            }
        }
        HttpEntity formEntity = new UrlEncodedFormEntity(nameValuePairs,Charsets.UTF_8);
        postRequest.setEntity(formEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(postRequest);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        V response = mapper.readValue(responseString, responseType);
        return response;
    }

    public static Object put() {
        return null;
    }

    public static Object patch() {
        return null;
    }

    public static Object delete() {
        return null;
    }

    private static void verifyResponse(HttpResponse httpResponse) throws HttpResponseException{
        System.out.println(httpResponse.getEntity());
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("status Code - "+statusCode);
        if(statusCode<200 || statusCode>=299){
            throw new HttpResponseException(statusCode,"Failed Http Request");
        }
    }

}
