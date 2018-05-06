package hu.peter.enyedi.weatherapp.repository;

import hu.peter.enyedi.weatherapp.network.model.Weather;

public interface Repository {

    void saveForecast(Weather weather);

    void updateForecast(Weather newWeather);

    void saveCity(String cityName);

    void deleteCity(String cityName);

    void initRepository();
}
