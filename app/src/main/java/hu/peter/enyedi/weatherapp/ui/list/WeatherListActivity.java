package hu.peter.enyedi.weatherapp.ui.list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.ui.BaseActivity;

public class WeatherListActivity extends BaseActivity implements WeatherListScreen, WeatherClickListener {

    @BindView(R.id.weatherList)
    RecyclerView recyclerView;

    @Inject
    WeatherListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        ButterKnife.bind(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {

    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }

    @Override
    public void onWeatherItemClicked() {

    }
}
