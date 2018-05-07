package hu.peter.enyedi.weatherapp.repository.dao;

import java.util.List;

import hu.peter.enyedi.weatherapp.network.model.Weather;

public interface WeatherDao {
    List<Weather> getWeatherList();

    void saveForecast(Weather weather);

    void updateForecast(Weather newWeather);

    void saveCity(String cityName);

    List<String> getCityList();

    void deleteCity(String cityName);
}
