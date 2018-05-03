package hu.peter.enyedi.weatherapp.worker;

import javax.inject.Inject;

import hu.axolotl.tasklib.annotation.CreateTask;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.network.api.ForecastApi;
import hu.peter.enyedi.weatherapp.network.model.Weather;

public class WeatherListWorker extends BaseWorker {

    @Inject
    ForecastApi forecastApi;


    @CreateTask
    public Weather getForecastList(String cityName) {
        //callWithBasicResponseCheckAnd200(forecastApi.getForecast());
        return null;
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }
}
