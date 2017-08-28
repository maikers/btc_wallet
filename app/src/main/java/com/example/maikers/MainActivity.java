package com.example.maikers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.bitcoinj.core.Address;
import org.bitcoinj.params.TestNet3Params;

import com.example.maikers.btc041.R;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button send;
    Button history;
    Button addKey;
    TextView balance;
    TextView addresView;
    public static ArrayList< Address > addresses ;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         send=(Button) findViewById(R.id.NewTransaction);
         history=(Button) findViewById(R.id.History);
         addKey=(Button) findViewById(R.id.AddKey);
         balance=(TextView)findViewById(R.id.Balance);
        addresView=(TextView)findViewById(R.id.AddresView);

         send.setOnClickListener(this);
         history.setOnClickListener(this);
         addKey.setOnClickListener(this);

        addresses= new ArrayList<>();
        addresses.add(new Address(TestNet3Params.get(),"mk5Xe2qm2pfQKkf3xHi5rSfUuex54VMFf1"));//mkgTb6px8uPuqPuEnCChUZeVZLaNJrHgFm - pub cUWmSCJMUyHtwW5gWgmTYxnv4LxfXVDh5rMpRsWUjXJUT61oEES4 -sec
        for (Address i:addresses) {
            addresView.setText(addresView.getText().toString()+ " " +i.toString());
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.AddKey:
                intent=new Intent(this,WalletEditActivity.class);
                startActivityForResult(intent,1);

                break;
            case R.id.History:
                intent=new Intent(this,HistoryTransactionActivity.class);
                startActivityForResult(intent,1);

                break;
            case R.id.NewTransaction:
                intent=new Intent(this,SendActivity.class);
                startActivityForResult(intent,1);
                break;

        }

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (data==null)
        {
            return;
        }
        for (Address i:addresses) {
            addresView.setText(addresView.getText().toString()+ " " +i.toString());
        }
        String name=data.getStringExtra("name");
        balance.setText(name);
    }
}
