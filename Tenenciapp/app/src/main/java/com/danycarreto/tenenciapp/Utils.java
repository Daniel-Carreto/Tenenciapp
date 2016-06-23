package com.danycarreto.tenenciapp;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class Utils {

    public static String NUMERO_PLACAS = "numero_placas";
    public static String URL = "http://datos.labplc.mx/movilidad/vehiculos/";

    public static String getUrlTenencia(String placa) {
        return URL+ placa + "/tenencias.json" ;
    }

    public static String getUrlInfraccion(String placa) {
        return URL + placa + "/infracciones.json";
    }

    public static String getUrlVerificacion(String placa) {
        return URL + placa + "/verificaciones.json";
    }
}
