package hu.peter.enyedi.weatherapp;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import hu.axolotl.tasklib.annotation.Injector;
import hu.axolotl.tasklib.stetho.TaskLibStetho;
import hu.peter.enyedi.weatherapp.repository.Repository;
import hu.peter.enyedi.weatherapp.repository.Settings;
import io.fabric.sdk.android.Fabric;

public class WeatherApplication extends MultiDexApplication {

    @Injector
    public static WeatherApplicationComponent injector;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;
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

        initAnalytics();

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

    private void initAnalytics() {
        sAnalytics = GoogleAnalytics.getInstance(this);
        sAnalytics.setLocalDispatchPeriod(15);
        Fabric.with(this, new Crashlytics());
    }

    synchronized public Tracker getDefaultTracker() {
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
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
