package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;

public class WeatherCityCoord {

    @SerializedName("lon")
    private Double lon = null;

    @SerializedName("lat")
    private Double lat = null;

    public WeatherCityCoord() {
    }

    public WeatherCityCoord(Double lon, Double lat) {

        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherCityCoord {\n");

        sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
        sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
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
