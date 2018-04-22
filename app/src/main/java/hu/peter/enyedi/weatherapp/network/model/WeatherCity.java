package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;

public class WeatherCity {

    @SerializedName("country")
    private String country = null;

    @SerializedName("coord")
    private WeatherCityCoord coord = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("id")
    private Long id = null;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public WeatherCityCoord getCoord() {
        return coord;
    }

    public void setCoord(WeatherCityCoord coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeatherCity {\n");

        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
