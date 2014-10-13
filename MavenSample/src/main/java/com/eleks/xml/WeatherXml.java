package com.eleks.xml;

import com.eleks.createfile.AbstractCreatorWeather;
import com.eleks.inform.NewInfWeather;
import com.eleks.inform.Weatherable;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherXml implements Weatherable {

    private AbstractCreatorWeather creatorWeather;

    public WeatherXml(AbstractCreatorWeather creatorWeather) {
        this.creatorWeather = creatorWeather;
    }

    @Override
    public List<NewInfWeather> getWeather(String type) {
        //creatorWeather.createWeatherFile(type);
        return parseXml(creatorWeather.createWeatherString(type));
    }

    public ArrayList<NewInfWeather> parseXml(String str) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        SAXHandler handler = new SAXHandler();
        try {
            //parser.parse(new File("E:/samplexml.xml"), handler);
            //new InputSource(new StringReader(xml))
            parser.parse(new InputSource(new StringReader(str)), handler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return handler.getInfo2();

    }

    public void printList() {
//        String result = "";
//        assert parser != null;
//        parser.parse(String.valueOf(new StringReader(result)), handler);
    }
}


