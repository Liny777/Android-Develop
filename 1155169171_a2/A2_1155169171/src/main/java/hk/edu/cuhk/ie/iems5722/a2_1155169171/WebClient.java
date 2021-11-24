package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebClient {

    private static ApiService INSTANCE;

    private static final String BASE_URL = "http://18.217.125.61/api/a3/";

    public static ApiService getInstance() {
        if (INSTANCE == null) {
            synchronized (ApiService.class) {
                if (INSTANCE == null) {

                    INSTANCE = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.class);
                    Log.i("INSTANCE",BASE_URL);
                }
            }
        }
        return INSTANCE;
    }

}


