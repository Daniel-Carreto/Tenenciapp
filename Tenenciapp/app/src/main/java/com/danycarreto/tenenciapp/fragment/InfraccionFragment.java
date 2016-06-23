package com.danycarreto.tenenciapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danycarreto.tenenciapp.MainActivity;
import com.danycarreto.tenenciapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class InfraccionFragment extends Fragment {

    private TextView txtFolio;
    private TextView txtFecha;
    private TextView txtSituacion;
    private TextView txtMotivo;
    private TextView txtSancion;

    public InfraccionFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infraccion, container, false);
        txtFecha = (TextView) view.findViewById(R.id.txtFecha);
        txtFolio = (TextView) view.findViewById(R.id.txtFolio);
        txtMotivo = (TextView) view.findViewById(R.id.txtMotivo);
        txtSancion = (TextView) view.findViewById(R.id.txtSancion);
        txtSituacion =(TextView) view.findViewById(R.id.txtSituacion);

        try{
            obtenerInfraccion();
        }catch(JSONException e){
            e.printStackTrace();
        }

        return view;
    }

    public void obtenerInfraccion() throws JSONException{
        JSONObject jsonObjectConsulta = new JSONObject(MainActivity.infraccion);
        JSONObject jsonObjectConsult = new JSONObject(jsonObjectConsulta.getString("consulta"));
        JSONArray jsonArrayInfraccion = new JSONArray(jsonObjectConsult.getString("infracciones"));
        for (int i = 0; i <jsonArrayInfraccion.length() ; i++) {
            JSONObject jsonObjectDetalle = new JSONObject(jsonArrayInfraccion.get(i).toString());
            txtFecha.setText("Fecha: "+jsonObjectDetalle.getString("fecha"));
            txtSituacion.setText("Situacion: "+jsonObjectDetalle.getString("situacion"));
            txtSancion.setText("Sanciòn: "+jsonObjectDetalle.getString("sancion"));
            txtFolio.setText("Folio: "+jsonObjectDetalle.getString("folio"));
            txtMotivo.setText("Motivo: "+jsonObjectDetalle.getString("motivo"));
        }

    }
}
