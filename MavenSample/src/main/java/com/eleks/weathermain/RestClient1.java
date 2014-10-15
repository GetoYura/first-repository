package com.eleks.weathermain;

import com.eleks.createfile.CreatorWeatherFile;
import com.eleks.inform.NewInfWeather;
import com.eleks.parser.ParserJson;
import com.eleks.parser.ParserXml;
import com.eleks.parser.Parserable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RestClient1 {

    public static void main(String[] args) {

        List<NewInfWeather> weatherList = null;
        CreatorWeatherFile creatorWeatherFile = new CreatorWeatherFile();

        String fetchResult = "";
        String formatType = "";
        Parserable weatherParser = null;

        System.out.println(args[0]);
        try {
            if (args[0].equalsIgnoreCase("XML")) {

                formatType = "xml";
                fetchResult = creatorWeatherFile.createWeatherString(formatType);

            } else if (args[0].equalsIgnoreCase("JSON")) {

                formatType = "json";
                fetchResult = creatorWeatherFile.createWeatherString(formatType);

            } else if (args[0].equalsIgnoreCase("LOCAL")) {
                System.out.println("we in local");
                String sCurrentLine;
                BufferedReader br = null;
                try {

                    br = new BufferedReader(new FileReader((args[1])));

                    while ((sCurrentLine = br.readLine()) != null) {

                        fetchResult = fetchResult + sCurrentLine;

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (br != null) br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            } else {

                throw new IllegalArgumentException("Invalid format: only xml or json accepted");

            }


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
        System.out.println("----------------------------------------------------------------------");


    }


}
