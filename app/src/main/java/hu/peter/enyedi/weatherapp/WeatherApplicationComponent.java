package hu.peter.enyedi.weatherapp;

import javax.inject.Singleton;

import dagger.Component;
import hu.peter.enyedi.weatherapp.ui.UIModule;

@Singleton
@Component(modules = {UIModule.class})
public interface WeatherApplicationComponent {
}
