package hu.peter.enyedi.weatherapp.ui.list;

import android.os.Bundle;

import javax.inject.Inject;

import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.ui.BaseActivity;

public class WeatherListActivity extends BaseActivity implements WeatherListScreen {

    @Inject
    WeatherListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }
}
