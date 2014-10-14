package com.eleks.xml;

import com.eleks.inform.Location;
import com.eleks.inform.NewInfWeather;
import com.eleks.inform.WeatherInformation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {

    private int titleFlag = 0; // if true than first title

    private String thisElement = "";
    private WeatherInformation inf = new WeatherInformation();
    private ArrayList<String> temperatures = new ArrayList<String>();
    private ArrayList<Object> list = new ArrayList<Object>();
    private ArrayList<NewInfWeather> weatherinf = new ArrayList<NewInfWeather>();


    public ArrayList<NewInfWeather> getInfo2() {
        return weatherinf;
    }

    public WeatherInformation getInfo() {
        return inf;
    }

    public ArrayList<Object> getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {

        System.out.println("start parse");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        thisElement = qName;
        String temperature = "";
        if (qName.equals("yweather:location")) {
            Location location = new Location();
            location.setCity(attributes.getQName(0));
            location.setRegion(attributes.getQName(1));
            location.setCountry(attributes.getQName(2));

            inf.setLocation(location);
            list.add(location);
        }

        if (qName.equals("yweather:forecast")) {

            for (int i = 0; i < attributes.getLength(); i++) {
                temperature += attributes.getQName(i) + "=" + attributes.getValue(i) + " ";
            }
            temperatures.add(temperature);
            list.add(temperature);

            String code = (String) attributes.getValue(1);
            String date = (String) attributes.getValue(2);
            String day = (String) attributes.getValue(3);
            String high = (String) attributes.getValue(4);
            String low = (String) attributes.getValue(5);
            String text = (String) attributes.getValue(6);
            weatherinf.add(new NewInfWeather(code, date, day, high, low, text));

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {


        if ((thisElement.equals("title")) && (titleFlag == 0)) {

            inf.setChanelltitle(new String(ch, start, length));
            list.add(new String(ch, start, length));

        } else if ((thisElement.equals("title")) && (titleFlag == 2)) {

            inf.setItemtitle(new String(ch, start, length));
            list.add(new String(ch, start, length));

        } else if (thisElement.equals("geo:long")) {

            inf.setLongitube(new Double(new String(ch, start, length)));
            list.add(new Double(new String(ch, start, length)));

        } else if (thisElement.equals("geo:lat")) {

            inf.setLatitube(new Double(new String(ch, start, length)));
            list.add(new Double(new String(ch, start, length)));

        }

        if (thisElement.equals("title")) {

            titleFlag++;

        }

        thisElement = "";

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
        inf.setTemperatures(temperatures);

    }
}