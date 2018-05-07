package hu.peter.enyedi.weatherapp.ui.list;

import hu.peter.enyedi.weatherapp.network.model.Weather;

public interface WeatherListScreen {
    void showForecast(Weather weather);
}
