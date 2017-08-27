package com.example.maikers;

/**
 * Created by maikers on 18.08.17.
 */
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BitcoinAPI {
    @GET("addr/mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1")
    Call<Addr> getData(@Query("key") String resourceName);
}
