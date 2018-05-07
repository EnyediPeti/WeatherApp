package hu.peter.enyedi.weatherapp.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.peter.enyedi.weatherapp.R;
import hu.peter.enyedi.weatherapp.network.model.WeatherForecast;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private List<WeatherForecast> weatherList;
    private WeatherClickListener listener;
    private Context context;

    public WeatherListAdapter(Context context, WeatherClickListener listener) {
        this.context = context;
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
        holder.bind(weatherList.get(position));
    }

    public void setWeatherList(List<WeatherForecast> weatherList) {
        this.weatherList.clear();
        this.weatherList.addAll(weatherList);
        notifyDataSetChanged();
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

        private WeatherForecast weatherForecast;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        void bind(WeatherForecast weather) {
            weatherForecast = weather;
            date.setText(weather.getDtTxt());
            temperature.setText(String.format(Locale.getDefault(), "%.1f \u00B0C", weather.getMain().getTemp()));
            Glide.with(context).load("http://openweathermap.org/img/w/" + weather.getWeather().get(0).getIcon() + ".png").into(icon);
        }

        @OnClick(R.id.weatherItemContainer)
        public void onItemClicked() {
            listener.onWeatherItemClicked(weatherForecast);
        }
    }
}
