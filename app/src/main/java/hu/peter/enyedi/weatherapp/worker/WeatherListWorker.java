package hu.peter.enyedi.weatherapp.worker;

import android.content.Context;

import javax.inject.Inject;

import hu.axolotl.tasklib.annotation.CreateTask;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.network.api.ForecastApi;
import hu.peter.enyedi.weatherapp.network.model.Weather;

public class WeatherListWorker extends BaseWorker {

    @Inject
    Context context;

    @Inject
    ForecastApi forecastApi;


    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }

    @CreateTask
    public Weather getForecastList(String cityName) {
        return callWithBasicResponseCheckAnd200(forecastApi.getForecast(cityName, context.getResources().getString(R.string.unit_metric), context.getResources().getString(R.string.api_key)));
    }
}
