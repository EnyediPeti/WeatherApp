package hu.peter.enyedi.weatherapp.ui.newcity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hu.peter.enyedi.weatherapp.R;

public class NewCityActivity extends AppCompatActivity implements NewCityScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_city);
    }
}
