package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecast /*extends RealmObject*/ {

    @SerializedName("dt")
    private Long dt = null;

    @SerializedName("main")
    private WeatherForecastListMain main = null;

    @SerializedName("weather")
    private List<WeatherData> weather = new ArrayList<WeatherData>();

    @SerializedName("clouds")
    private WeatherForecastListClouds clouds = null;

    @SerializedName("wind")
    private WeatherForecastListWind wind = null;

    @SerializedName("sys")
    private WeatherForecastListSys sys = null;

    @SerializedName("dt_txt")
    private String dtTxt = null;

    public WeatherForecast() {
    }

    public WeatherForecast(Long dt, WeatherForecastListMain main, List<WeatherData> weather, WeatherForecastListClouds clouds, WeatherForecastListWind wind, WeatherForecastListSys sys, String dtTxt) {

        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public WeatherForecastListMain getMain() {
        return main;
    }

    public void setMain(WeatherForecastListMain main) {
        this.main = main;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public WeatherForecastListClouds getClouds() {
        return clouds;
    }

    public void setClouds(WeatherForecastListClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherForecastListWind getWind() {
        return wind;
    }

    public void setWind(WeatherForecastListWind wind) {
        this.wind = wind;
    }

    public WeatherForecastListSys getSys() {
        return sys;
    }

    public void setSys(WeatherForecastListSys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherForecast {\n");

        sb.append("    dt: ").append(toIndentedString(dt)).append("\n");
        sb.append("    main: ").append(toIndentedString(main)).append("\n");
        sb.append("    weather: ").append(toIndentedString(weather)).append("\n");
        sb.append("    clouds: ").append(toIndentedString(clouds)).append("\n");
        sb.append("    wind: ").append(toIndentedString(wind)).append("\n");
        sb.append("    sys: ").append(toIndentedString(sys)).append("\n");
        sb.append("    dtTxt: ").append(toIndentedString(dtTxt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
