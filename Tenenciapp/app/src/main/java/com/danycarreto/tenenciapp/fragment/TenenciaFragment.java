package com.danycarreto.tenenciapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danycarreto.tenenciapp.MainActivity;
import com.danycarreto.tenenciapp.R;

import org.json.JSONException;
import org.json.JSONObject;


public class TenenciaFragment extends Fragment {


    private TextView txtNumPlacas;
    private TextView txtAdeudos;

    public TenenciaFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tenencia, container, false);
        txtNumPlacas = (TextView) view.findViewById(R.id.txtNumPlacas);
        txtAdeudos = (TextView) view.findViewById(R.id.txtAdeudo);
        try{
            obtenerTenencia();

        }catch (JSONException e){
            e.printStackTrace();
        }
        return view;
    }


   public void obtenerTenencia()throws JSONException{
       JSONObject jsonObjectConsulta = new JSONObject(MainActivity.tenencia);
       JSONObject jsonObjectTenencia = new JSONObject(jsonObjectConsulta.getString("consulta"));
       JSONObject jsonObjectAdeudos = new JSONObject(jsonObjectTenencia.getString("tenencias"));
       txtAdeudos.setText(jsonObjectAdeudos.getString("tieneadeudos"));
       txtNumPlacas.setText(jsonObjectAdeudos.getString("placa"));
   }
}
