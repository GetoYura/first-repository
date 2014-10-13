package com.eleks.createfile;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CreatorWeatherFile extends AbstractCreatorWeather {
    public void createWeatherFile(String type) {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {

            HttpHost target = new HttpHost("query.yahooapis.com", 80, "http");
            HttpGet getRequest = new HttpGet("/v1/public/yql?q=select%20item%20from%20weather.forecast%20where%20location%3D%2248907%22&format=" + "type");
            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();
            Header[] headers = httpResponse.getAllHeaders();

            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }

            if (entity != null) {
                String result = EntityUtils.toString(entity).toString();
                System.out.println(result);
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("E:/sample" + "type" + "." + type, "UTF-8");
                    writer.println(result);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        writer.close();
                    }
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            httpclient.getConnectionManager().shutdown();
        }


    }

    public String createWeatherString(String type) {
        String result = "";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpHost target = new HttpHost("query.yahooapis.com", 80, "http");
            String query = "/v1/public/yql?q=select%20item%20from%20weather.forecast%20where%20location%3D%2248907%22&format=" + type;
            HttpGet getRequest = new HttpGet(query);
            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();
            Header[] headers = httpResponse.getAllHeaders();

            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }

            if (entity != null) {
                result = EntityUtils.toString(entity).toString();
            }
            System.out.println("result " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            httpclient.getConnectionManager().shutdown();
        }

        return result;
    }

}
