package com.test.drug_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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

        //sendbroadcast=(Button)findViewById(R.id.castbtn);
       /* sendbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.local.receiver");
                sendBroadcast(intent);
            }
        });*/
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context, "Broadcast Received Device is connected to Power",Toast.LENGTH_LONG).show();
            }
        };
        Button reset;
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Your password has been reset," +
                        "    please check your email " ;
                NotificationCompat.Builder builder=  new NotificationCompat.Builder
                        (Drug3.this)
                        //.setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Drug_App")
                        .setAutoCancel(true);
                Intent intent = new Intent(Drug3.this,NotificationsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);
                PendingIntent pendingIntent= PendingIntent.getActivity(Drug3.this,
                        0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
               notificationManager.notify(0,builder.build());
            }
        });

//        MyBroadcastReceiver myBroadcastReceiver=new MyBroadcastReceiver();
//        IntentFilter filter1=new IntentFilter();
//        filter1.addAction("Intent.ACTION_POWER_CONNECTED");
//        registerReceiver(myBroadcastReceiver,filter1);
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


