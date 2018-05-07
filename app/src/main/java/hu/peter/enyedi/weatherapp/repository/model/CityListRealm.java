package hu.peter.enyedi.weatherapp.repository.model;

import io.realm.RealmList;

public class CityListRealm {

    private RealmList<CityRealm> cityRealms;

    public RealmList<CityRealm> getCityRealms() {
        return cityRealms;
    }

    public void setCityRealms(RealmList<CityRealm> cityRealms) {
        this.cityRealms = cityRealms;
    }
}
