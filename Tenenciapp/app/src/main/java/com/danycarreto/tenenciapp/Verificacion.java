package com.danycarreto.tenenciapp;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class Verificacion {

    private String certificado;
    private String vigencia;
    private String verificentro;
    private String fechaVerificacion;
    private String resultado;
    private String causaRechazo;

    public Verificacion() {
    }

    public Verificacion(String certificado, String vigencia, String verificentro, String fechaVerificacion, String resultado, String causaRechazo) {
        this.certificado = certificado;
        this.vigencia = vigencia;
        this.verificentro = verificentro;
        this.fechaVerificacion = fechaVerificacion;
        this.resultado = resultado;
        this.causaRechazo = causaRechazo;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVerificentro() {
        return verificentro;
    }

    public void setVerificentro(String verificentro) {
        this.verificentro = verificentro;
    }

    public String getFechaVerificacion() {
        return fechaVerificacion;
    }

    public void setFechaVerificacion(String fechaVerificacion) {
        this.fechaVerificacion = fechaVerificacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCausaRechazo() {
        return causaRechazo;
    }

    public void setCausaRechazo(String causaRechazo) {
        this.causaRechazo = causaRechazo;
    }
}
