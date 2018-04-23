package hu.peter.enyedi.weatherapp.ui.list.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hu.peter.enyedi.weatherapp.R;

public class WeatherDetailsActivity extends AppCompatActivity implements WeatherDetailsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
