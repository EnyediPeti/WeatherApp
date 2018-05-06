package hu.peter.enyedi.weatherapp.repository;

import android.content.Context;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.network.model.Weather;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmRepository implements Repository {

    private Context context;

    @Inject
    public RealmRepository(final Context context) {
        this.context = context;
        WeatherApplication.injector.inject(this);
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

    @Override
    public void initRepository() {
        Realm.init(context);
        Realm.setDefaultConfiguration(getDefaultConfiguration());
    }

    private RealmConfiguration getDefaultConfiguration() {
        return new RealmConfiguration.Builder()
                .name("weatherapp.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
    }
}
