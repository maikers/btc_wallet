package com.example.maikers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maikers.btc041.R;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.params.TestNet3Params;

import java.io.IOException;

public class WalletEditActivity extends AppCompatActivity implements View.OnClickListener {
    Button validate;
    Button generate;
    Button save;
    Button cancel;

    EditText privtateAddr;
    EditText publicAddr;

    ECKey key ;
    Address adress;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_edit);

        validate = (Button) findViewById(R.id.Validate);
        generate = (Button) findViewById(R.id.GeneratePair);
        save = (Button) findViewById(R.id.Save);
        cancel = (Button) findViewById(R.id.Cancel);

        privtateAddr = (EditText) findViewById(R.id.NewPrivateField);
        publicAddr = (EditText) findViewById(R.id.NewPublicField);

        client = new OkHttpClient();//HttpC httpClient

        validate.setOnClickListener(this);
        generate.setOnClickListener(this);
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.Validate:
                getWebService();
                Intent intent = new Intent();
                intent.putExtra("name", validate.getText().toString());
                setResult(RESULT_OK, intent);

                break;
            case R.id.Cancel:
                finish();
                break;
            case R.id.Save:

                finish();
                break;
            case R.id.GeneratePair:
                 key = new ECKey();
                 adress=new Address(TestNet3Params.get(),key.getPubKeyHash());
                privtateAddr.setText(adress.toString());
                publicAddr.setText(key.getPrivateKeyAsHex());
                break;
        }
    }

    private void getWebService() {
        final Request request = new Request.Builder().url("https://testnet.blockexplorer.com/api/addr-validate/"+publicAddr.getText().toString()).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        validate.setText("Fail!");
                    }
                });

            }

            @Override
            public void onResponse(final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            validate.setText(response.body().string());
                        } catch (IOException e) {
                            validate.setText("Errore during get body");
                        }
                    }


                });
            }

        });
    }

}
