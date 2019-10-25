package com.test.drug_app;

import android.content.Intent;

import android.os.Bundle;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;



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
