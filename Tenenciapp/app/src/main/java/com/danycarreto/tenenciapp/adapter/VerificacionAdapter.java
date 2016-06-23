package com.danycarreto.tenenciapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.danycarreto.tenenciapp.R;
import com.danycarreto.tenenciapp.Verificacion;

import java.util.ArrayList;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class VerificacionAdapter extends ArrayAdapter<Verificacion> {

    ArrayList<Verificacion> arrayAdapterVerificacion;
    Context context;
    private ViewHolder viewHolder = null;

    public VerificacionAdapter(Context context,ArrayList<Verificacion> arrayAdapterVerificacion) {

        super(context, R.layout.verificacion_list,arrayAdapterVerificacion);
        this.context = context;
        this.arrayAdapterVerificacion = arrayAdapterVerificacion;
    }



    private static class ViewHolder {
        private TextView txtCertificado;
        private TextView txtVigencia;
        private TextView txtVerificentro;
        private TextView txtFechaVerificacion;
        private TextView txtResultado;
        private TextView txtCausaRechazo;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Verificacion verificacion = getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.verificacion_list, parent, false);
            viewHolder.txtCertificado = (TextView) convertView.findViewById(R.id.txtCertificado);
            viewHolder.txtFechaVerificacion = (TextView) convertView.findViewById(R.id.txtFechaVerificacion);
            viewHolder.txtCausaRechazo = (TextView) convertView.findViewById(R.id.txtCausaRechazo);
            viewHolder.txtVigencia = (TextView) convertView.findViewById(R.id.txtVigencia);
            viewHolder.txtResultado = (TextView) convertView.findViewById(R.id.txtResultado);
            viewHolder.txtVerificentro = (TextView) convertView.findViewById(R.id.txtVerificentro);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtVerificentro.setText( "Verificentro: " + verificacion.getVerificentro());
        viewHolder.txtCertificado.setText("Certificado: " + verificacion.getCertificado());
        viewHolder.txtFechaVerificacion.setText("Fecha Verificacion: "+ verificacion.getFechaVerificacion());
        viewHolder.txtCausaRechazo.setText("Causa Rechazao: "+verificacion.getCausaRechazo());
        viewHolder.txtVigencia.setText("Vigencia: "+ verificacion.getVigencia());
        viewHolder.txtResultado.setText("Resultado: " + verificacion.getResultado());
        return convertView;
    }

}
