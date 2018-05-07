package hu.peter.enyedi.weatherapp.repository;

import android.content.Context;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.repository.dao.WeatherDao;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmRepository implements Repository {

    @Inject
    WeatherDao weatherDao;

    private Context context;

    @Inject
    public RealmRepository(final Context context) {
        this.context = context;
        WeatherApplication.injector.inject(this);
    }

    @Override
    public WeatherDao getWeatherDao() {
        return null;
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
