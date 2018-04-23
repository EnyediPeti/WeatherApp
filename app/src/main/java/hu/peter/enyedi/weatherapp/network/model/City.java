package hu.peter.enyedi.weatherapp.network.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;


public class City extends SugarRecord<City> {

    public City() {

    }

    public City(Long id, String name, WeatherCityCoord coord, String country) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
    }

    @SerializedName("id")

    private Long id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("coord")
    private WeatherCityCoord coord = null;

    @SerializedName("country")
    private String country = null;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherCityCoord getCoord() {
        return coord;
    }

    public void setCoord(WeatherCityCoord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class City {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
