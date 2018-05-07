package hu.peter.enyedi.weatherapp.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.network.model.Weather;
import hu.peter.enyedi.weatherapp.network.model.WeatherForecast;
import hu.peter.enyedi.weatherapp.repository.Settings;
import hu.peter.enyedi.weatherapp.ui.BaseActivity;
import hu.peter.enyedi.weatherapp.ui.list.details.WeatherDetailsActivity;
import hu.peter.enyedi.weatherapp.ui.newcity.NewCityActivity;
import hu.peter.enyedi.weatherapp.ui.weatherobservation.ObservationActivity;

public class WeatherListActivity extends BaseActivity implements WeatherListScreen, WeatherClickListener {

    public static final String WEATHER_FORECAST = "extra.weather.forecast";

    @BindView(R.id.weatherList)
    RecyclerView recyclerView;

    @Inject
    Settings settings;

    @Inject
    Gson gson;

    @Inject
    WeatherListPresenter presenter;

    WeatherListAdapter adapter;
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        ButterKnife.bind(this);

        setupRecyclerView();

        WeatherApplication application = (WeatherApplication) getApplication();
        tracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachScreen(this);
        getSupportActionBar().setTitle(settings.getCurrentCity());

        Answers.getInstance().logCustom(new CustomEvent("City")
                .putCustomAttribute("Current city", settings.getCurrentCity())
        );

        presenter.getForecastList(settings.getCurrentCity());
        tracker.setScreenName("Weather list");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onPause() {
        presenter.detachScreen();
        super.onPause();
    }

    private void setupRecyclerView() {
        adapter = new WeatherListAdapter(this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_city_selection:
                startActivity(new Intent(this, NewCityActivity.class));
                return true;

            case R.id.action_new_observation:
                startActivity(new Intent(this, ObservationActivity.class));

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onWeatherItemClicked(WeatherForecast weatherForecast) {
        Intent intent = new Intent(this, WeatherDetailsActivity.class);
        intent.putExtra(WEATHER_FORECAST, gson.toJson(weatherForecast));
        startActivity(intent);
    }

    @Override
    public void showForecast(Weather weather) {
        adapter.setWeatherList(weather.getList());
        Answers.getInstance().logCustom(new CustomEvent("Get forecast list")
                .putCustomAttribute("Weathet list size", weather.getList().size())
        );


    }
}
