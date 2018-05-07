package hu.peter.enyedi.weatherapp.ui.list.details;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.network.model.WeatherForecast;
import hu.peter.enyedi.weatherapp.ui.BaseActivity;

import static hu.peter.enyedi.weatherapp.ui.list.WeatherListActivity.WEATHER_FORECAST;

public class WeatherDetailsActivity extends BaseActivity implements WeatherDetailsScreen {

    @BindView(R.id.detailsDescription)
    TextView detailsDescription;

    @BindView(R.id.detailsTemp)
    TextView detailsTemp;

    @BindView(R.id.detailsTempMin)
    TextView detailsTempMin;

    @BindView(R.id.detailsTempMax)
    TextView detailsTempMax;

    @BindView(R.id.detailsPressure)
    TextView detailsPressure;

    @BindView(R.id.detailsHumidity)
    TextView detailsHumidity;

    @BindView(R.id.detailsClouds)
    TextView detailsClouds;

    @BindView(R.id.detailsWind)
    TextView detailsWind;

    @Inject
    Gson gson;

    private WeatherForecast weatherForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        ButterKnife.bind(this);

        weatherForecast = gson.fromJson(getIntent().getStringExtra(WEATHER_FORECAST), WeatherForecast.class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(weatherForecast.getDtTxt());

        setupDetails();
    }

    private void setupDetails() {
        detailsDescription.setText(weatherForecast.getWeather().get(0).getDescription());
        detailsTemp.setText(String.format(Locale.getDefault(), "%.1f \u00B0C", weatherForecast.getMain().getTemp()));
        detailsTempMin.setText(String.format(Locale.getDefault(), "%.1f \u00B0C", weatherForecast.getMain().getTempMin()));
        detailsTempMax.setText(String.format(Locale.getDefault(), "%.1f \u00B0C", weatherForecast.getMain().getTempMax()));
        detailsPressure.setText(String.format(Locale.getDefault(), "%.1f Pa", weatherForecast.getMain().getPressure()));
        detailsHumidity.setText(String.format(Locale.getDefault(), "%.1f%%", weatherForecast.getMain().getHumidity()));
        detailsClouds.setText(String.format(Locale.getDefault(), "%d%%", weatherForecast.getClouds().getAll()));
        detailsWind.setText(String.format(Locale.getDefault(), "Speed: %.1fkm/h\nDirection: %.1f\u00B0", weatherForecast.getWind().getSpeed(), weatherForecast.getWind().getDeg()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }
}
