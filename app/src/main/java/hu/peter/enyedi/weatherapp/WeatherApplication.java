package hu.peter.enyedi.weatherapp;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.orm.SugarApp;

import javax.inject.Inject;

import hu.axolotl.tasklib.annotation.Injector;
import hu.axolotl.tasklib.stetho.TaskLibStetho;
import hu.peter.enyedi.weatherapp.repository.Repository;

public class WeatherApplication extends SugarApp {

    @Injector
    public static WeatherApplicationComponent injector;

    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        setupInjector();
        injectDependencies(injector);

        initApplicationDependentComponents();
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
