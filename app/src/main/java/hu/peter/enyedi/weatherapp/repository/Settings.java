package hu.peter.enyedi.weatherapp.repository;

public interface Settings {
    void initSettings();

    void saveCurrentCity(String cityName);

    String getCurrentCity();
}
