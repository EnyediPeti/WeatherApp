package hu.peter.enyedi.weatherapp.repository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Binds
    abstract Repository provideRepository(final SugarRepository sugarRepository);
}
