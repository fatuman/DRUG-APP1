package com.test.drug_app;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent intent){
      Toast.makeText(context, "Broadcast Received Device is connected to Power",Toast.LENGTH_LONG).show();
    }
}
