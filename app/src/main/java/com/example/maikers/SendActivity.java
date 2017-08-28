package com.example.maikers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maikers.btc041.R;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.UTXO;
import org.bitcoinj.core.UTXOProvider;
import org.bitcoinj.core.UTXOProviderException;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.script.Script;
import org.bitcoinj.wallet.Wallet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.google.protobuf.ByteString.*;

public class SendActivity extends AppCompatActivity implements View.OnClickListener{
    Button send;
    Button cancel;

    EditText from;
    EditText to;
    EditText surrend;
    EditText count;

    private Retrofit retrofit;
    private static BitcoinAPI bitcoinAPI;

    UnspentOutputs uo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        send= (Button) findViewById(R.id.send);
        cancel = (Button) findViewById(R.id.cancel);

        from = (EditText) findViewById(R.id.From);
        to = (EditText) findViewById(R.id.to);
        surrend = (EditText) findViewById(R.id.Surrend);
        surrend = (EditText) findViewById(R.id.count);

        uo=new UnspentOutputs();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://testnet.blockexplorer.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        bitcoinAPI = retrofit.create(BitcoinAPI.class);

        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
        ECKey key=new ECKey();
        Address address=new Address(TestNet3Params.get(),key.getPubKeyHash());
        key.getPubKeyHash();
        Wallet wallet=new Wallet(TestNet3Params.get());
        //wallet.key;
        wallet.setUTXOProvider(new UTXOProvider() {
            @Override
            public List<UTXO> getOpenTransactionOutputs(List<Address> addresses) throws UTXOProviderException {
                getWebService();
                         UTXO utxo=new UTXO((new Sha256Hash(uo.getTxid())),uo.getTs(),Coin.valueOf(uo.getAmount()),1180351,false,new Script(uo.getScriptPubKey().getBytes()));
                List<UTXO> utxoList=new List<UTXO>() {
                }
                return   ;
            }

            @Override
            public int getChainHeadHeight() throws UTXOProviderException {
                return 0;
            }

            @Override
            public NetworkParameters getParams() {
                return TestNet3Params.get();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.cancel:
                finish();
                break;

            case R.id.send:

                byte [] bytes={1,23,2,13,12};
                String hexString="";
                for(byte b:bytes) {
                     hexString = hexString+Integer.toHexString(b);
                    from.setText(hexString);
                }
                //finish();
                break;

        }
    }
    private void getWebService() {
        HistoryTransactionActivity.getApi().getUnsOut("mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1").enqueue(new Callback<UnspentOutputs>() {
            @Override

            public void onResponse(Call<UnspentOutputs> call, Response<UnspentOutputs> response) {

                if(response.body()!=null) {
                    uo=response.body();
                    to.setText(uo.getAddress()+" "+uo.getTxid());
                    //Данные успешно пришли, но надо проверить response.body() на null
                }
                else
                {
                    Integer a;
                    a=response.code();
                    to.setText(a.toString());
                }
            }
            @Override
            public void onFailure(Call<UnspentOutputs> call, Throwable t) {

                StackTraceElement[] stackTraceElements = t.getStackTrace();
                String message = "";
                if(stackTraceElements.length >= 3) {
                    StackTraceElement element = stackTraceElements[2];
                    String className = element.getClassName();
                    String methodName = element.getMethodName();
                    to.setText(className+" "+methodName);

                }
                //Произошла ошибка //Произошла ошибка
            }
        });
    }

    public static BitcoinAPI getApi() {
        return bitcoinAPI;
    }

}
