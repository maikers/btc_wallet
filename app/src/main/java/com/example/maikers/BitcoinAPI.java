package com.example.maikers;

/**
 * Created by maikers on 18.08.17.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BitcoinAPI {
    @POST("api/addrs/txs")
    Call<Addr> getHistory(@Body  MultipleAddresses ad);
    @GET("/api/addr/{addr}/utxo")
    Call<ArrayList<UnspentOutputs>> getUnsOut(@Path("addr")String addr );
    @POST("/api/tx/send")
    Call<JsonObject>send(@Body String s);
}
