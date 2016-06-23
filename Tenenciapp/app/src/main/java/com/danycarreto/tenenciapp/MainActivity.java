package com.danycarreto.tenenciapp;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.danycarreto.tenenciapp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CharSequence titulos[];
    private Toolbar toolbar;
    private TabLayout tabLayout;
    public static String verificacion;
    public static String infraccion;
    public static String tenencia;
    private ProgressDialog pDialog;
    private String numeroPlacas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        Bundle bundle = getIntent().getExtras();
        numeroPlacas = bundle.getString(Utils.NUMERO_PLACAS);

        titulos = getResources().getStringArray(R.array.titulos);

        pedirInfraccion();



    }

    public void pedirInfraccion(){

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();
        StringRequest stringRequestInfraccion = new StringRequest(Request.Method.GET, Utils.getUrlInfraccion(numeroPlacas),
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        infraccion = response;
                        pDialog.hide();
                        pedirTenencia();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();
            }
        }
        );
        SingletonVolley.getmInstance(this).addToRequestQueue(stringRequestInfraccion);
    }

    public void pedirTenencia(){
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        StringRequest stringRequestTenencia = new StringRequest(Request.Method.GET, Utils.getUrlTenencia(numeroPlacas),
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        tenencia = response;
                        pDialog.hide();
                        pedirVerificacion();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();
            }
        }
        );
        SingletonVolley.getmInstance(this).addToRequestQueue(stringRequestTenencia);
    }
    public void pedirVerificacion(){
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        StringRequest stringRequestVerificacion = new StringRequest(Request.Method.GET, Utils.getUrlVerificacion(numeroPlacas),
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        verificacion = response;
                        pDialog.hide();
                        setViewPager();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();
            }
        }
        );
        SingletonVolley.getmInstance(this).addToRequestQueue(stringRequestVerificacion);
    }

public void setViewPager(){
    viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),titulos));
    tabLayout.setupWithViewPager(viewPager);
}



}
