package com.test.drug_app;

import android.content.IntentFilter;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import android.content.BroadcastReceiver;
import android.content.Context;
public class Drug3 extends AppCompatActivity {
    BroadcastReceiver receiver;
    IntentFilter filter;
    Button sendbroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drug3);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Broadcast Received in Activity called", Toast.LENGTH_SHORT).show();
            }
        };
        // to register local receiver
        filter = new IntentFilter();
        // specify the action to which receiver will listen
        filter.addAction("com.local.receiver");
        registerReceiver(receiver,filter);
        sendbroadcast=(Button)findViewById(R.id.castbtn);
        sendbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.local.receiver");
                sendBroadcast(intent);
            }
        });
        MyBroadcastReceiver myBroadcastReceiver=new MyBroadcastReceiver();
        IntentFilter filter1=new IntentFilter();
        filter1.addAction("Intent.ACTION_POWER_CONNECTED");
        registerReceiver(myBroadcastReceiver,filter1);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(receiver!=null)
        {
            unregisterReceiver(receiver);
        }
    }

}


