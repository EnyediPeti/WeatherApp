package hu.peter.enyedi.weatherapp.repository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import hu.peter.enyedi.weatherapp.repository.dao.WeatherDao;
import hu.peter.enyedi.weatherapp.repository.dao.WeatherDaoRealm;

@Module
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract Repository provideRepository(final RealmRepository realmRepository);

    @Binds
    @Singleton
    abstract Settings provideSettings(final SharedPrefSettings sharedPrefSettings);

    @Binds
    abstract WeatherDao provideTrackPointDao(final WeatherDaoRealm weatherDaoRealm);
}
