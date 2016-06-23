package com.danycarreto.tenenciapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class Auto extends RealmObject{

    @PrimaryKey
    private int id;
    private String marca;
    private String submarca;
    private String modelo;
    private String placas;
    private String color;

    public Auto() {
    }

    public Auto(int id, String marca, String submarca, String modelo, String placas, String color) {
        this.id = id;
        this.marca = marca;
        this.submarca = submarca;
        this.modelo = modelo;
        this.placas = placas;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSubmarca() {
        return submarca;
    }

    public void setSubmarca(String submarca) {
        this.submarca = submarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
