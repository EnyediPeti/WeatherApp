package hu.peter.enyedi.weatherapp.repository;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.network.model.Weather;

public class SugarRepository implements Repository {

    @Inject
    public SugarRepository() {
    }

    @Override
    public void saveForecast(Weather weather) {

    }

    @Override
    public void updateForecast(Weather newWeather) {

    }

    @Override
    public void saveCity(String cityName) {

    }

    @Override
    public void deleteCity(String cityName) {

    }
}
