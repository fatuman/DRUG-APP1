package com.test.drug_app;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
//        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
        Log.d("BATTERY","Power connected");
            Toast.makeText(context, "Broadcast Received Device is connected to Power", Toast.LENGTH_LONG).show();
//        }
    }
}