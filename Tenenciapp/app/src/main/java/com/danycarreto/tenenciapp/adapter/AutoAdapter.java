package com.danycarreto.tenenciapp.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danycarreto.tenenciapp.Auto;
import com.danycarreto.tenenciapp.MainActivity;
import com.danycarreto.tenenciapp.R;
import com.danycarreto.tenenciapp.Utils;

import java.util.ArrayList;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.AutoViewHolder>{

    private ArrayList<Auto> arrayListAuto;
    private Auto auto;

    public AutoAdapter(ArrayList<Auto> arrayListAuto) {
        this.arrayListAuto = arrayListAuto;
    }

    @Override
    public AutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tarjeta= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_auto,parent,false);

        return new AutoViewHolder(tarjeta);
    }

    @Override
    public void onBindViewHolder(AutoViewHolder holder, int position) {
        auto = arrayListAuto.get(position);
        holder.txtMarca.setText(auto.getMarca());
        holder.txtModelo.setText(auto.getModelo());
        holder.txtPlacas.setText(auto.getPlacas());
        holder.cardAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra(Utils.NUMERO_PLACAS,auto.getPlacas());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListAuto.size();
    }

    public static class AutoViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtMarca;
        protected TextView txtModelo;
        protected TextView txtPlacas;
        protected CardView cardAuto;
         public AutoViewHolder(View itemView) {
            super(itemView);
            txtMarca = (TextView) itemView.findViewById(R.id.txtMarca);
            txtModelo = (TextView) itemView.findViewById(R.id.txtModelo);
            txtPlacas = (TextView) itemView.findViewById(R.id.txtPlacas);
             cardAuto = (CardView) itemView.findViewById(R.id.cardAuto);
        }
    }

}