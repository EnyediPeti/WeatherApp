package hu.peter.enyedi.weatherapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hu.axolotl.tasklib.android.TaskEngineHolder;
import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private TaskEngineHolder taskEngineHolder = new TaskEngineHolder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(WeatherApplication.injector);
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskEngineHolder.start();
    }

    @Override
    protected void onPause() {
        taskEngineHolder.stop();
        super.onPause();
    }

    protected abstract void injectDependencies(final WeatherApplicationComponent injector);

}
