package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class WeatherForecastListMain extends SugarRecord<WeatherForecastListMain> {

    @SerializedName("temp")
    private Float temp = null;

    @SerializedName("temp_min")
    private Float tempMin = null;

    @SerializedName("grnd_level")
    private Float grndLevel = null;

    @SerializedName("temp_kf")
    private Float tempKf = null;

    @SerializedName("humidity")
    private Float humidity = null;

    @SerializedName("pressure")
    private Float pressure = null;

    @SerializedName("sea_level")
    private Float seaLevel = null;

    @SerializedName("temp_max")
    private Float tempMax = null;

    public WeatherForecastListMain() {
    }

    public WeatherForecastListMain(Float temp, Float tempMin, Float grndLevel, Float tempKf, Float humidity, Float pressure, Float seaLevel, Float tempMax) {

        this.temp = temp;
        this.tempMin = tempMin;
        this.grndLevel = grndLevel;
        this.tempKf = tempKf;
        this.humidity = humidity;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.tempMax = tempMax;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Float getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Float grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Float getTempKf() {
        return tempKf;
    }

    public void setTempKf(Float tempKf) {
        this.tempKf = tempKf;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherForecastListMain {\n");

        sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
        sb.append("    tempMin: ").append(toIndentedString(tempMin)).append("\n");
        sb.append("    grndLevel: ").append(toIndentedString(grndLevel)).append("\n");
        sb.append("    tempKf: ").append(toIndentedString(tempKf)).append("\n");
        sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
        sb.append("    pressure: ").append(toIndentedString(pressure)).append("\n");
        sb.append("    seaLevel: ").append(toIndentedString(seaLevel)).append("\n");
        sb.append("    tempMax: ").append(toIndentedString(tempMax)).append("\n");
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
