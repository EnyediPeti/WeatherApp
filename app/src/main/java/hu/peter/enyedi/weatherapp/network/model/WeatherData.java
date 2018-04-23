package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class WeatherData extends SugarRecord<WeatherData> {

    @SerializedName("id")
    private Integer id = null;

    @SerializedName("main")
    private String main = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("icon")
    private String icon = null;

    public WeatherData() {
    }

    public WeatherData(Integer id, String main, String description, String icon) {

        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Integer getWeatherDataId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherData {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    main: ").append(toIndentedString(main)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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
