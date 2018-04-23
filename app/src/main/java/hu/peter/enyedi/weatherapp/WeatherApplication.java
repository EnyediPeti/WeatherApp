package hu.peter.enyedi.weatherapp;

import com.orm.SugarApp;

import hu.peter.enyedi.weatherapp.ui.UIModule;

public class WeatherApplication extends SugarApp {

    public static WeatherApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerWeatherApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
