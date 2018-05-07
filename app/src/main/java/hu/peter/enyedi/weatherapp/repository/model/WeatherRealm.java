package hu.peter.enyedi.weatherapp.repository.model;

import hu.peter.enyedi.weatherapp.network.model.Weather;
import io.realm.RealmObject;

public class WeatherRealm extends RealmObject {

    private String code;
    private Double message;
    //private City city;
    private Integer cnt;
    //private RealmList<WeatherForecast> list;
    //private List<WeatherForecast> list;

    public WeatherRealm() {
    }

    public WeatherRealm(final Weather weather) {
        code = weather.getCode();
        message = weather.getMessage();
        //city = weather.getCity();
        cnt = weather.getCnt();
        //list.addAll(weather.getList());
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

    /*public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }*/

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /*public List<WeatherForecast> getList() {
        return list;
    }

    public void setList(List<WeatherForecast> list) {
        this.list.addAll(list);
    }*/
}
