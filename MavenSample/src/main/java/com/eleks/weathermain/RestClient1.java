package com.eleks.weathermain;

import com.eleks.createfile.CreatorWeatherFile;
import com.eleks.inform.NewInfWeather;
import com.eleks.parser.ParserJson;
import com.eleks.parser.ParserXml;
import com.eleks.parser.Parserable;


import java.util.List;

public class RestClient1 {

    public static void main(String[] args) {

        List<NewInfWeather> weatherList = null;
        CreatorWeatherFile creatorWeatherFile = new CreatorWeatherFile();

        String formatType = null;
        Parserable weatherParser = null;

        try {
            if (args[0].equalsIgnoreCase("XML")) {

                formatType = "xml";
                weatherParser = new ParserXml();

            } else if (args[0].equalsIgnoreCase("JSON")) {

                formatType = "json";
                weatherParser = new ParserJson();

            } else {

                throw new IllegalArgumentException("Invalid format: only xml or json accepted");

            }

            String fetchResult = creatorWeatherFile.createWeatherString(formatType);
            weatherList = weatherParser.parseString(fetchResult);

        } catch (Exception exception) {
            System.out.println(exception + " Input something");
            System.exit(0);
        }

        System.out.println("----------------------------------------------------------------------");
        for (NewInfWeather a : weatherList) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------------------------------------");


    }


}
