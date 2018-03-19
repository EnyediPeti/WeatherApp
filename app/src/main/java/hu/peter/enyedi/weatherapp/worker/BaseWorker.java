package hu.peter.enyedi.weatherapp.worker;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import hu.axolotl.tasklib.exception.GlobalTaskException;
import hu.axolotl.tasklib.exception.TaskException;
import hu.peter.enyedi.weatherapp.WeatherApplication;
import hu.peter.enyedi.weatherapp.WeatherApplicationComponent;
import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseWorker {

    public static final int UNKNOWN_HOST = 1;
    public static final int SOCKET_TIMEOUT = 2;
    public static final int RESPONSE_ERROR = 3;


    public BaseWorker() {
        injectDependencies(WeatherApplication.injector);
    }

    protected abstract void injectDependencies(WeatherApplicationComponent injector);

    protected <T> T callWithBasicResponseCheckAnd200(Call<T> call) {
        Response<T> response = callWithConnectionCheck(call);
        checkHttp200(response);
        return response.body();
    }

    protected <T> Response<T> callWithConnectionCheck(Call<T> call) {
        try {
            Response<T> response = call.execute();
            return response;
        } catch (UnknownHostException e) {
            throw new GlobalTaskException(UNKNOWN_HOST, e);
        } catch (SocketTimeoutException e) {
            throw new GlobalTaskException(SOCKET_TIMEOUT, e);
        } catch (IOException e) {
            throw new GlobalTaskException(SOCKET_TIMEOUT, e);
        }
    }

    protected void checkHttp200(Response response) {
        checkHttp200(response, RESPONSE_ERROR);
    }

    protected void checkHttp200(Response response, int exceptionCode) {
        if (!response.isSuccessful()) {
            throw new TaskException(exceptionCode);
        }
    }

}
