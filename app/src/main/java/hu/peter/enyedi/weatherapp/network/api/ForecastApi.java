package hu.peter.enyedi.weatherapp.network.api;

import hu.peter.enyedi.weatherapp.network.model.City;
import hu.peter.enyedi.weatherapp.network.model.Weather;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ForecastApi {

    /**
     * Get weather forecast by city name
     *
     * @param q     The name of the city that you want the weather forecast of and &#39;,&#39; and the country code of the city
     * @param appid The application id to use the api call
     * @return Call<WeatherList>
     */

    @GET("")
    Call<Weather> getForecast(@Query("q") String q, @Query("appid") String appid);


    /**
     * Update incorrect local weather data
     *
     * @param weatherId
     * @param body      Updated weather object
     * @return Call<Void>
     */

    @PUT("")
    Call<Void> updateForecast(@Query("weatherId") Integer weatherId, @Body Weather body);


    /**
     * Create new city
     * Add new city to the list
     *
     * @param body Created city object
     * @return Call<Void>
     */

    @POST("")
    Call<Void> createCity(@Body City body);


    /**
     * Delete city
     * Delete city from database
     *
     * @param cityName The city&#39;s name that needs to be deleted
     * @return Call<Void>
     */

    @DELETE("")
    Call<Void> deleteCity(@Path("cityName") String cityName);


}
