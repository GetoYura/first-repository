package com.eleks.inform;

import java.util.ArrayList;

/**
 * Created by Iurii.Geto on 08.10.2014.
 */
public class WeatherInformation {
    private String chanelltitle;
    private String itemtitle;
    private Location location;
    private Double longitube;
    private Double latitube;
    private Integer tempeature;
    private String channeldate;
    private ArrayList<String> temperatures = new ArrayList<String>();
    private ArrayList<NewInfWeather> weatherinf = new ArrayList<NewInfWeather>();

    @Override
    public String toString() {
        return "com.eleks.inform.WeatherInformation{" +
                "chanelltitle='" + chanelltitle + '\'' +
                ", itemtitle='" + itemtitle + '\'' +
                ", location=" + location +
                ", longitube=" + longitube +
                ", latitube=" + latitube +
                ", temperatures=" + temperatures +
                '}';
    }

    public ArrayList<String> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<String> temperatures) {
        this.temperatures = temperatures;
    }


    public String getChanneldate() {
        return channeldate;
    }

    public void setChanneldate(String channeldate) {
        this.channeldate = channeldate;
    }


    public String getChanelltitle() {
        return chanelltitle;
    }

    public String getItemtitle() {
        return itemtitle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getLatitube() {
        return latitube;
    }

    public Double getLongitube() {
        return longitube;
    }

    public int getTempeature() {
        return tempeature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public void setTempeature(int tempeature) {
        this.tempeature = tempeature;
    }

    public void setLongitube(Double longitube) {
        this.longitube = longitube;
    }

    public void setLatitube(Double latitube) {
        this.latitube = latitube;
    }


    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }

    public void setChanelltitle(String chanelltitle) {
        this.chanelltitle = chanelltitle;
    }

    String date;
}
