package hu.peter.enyedi.weatherapp.worker;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkerModule {

    @Provides
    public WeatherListWorker provideWeatherListWorker() {
        return new WeatherListWorker();
    }
}
