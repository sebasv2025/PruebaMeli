package com.co.PruebaMeli.services;

import com.co.PruebaMeli.modelo.Humano;
import org.springframework.http.HttpStatus;

public class Response {

    private Humano humano;
    private HttpStatus estado;

    public Response() {
    }

    public Response(Humano humano, HttpStatus estado){
        this.humano = humano;
        this.estado = estado;
    }

    public Response(HttpStatus estado){
        this.estado = estado;
    }

    public HttpStatus obtenerEstado() {
        return estado;
    }

    public Humano getHumano() {
        return humano;
    }

    public void setHumano(Humano humano) {
        this.humano = humano;
    }

    public boolean esMutante(){
        return getHumano().esMutante();
    }
}
