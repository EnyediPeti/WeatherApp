package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;

public class WeatherForecastListWind /*extends RealmObject*/ {

    @SerializedName("deg")
    private Float deg = null;

    @SerializedName("speed")
    private Float speed = null;

    public WeatherForecastListWind() {
    }

    public WeatherForecastListWind(Float deg, Float speed) {

        this.deg = deg;
        this.speed = speed;
    }

    public Float getDeg() {
        return deg;
    }

    public void setDeg(Float deg) {
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherForecastListWind {\n");

        sb.append("    deg: ").append(toIndentedString(deg)).append("\n");
        sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
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
