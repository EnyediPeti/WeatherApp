package hu.peter.enyedi.weatherapp.network.model;

import java.util.ArrayList;

public class WeatherList extends ArrayList<Weather> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherList {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
