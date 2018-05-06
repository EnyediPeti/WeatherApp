package hu.peter.enyedi.weatherapp.repository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract Repository provideRepository(final RealmRepository realmRepository);
}
