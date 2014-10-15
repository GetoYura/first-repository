package com.eleks.parser;


import com.eleks.inform.NewInfWeather;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.eleks.parser.SAXHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class ParserXml implements Parserable {

    public ArrayList<NewInfWeather> parseString (String str) {
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
            parser.parse(new InputSource(new StringReader(str)), handler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return handler.getInfo2();

    }


}
