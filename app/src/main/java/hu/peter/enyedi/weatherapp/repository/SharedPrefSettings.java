package hu.peter.enyedi.weatherapp.repository;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPrefSettings implements Settings {

    private static final String SP_NAME = "hu.peter.enyedi.weatherapp";
    private static final String SP_CITY = "sp.city";

    private Context context;

    private SharedPreferences sp;

    @Inject
    public SharedPrefSettings(Context context) {
        this.context = context;
    }

    @Override
    public void initSettings() {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void saveCurrentCity(String cityName) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP_CITY, cityName);
        editor.apply();
    }

    @Override
    public String getCurrentCity() {
        return sp.getString(SP_CITY, "Budapest");
    }
}
