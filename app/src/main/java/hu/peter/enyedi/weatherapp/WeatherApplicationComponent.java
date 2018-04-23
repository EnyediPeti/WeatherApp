package hu.peter.enyedi.weatherapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.peter.enyedi.weatherapp.ui.UIModule;
import hu.peter.enyedi.weatherapp.ui.list.WeatherListActivity;
import hu.peter.enyedi.weatherapp.worker.WeatherListWorker;
import hu.peter.enyedi.weatherapp.worker.WorkerModule;

@Singleton
@Component(modules = {UIModule.class, WorkerModule.class})
public interface WeatherApplicationComponent {

    void inject(WeatherListActivity weatherListActivity);

    void inject(WeatherListWorker weatherListWorker);
}
