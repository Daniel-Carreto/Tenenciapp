package com.danycarreto.tenenciapp;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class RegistroAutoActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;


    private EditText edtMarca;
    private EditText edtSubMarca;
    private EditText edtPlacas;
    private Button btnModelo;
    private Button btnEngomado;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        findViewById();

        setSupportActionBar(toolbar);


    }


    public void findViewById(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        edtMarca = (EditText) findViewById(R.id.edtMarca);
        edtSubMarca = (EditText) findViewById(R.id.edtSubMarca);
        edtPlacas = (EditText) findViewById(R.id.edtPlacas);

        btnModelo = (Button) findViewById(R.id.btnModelo);
        btnEngomado = (Button) findViewById(R.id.btnEngomado);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnModelo.setOnClickListener(this);
        btnEngomado.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnModelo.getId()){
            final CharSequence[] items = getResources().getStringArray(R.array.selecciona_modelo);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Selecciona el modelo");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    btnModelo.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            alert.getWindow().setLayout(600,700);

        }else if(view.getId() == btnEngomado.getId() ){
            final CharSequence[] items = getResources().getStringArray(R.array.color_engomado);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Selecciona el color del engomado");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    btnEngomado.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            alert.getWindow().setLayout(600,700);


        }else if(view.getId() == btnRegistrar.getId()){
            Realm realm = Realm.getInstance(this);
            realm.beginTransaction();
            Auto auto = new Auto();

            auto.setMarca(edtMarca.getText().toString());
            auto.setModelo(btnModelo.getText().toString());
            auto.setSubmarca(edtSubMarca.getText().toString());
            auto.setColor(btnEngomado.getText().toString());
            auto.setPlacas(edtPlacas.getText().toString());

            realm.copyToRealmOrUpdate(auto);
            realm.commitTransaction();
            finish();
        }

    }
}
