package hu.peter.enyedi.weatherapp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import hu.peter.enyedi.weatherapp.network.NetworkModule;
import hu.peter.enyedi.weatherapp.repository.RealmRepository;
import hu.peter.enyedi.weatherapp.repository.RepositoryModule;
import hu.peter.enyedi.weatherapp.ui.UIModule;
import hu.peter.enyedi.weatherapp.ui.list.WeatherListActivity;
import hu.peter.enyedi.weatherapp.ui.list.details.WeatherDetailsActivity;
import hu.peter.enyedi.weatherapp.ui.newcity.NewCityActivity;
import hu.peter.enyedi.weatherapp.worker.WeatherListWorker;
import hu.peter.enyedi.weatherapp.worker.WorkerModule;
import hu.peter.enyedi.weatherapp.worker.task.WeatherListWorkerTaskHelper;

@Singleton
@Component(modules = {UIModule.class, WorkerModule.class, NetworkModule.class, RepositoryModule.class})
public interface WeatherApplicationComponent {


    void inject(WeatherApplication weatherApplication);

    void inject(WeatherListActivity weatherListActivity);

    void inject(WeatherListWorkerTaskHelper weatherListWorkerTaskHelper);

    void inject(WeatherListWorker weatherListWorker);

    void inject(RealmRepository realmRepository);

    void inject(WeatherDetailsActivity weatherDetailsActivity);

    void inject(NewCityActivity newCityActivity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(final Application application);

        @BindsInstance
        Builder serviceEndpointAddress(@NetworkModule.ServiceEndpointAddress final String serviceEndpointAddress);

        WeatherApplicationComponent build();
    }
}
