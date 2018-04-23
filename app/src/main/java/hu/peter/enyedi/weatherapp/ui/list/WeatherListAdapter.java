package hu.peter.enyedi.weatherapp.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.network.model.Weather;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private List<Weather> weatherList;
    private WeatherClickListener listener;

    public WeatherListAdapter(WeatherClickListener listener) {
        weatherList = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather weather = weatherList.get(position);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weatherIcon)
        ImageView icon;

        @BindView(R.id.weatherDate)
        TextView date;

        @BindView(R.id.weatherTemperature)
        TextView temperature;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.weatherItemContainer)
        public void onItemClicked() {
            listener.onWeatherItemClicked();
        }
    }
}
