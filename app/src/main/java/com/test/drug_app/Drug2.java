package com.test.drug_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
//import android.support.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.NotificationManager;
//import android.support.v4.app.NotificationCompat;



import android.content.Context;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Drug2 extends AppCompatActivity {

    private static final int CAMERA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drug1);
        Button buttoncam;
        buttoncam=(Button)findViewById(R.id.buttoncam);
        buttoncam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
            }
        });
    }

}
