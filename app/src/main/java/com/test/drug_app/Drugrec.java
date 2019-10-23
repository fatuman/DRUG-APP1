package com.test.drug_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Drugrec extends AppCompatActivity {

    private RecyclerView recycle;
    private RecyclerView.Adapter adapt;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugrec1);
        ArrayList<Items> itemlist=new ArrayList<>();
        itemlist.add(new Items(R.drawable.ic_watch_black_24dp,"Time for taking drugs", "Must take it in time"));
        itemlist.add(new Items(R.drawable.ic_all_inclusive_black_24dp,"Type of drug", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_person_pin_circle_black_24dp,"Take precautions ", "Stop self medication"));
        itemlist.add(new Items(R.drawable.ic_watch_black_24dp,"Time for taking drugs", "Must take it in time"));
        itemlist.add(new Items(R.drawable.ic_all_inclusive_black_24dp,"Type of drug", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_person_pin_circle_black_24dp,"Take precautions ", "Stop self medication"));
        itemlist.add(new Items(R.drawable.ic_watch_black_24dp,"Time for taking drugs", "Must take it in time"));
        itemlist.add(new Items(R.drawable.ic_all_inclusive_black_24dp,"Type of drug", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_person_pin_circle_black_24dp,"Take precautions ", "Stop self medication"));
        itemlist.add(new Items(R.drawable.ic_watch_black_24dp,"Time for taking drugs", "Must take it in time"));
        itemlist.add(new Items(R.drawable.ic_all_inclusive_black_24dp,"Type of drug", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_person_pin_circle_black_24dp,"Take precautions ", "Stop self medication"));
        itemlist.add(new Items(R.drawable.ic_watch_black_24dp,"Time for taking drugs", "Must take it in time"));
        itemlist.add(new Items(R.drawable.ic_all_inclusive_black_24dp,"Type of drug", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_person_pin_circle_black_24dp,"Take precautions ", "Stop self medication"));


        recycle= findViewById(R.id.recycle);
        recycle.setHasFixedSize(true);
        manager= new LinearLayoutManager(this);
        adapt=new ItemAdapter(itemlist);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapt);

    }
}
