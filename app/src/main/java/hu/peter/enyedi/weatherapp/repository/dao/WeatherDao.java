package hu.peter.enyedi.weatherapp.repository.dao;

import java.util.List;

import hu.peter.enyedi.weatherapp.network.model.Weather;
import hu.peter.enyedi.weatherapp.repository.model.CityRealm;

public interface WeatherDao {
    List<Weather> getWeatherList();

    void saveForecast(Weather weather);

    void updateForecast(Weather newWeather);

    void saveCity(String cityName);

    List<CityRealm> getCityList();

    void deleteCity(String cityName);
}
