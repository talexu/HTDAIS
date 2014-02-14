package com.talexu.htdais_demo_cx_extractor;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println("Hello World!");

		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	HttpGet httpget = new HttpGet("http://news.163.com/14/0214/02/9L0SL2S300014AEE.html#f=dfocus");
//            HttpGet httpget = new HttpGet("http://news.ifeng.com/mainland/detail_2014_02/14/33821165_0.shtml");

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
            String html = new TextExtract().parse(responseBody);
            System.out.println(html);
            
        } finally {
            httpclient.close();
        }
	}
}
