package com.eleks.createfile;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class CreatorWeatherFile extends AbstractCreatorWeather {
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
