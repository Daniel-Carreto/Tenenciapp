package com.danycarreto.tenenciapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.danycarreto.tenenciapp.MainActivity;
import com.danycarreto.tenenciapp.R;
import com.danycarreto.tenenciapp.Verificacion;
import com.danycarreto.tenenciapp.adapter.VerificacionAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class VerificacionFragment extends Fragment {

    private ListView listViewVerificacion;
    private ArrayList<Verificacion> arrayListVerificacion;
    private VerificacionAdapter verificacionAdapter;

    public VerificacionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_verificacion, container, false);
        listViewVerificacion = (ListView) view.findViewById(R.id.listViewVerificacion);
        try{
            obtenerVerificacion();
        }catch(JSONException e){
            e.printStackTrace();
        }


        return view;
    }


   public void obtenerVerificacion()throws JSONException{
       arrayListVerificacion = new ArrayList<>();
       JSONObject jsonObjectConsulta = new JSONObject(MainActivity.verificacion);
       JSONObject jsonObjectConsult = new JSONObject(jsonObjectConsulta.getString("consulta"));
       System.out.println(jsonObjectConsult.toString());
       JSONArray jsonArrayVerificacion = new JSONArray(jsonObjectConsult.getString("verificaciones"));
       for (int i = 0; i < jsonArrayVerificacion.length(); i++) {
           JSONObject jsonObjectDetalle = new JSONObject(jsonArrayVerificacion.get(i).toString());
           Verificacion verificacion = new Verificacion();
           verificacion.setCausaRechazo(jsonObjectDetalle.getString("causa_rechazo"));
           verificacion.setCertificado(jsonObjectDetalle.getString("certificado"));
           verificacion.setFechaVerificacion(jsonObjectDetalle.getString("fecha_verificacion"));
           verificacion.setVerificentro(jsonObjectDetalle.getString("verificentro"));
           verificacion.setVigencia(jsonObjectDetalle.getString("vigencia"));
           verificacion.setResultado(jsonObjectDetalle.getString("resultado"));
           arrayListVerificacion.add(verificacion);
       }

       verificacionAdapter = new VerificacionAdapter(getActivity(), arrayListVerificacion);
       listViewVerificacion.setAdapter(verificacionAdapter);
   }
}
