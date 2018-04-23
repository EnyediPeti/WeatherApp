package hu.peter.enyedi.weatherapp.ui.list;

import hu.peter.enyedi.weatherapp.TaskPresenter;

public class WeatherListPresenter extends TaskPresenter<WeatherListScreen> {

    public void getForecastList() {
        executeTask(new GetForecastListTask());
    }
}
