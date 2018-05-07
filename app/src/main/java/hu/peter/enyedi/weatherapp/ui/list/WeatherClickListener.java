package hu.peter.enyedi.weatherapp.ui.list;

import hu.peter.enyedi.weatherapp.network.model.WeatherForecast;

public interface WeatherClickListener {
    void onWeatherItemClicked(WeatherForecast weatherForecast);
}
