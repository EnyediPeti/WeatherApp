package hu.peter.enyedi.weatherapp.repository;

import hu.peter.enyedi.weatherapp.repository.dao.WeatherDao;

public interface Repository {

    WeatherDao getWeatherDao();

    void initRepository();
}
