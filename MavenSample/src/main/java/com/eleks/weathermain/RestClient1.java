package com.eleks.weathermain;

import com.eleks.createfile.CreatorWeatherFile;
import com.eleks.inform.NewInfWeather;
import com.eleks.parser.ParserJson;
import com.eleks.parser.ParserXml;
import com.eleks.parser.Parserable;
import com.eleks.workwithfile.OpenFile;

import java.util.List;

public class RestClient1 {

    public static void main(String[] args) {

        Long ts1 = System.currentTimeMillis();

        List<NewInfWeather> weatherList = null;
        CreatorWeatherFile creatorWeatherFile = new CreatorWeatherFile();

        String fetchResult = "";
        String formatType = "";
        Parserable weatherParser = null;


        // check comand line
        try {
            if (args[0].equalsIgnoreCase("XML")) {

                formatType = "xml";
                fetchResult = creatorWeatherFile.createWeatherString(formatType);

            } else if (args[0].equalsIgnoreCase("JSON")) {

                formatType = "json";
                fetchResult = creatorWeatherFile.createWeatherString(formatType);

            } else if (args[0].equalsIgnoreCase("LOCAL")) {
                System.out.println("we in local");
                OpenFile openFile = new OpenFile();
                fetchResult = openFile.parseToString((args[1]));

            } else {

                throw new IllegalArgumentException("Invalid format: only xml or json accepted");

            }

            // start parse
            if (args[0].equalsIgnoreCase("XML")) {
                weatherParser = new ParserXml();
            } else if (args[0].equalsIgnoreCase("JSON")) {
                weatherParser = new ParserJson();

            } else if (args[0].equalsIgnoreCase("LOCAL")) {
                if (args[1].toLowerCase().contains(".xml".toLowerCase())) {
                    weatherParser = new ParserXml();
                } else if (args[1].toLowerCase().contains(".json".toLowerCase())) {
                    weatherParser = new ParserJson();
                }
            }

            weatherList = weatherParser.parseString(fetchResult);

        } catch (Exception exception) {
            System.out.println(exception + " Input something");
            System.exit(0);
        }

        System.out.println("----------------------------------------------------------------------");
        for (NewInfWeather a : weatherList) {
            System.out.println(a);
        }
        Long ts2 = System.currentTimeMillis();
        System.out.println ("Application execution took " + (ts2 - ts1)  + "ms");
        System.out.println("----------------------------------------------------------------------");


    }


}
