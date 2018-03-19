package hu.peter.enyedi.weatherapp.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.peter.enyedi.weatherapp.ui.list.WeatherListPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public WeatherListPresenter provideWeatherListPresenter() {
        return new WeatherListPresenter();
    }

}
