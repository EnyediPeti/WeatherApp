package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class WeatherForecastListClouds extends SugarRecord<WeatherForecastListClouds> {

    @SerializedName("all")
    private Integer all = null;

    public WeatherForecastListClouds() {
    }

    public WeatherForecastListClouds(Integer all) {

        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherForecastListClouds {\n");

        sb.append("    all: ").append(toIndentedString(all)).append("\n");
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
