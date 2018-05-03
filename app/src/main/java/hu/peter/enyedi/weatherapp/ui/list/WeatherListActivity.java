package hu.peter.enyedi.weatherapp.ui.list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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

    WeatherListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        ButterKnife.bind(this);

        setupRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getForecastList("Budapest");
    }

    private void setupRecyclerView() {
        adapter = new WeatherListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }

    @Override
    public void onWeatherItemClicked() {

    }
}
