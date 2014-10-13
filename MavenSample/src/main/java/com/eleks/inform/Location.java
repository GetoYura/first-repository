package com.eleks.inform;

/**
 * Created by Iurii.Geto on 08.10.2014.
 */
public class Location {
    private String city;
    private String region;
    private String country;

    @Override
    public String toString() {
        return "com.eleks.inform.Location{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
