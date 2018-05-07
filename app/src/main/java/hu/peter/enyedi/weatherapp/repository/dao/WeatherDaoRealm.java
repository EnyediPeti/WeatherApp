package hu.peter.enyedi.weatherapp.repository.dao;

import java.util.List;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.network.model.Weather;

public class WeatherDaoRealm implements WeatherDao {

    @Inject
    public WeatherDaoRealm() {
    }

    @Override
    public List<Weather> getWeatherList() {
        return null;
    }

    @Override
    public void saveForecast(Weather weather) {
        //TODO: get first in list and update the values
    }

    @Override
    public void updateForecast(Weather newWeather) {

    }

    @Override
    public void saveCity(String cityName) {
        //TODO: save into list
    }

    @Override
    public List<String> getCityList() {
        return null;
    }

    @Override
    public void deleteCity(String cityName) {
        //TODO: search in list and delete
    }
}
