package com.eleks.weathermain;

import com.eleks.createfile.CreatorWeatherFile;
import com.eleks.inform.NewInfWeather;
import com.eleks.inform.Weatherable;
import com.eleks.json.WeatherJson;
import com.eleks.xml.WeatherXml;

import java.util.List;

public class RestClient1 {

    public static void main(String[] args) {

        Long ts1 = System.currentTimeMillis()

        List<NewInfWeather> weatherList = null;
        Weatherable weather;
        CreatorWeatherFile creatorWeatherFile = new CreatorWeatherFile();

        try {
            if (args[0].equalsIgnoreCase("XML")) {

                weather = new WeatherXml(creatorWeatherFile);
                weatherList = weather.getWeather("xml");

            } else if (args[0].equalsIgnoreCase("JSON")) {

                weather = new WeatherJson(creatorWeatherFile);
                weatherList = weather.getWeather("json");

            } else {

                System.out.println(" Input xml or json");
                System.exit(0);

            }
        } catch (Exception exception) {
            System.out.println(exception + " Input something");
            System.exit(0);
        }

        System.out.println("----------------------------------------------------------------------");
        for (NewInfWeather a : weatherList) {
            System.out.println(a);
        }
        Long ts2 = System.currentTimeMillis()
        System.out.println ("Application execution took " + (ts2 - ts1)  + "ms");
        System.out.println("----------------------------------------------------------------------");


    }


}
