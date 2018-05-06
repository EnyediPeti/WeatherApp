package hu.peter.enyedi.weatherapp.ui.list;

import javax.inject.Inject;

import hu.axolotl.tasklib.InlineTaskListener;
import hu.axolotl.tasklib.base.BaseTask;
import hu.peter.enyedi.weatherapp.network.model.Weather;
import hu.peter.enyedi.weatherapp.ui.TaskPresenter;
import hu.peter.enyedi.weatherapp.worker.task.weatherlist.GetForecastListTask;

public class WeatherListPresenter extends TaskPresenter<WeatherListScreen> {

    @Inject
    public WeatherListPresenter() {
    }

    public void getForecastList(String cityName) {
        executeTask(new GetForecastListTask(cityName), new InlineTaskListener<Weather, Void>() {
            @Override
            public void onTaskResult(BaseTask<Weather, Void> task) {
                if (!task.hasError()) {
                    if (screen != null) {
                        screen.showForecast(task.getResult());
                    }
                }
            }
        });
    }
}
