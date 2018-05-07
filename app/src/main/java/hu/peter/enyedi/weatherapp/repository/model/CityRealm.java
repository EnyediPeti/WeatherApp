package hu.peter.enyedi.weatherapp.repository.model;

import io.realm.RealmObject;

public class CityRealm extends RealmObject {

    private String name;

    public CityRealm() {
    }

    public CityRealm(String cityName) {
        this.name = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
