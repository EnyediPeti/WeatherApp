package hu.peter.enyedi.weatherapp.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.peter.enyedi.weatherapp.R;

public class WeatherListActivity extends AppCompatActivity implements WeatherListScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
    }
}
