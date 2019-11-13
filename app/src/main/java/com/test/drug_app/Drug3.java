package com.test.drug_app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.os.Build;
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


        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context, "Broadcast Received Device is connected to Power",Toast.LENGTH_LONG).show();
            }
        };
        Button b1;
        b1 = (Button)findViewById(R.id.reset);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
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
    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_message)

                        .setContentText("Your password has been reset please check your email");

        Intent notificationIntent = new Intent(this, Drug3.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}


