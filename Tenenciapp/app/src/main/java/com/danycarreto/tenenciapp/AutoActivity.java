package com.danycarreto.tenenciapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.danycarreto.tenenciapp.adapter.AutoAdapter;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class AutoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RealmQuery<Auto> query;
    private Realm realm;

    RecyclerView recyclerView;
    TextView txtNuevo;
    Auto civic;
    ArrayList<Auto> arrayListAuto;
    AutoAdapter autoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtNuevo = (TextView) findViewById(R.id.txtNuevo);
        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);

        arrayListAuto = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AutoActivity.this,RegistroAutoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getInstance(this);
        query = realm.where(Auto.class);
        RealmResults<Auto> result1 = query.findAll();
        if(!result1.isEmpty()){
            recyclerView.setVisibility(View.VISIBLE);
            txtNuevo.setVisibility(View.GONE);
            for (Auto u : result1) {

                    arrayListAuto.add(u);

                System.out.println("hola-<"+u.getModelo());
            }
            autoAdapter =  new AutoAdapter(arrayListAuto);
            recyclerView.setAdapter(autoAdapter);
        }

    }
}
