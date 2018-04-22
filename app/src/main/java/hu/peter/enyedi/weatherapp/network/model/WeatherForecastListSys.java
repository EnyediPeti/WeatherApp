package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class WeatherForecastListSys extends SugarRecord<WeatherForecastListSys> {

    @SerializedName("pod")
    private String pod = null;

    public WeatherForecastListSys() {
    }

    public WeatherForecastListSys(String pod) {

        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherForecastListSys {\n");

        sb.append("    pod: ").append(toIndentedString(pod)).append("\n");
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
