package com.eleks.parser;

import com.eleks.inform.NewInfWeather;

import java.util.List;

public interface Parserable {
    List<NewInfWeather> parseString(String fetchResult);
}
