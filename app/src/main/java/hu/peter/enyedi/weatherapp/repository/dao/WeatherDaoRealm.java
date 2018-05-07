package hu.peter.enyedi.weatherapp.repository.dao;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.network.model.Weather;
import hu.peter.enyedi.weatherapp.repository.model.CityRealm;
import io.realm.Realm;

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
        CityRealm realmCity = new CityRealm(cityName);

        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction();
            realm.copyToRealm(realmCity);
            realm.commitTransaction();
        } catch (IllegalArgumentException e) {
            Log.d("WeatherDaoRealm", "Realm exception", e);
        } finally {
            realm.close();
        }

    }

    @Override
    public List<CityRealm> getCityList() {
        Realm realm = Realm.getDefaultInstance();

        List<CityRealm> realmCity = realm.copyFromRealm(realm.where(CityRealm.class).findAll());
        realm.close();

        return realmCity;

    }

    @Override
    public void deleteCity(String cityName) {
        //TODO: search in list and delete
    }
}
