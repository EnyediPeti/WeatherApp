package hu.peter.enyedi.weatherapp;

import android.app.Application;

import hu.peter.enyedi.weatherapp.ui.UIModule;

public class WeatherApplication extends Application {

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
