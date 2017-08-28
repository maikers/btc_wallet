package com.example.maikers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.maikers.btc041.R;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryTransactionActivity extends AppCompatActivity implements View.OnClickListener {
    TextView history;
    Button generate;
    private OkHttpClient client;

    private String myUrl;
    private String myAddr;
    private Retrofit retrofit;
    private static BitcoinAPI bitcoinAPI;
    public MultipleAddresses his;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_transaction);
        myUrl = "https://testnet.blockexplorer.com/api/addr/";
        generate = (Button) findViewById(R.id.generate);
        generate.setOnClickListener(this);
        history=(TextView)findViewById(R.id.history);
        MultipleAddresses his=new MultipleAddresses();
        his.setAddrs("mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1,mkgTb6px8uPuqPuEnCChUZeVZLaNJrHgFm");



        retrofit = new Retrofit.Builder()
                .baseUrl("https://testnet.blockexplorer.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        bitcoinAPI = retrofit.create(BitcoinAPI.class); //Создаем объект, при помощи которого будем выполнять запросы

       /* HistoryTransactionActivity.getApi().getHistory("mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1","mkgTb6px8uPuqPuEnCChUZeVZLaNJrHgFm",0,20).enqueue(new Callback<Addr>() {
            @Override

            public void onResponse(Call<Addr> call, Response<Addr> response) {
                if(response.body()!=null) {
                    history.setText(response.body().getAddrStr()+" "+response.body().getBalance());
                    //Данные успешно пришли, но надо проверить response.body() на null
                }
                else
                {   Integer a;
                    a=response.code();
                    history.setText(a.toString());
                }
            }
            @Override
            public void onFailure(Call<Addr> call, Throwable t) {
               history.setText(t.getStackTrace().toString()); //Произошла ошибка
            }
        });*/
      /*  history = (TextView) findViewById(R.id.history);
        for (Address i : MainActivity.addresses) {
            if (myAddr.isEmpty()) {
                myAddr = i.toString();
            }
            else
            {
                myAddr+=","+i.toString();
            }

        }
        request = new Request.Builder().url(myUrl+myAddr+"/txs?from=0&to=20").build();*/


    }


    private void getWebService() {
        HistoryTransactionActivity.getApi().getHistory(his).enqueue(new Callback<Addr>() {
            @Override

            public void onResponse(Call<Addr> call, Response<Addr> response) {

                if(response.body()!=null) {
                    history.setText(response.body().getAddrStr()+" "+response.body().getBalance());
                    //Данные успешно пришли, но надо проверить response.body() на null
                }
                else
                {
                    Integer a;
                    a=response.code();
                    history.setText(a.toString());
                }
            }
            @Override
            public void onFailure(Call<Addr> call, Throwable t) {

                StackTraceElement[] stackTraceElements = t.getStackTrace();
                String message = "";
                if(stackTraceElements.length >= 3) {
                    StackTraceElement element = stackTraceElements[2];
                    String className = element.getClassName();
                    String methodName = element.getMethodName();
                    history.setText(className+" "+methodName);

                }
                //Произошла ошибка //Произошла ошибка
            }
        });
    }

    public static BitcoinAPI getApi() {
        return bitcoinAPI;
    }
    /*    final Request request = new Request.Builder().url("https://testnet.blockexplorer.com/api/addr/mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        history.setText("Fail!");
                    }
                });

            }

            @Override
            public void onResponse(final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            history.setText(response.body().string());
                        } catch (IOException e) {
                            history.setText("Errore during get body");
                        }
                    }


                });
            }

        });*/




    @Override
    public void onClick(View view) {
        getWebService();
    }
}


