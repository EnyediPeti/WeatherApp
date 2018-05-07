package hu.peter.enyedi.weatherapp.ui.newcity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import hu.peter.enyedi.weatherapp.repository.Settings;
import hu.peter.enyedi.weatherapp.ui.BaseActivity;

public class NewCityActivity extends BaseActivity implements NewCityScreen {

    @BindView(R.id.cityListView)
    ListView listView;

    @Inject
    Settings settings;

    ArrayList<String> listItems = new ArrayList<>();

    ArrayAdapter<String> adapter;
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_city);

        ButterKnife.bind(this);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

        WeatherApplication application = (WeatherApplication) getApplication();
        tracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tracker.setScreenName("City list");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @OnClick(R.id.addCityButton)
    public void onAddNewCity() {
        NewCityDialog dialog = NewCityDialog.newInstance();
        dialog.show(getSupportFragmentManager(), NewCityDialog.TAG);
    }

    @Override
    protected void injectDependencies(WeatherApplicationComponent injector) {
        injector.inject(this);
    }

    public void onSaveCommand(String cityName) {
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("New city added")
                .build());
        settings.saveCurrentCity(cityName);
        adapter.add(cityName);
        adapter.notifyDataSetChanged();
    }
}
