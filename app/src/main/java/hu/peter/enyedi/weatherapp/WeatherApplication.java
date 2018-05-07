package hu.peter.enyedi.weatherapp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import hu.axolotl.tasklib.annotation.Injector;
import hu.axolotl.tasklib.stetho.TaskLibStetho;
import hu.peter.enyedi.weatherapp.repository.Repository;
import hu.peter.enyedi.weatherapp.repository.Settings;

public class WeatherApplication extends Application {

    @Injector
    public static WeatherApplicationComponent injector;

    @Inject
    Repository repository;

    @Inject
    Settings settings;

    @Override
    public void onCreate() {
        super.onCreate();

        setupInjector();
        injectDependencies(injector);

        initApplicationDependentComponents();
        repository.initRepository();
        settings.initSettings();
    }

    protected void initApplicationDependentComponents() {
        if (BuildConfig.DEBUG) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());

            TaskLibStetho.init();
        }
    }

    protected void setupInjector() {
        injector = DaggerWeatherApplicationComponent.builder()
                .application(this)
                .serviceEndpointAddress(getServiceEndpointAddress())
                .build();
    }

    protected void injectDependencies(final WeatherApplicationComponent appComponent) {
        appComponent.inject(this);
    }

    protected String getServiceEndpointAddress() {
        Context context = getApplicationContext();
        return context.getString(R.string.config_service_endpoint_address) + context.getString(R.string.config_service_endpoint_version);
    }

}
