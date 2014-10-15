package com.eleks.parser;


import com.eleks.inform.NewInfWeather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ParserUniversal implements Parserable {
    @Override
    public ArrayList<NewInfWeather> parseString(String str) {
        FileReader reader = null;
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();

//        if (str.charAt(0) == '<') {
//            try {
//                jsonObject = XML.toJSONObject(str);
//            } catch (JSONException je) {
//
//            }
//        } else {

        try {
            jsonObject = (JSONObject) jsonParser.parse(str);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        // }


        ArrayList<Object> list = new ArrayList<Object>();

        org.json.simple.JSONObject query = null;
        query = (JSONObject) jsonObject.get("query");

        org.json.simple.JSONObject results = (org.json.simple.JSONObject) query.get("results");
        org.json.simple.JSONObject channel = (org.json.simple.JSONObject) results.get("channel");
        org.json.simple.JSONObject item = (org.json.simple.JSONObject) channel.get("item");

        list.add(item.get("title"));
        list.add(item.get("lat"));
        list.add(item.get("long"));
        list.add(item.get("link"));
        //get array
        // get an array from the JSON object+
        ArrayList<NewInfWeather> weatherinf = new ArrayList<NewInfWeather>();
        JSONArray forecast = (JSONArray) item.get("forecast");
        Iterator i = forecast.iterator();

        while (i.hasNext()) {
            org.json.simple.JSONObject slide = (org.json.simple.JSONObject) i.next();
            String code = (String) slide.get("code");
            String date = (String) slide.get("date");
            String day = (String) slide.get("day");
            String high = (String) slide.get("high");
            String low = (String) slide.get("low");
            String text = (String) slide.get("text");
            weatherinf.add(new NewInfWeather(code, date, day, high, low, text));
            System.out.println(code);
        }
        list.add(weatherinf);
        return weatherinf;


    }
}
