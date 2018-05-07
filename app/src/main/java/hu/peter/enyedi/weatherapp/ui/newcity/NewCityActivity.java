package hu.peter.enyedi.weatherapp.ui.newcity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.peter.enyedi.weatherapp.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_city);

        ButterKnife.bind(this);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);
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
        settings.saveCurrentCity(cityName);
        adapter.add(cityName);
        adapter.notifyDataSetChanged();
    }
}
