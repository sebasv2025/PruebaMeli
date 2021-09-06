package com.co.PruebaMeli.services.excepcion;


public class ExcepcionMutante extends RuntimeException {

    String mensajeError;

    public ExcepcionMutante() {
    }

    public ExcepcionMutante( String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
