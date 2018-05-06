package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    @SerializedName("cod")
    private String code = null;
    @SerializedName("message")
    private Double message = null;
    @SerializedName("city")
    private WeatherCity city = null;
    @SerializedName("cnt")
    private Integer cnt = null;
    @SerializedName("list")
    private List<WeatherForecastList> list = new ArrayList<WeatherForecastList>();

    public Weather() {

    }

    public Weather(String code, Double message, WeatherCity city, Integer cnt, List<WeatherForecastList> list) {
        this.code = code;
        this.message = message;
        this.city = city;
        this.cnt = cnt;
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public WeatherCity getCity() {
        return city;
    }

    public void setCity(WeatherCity city) {
        this.city = city;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<WeatherForecastList> getList() {
        return list;
    }

    public void setList(List<WeatherForecastList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Weather {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    cnt: ").append(toIndentedString(cnt)).append("\n");
        sb.append("    list: ").append(toIndentedString(list)).append("\n");
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
