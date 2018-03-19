package hu.peter.enyedi.weatherapp.ui.weatherobservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hu.peter.enyedi.weatherapp.R;

public class ObservationActivity extends AppCompatActivity implements ObservationScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation);
    }
}
