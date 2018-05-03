package hu.peter.enyedi.weatherapp.ui.list;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.ui.TaskPresenter;
import hu.peter.enyedi.weatherapp.worker.task.weatherlist.GetForecastListTask;

public class WeatherListPresenter extends TaskPresenter<WeatherListScreen> {

    @Inject
    public WeatherListPresenter() {
    }

    public void getForecastList(String cityName) {
        executeTask(new GetForecastListTask(cityName));
    }
}
