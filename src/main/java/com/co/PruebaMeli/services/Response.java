package com.co.PruebaMeli.services;

import com.co.PruebaMeli.modelo.Humano;

public class Response {

    private Humano humano;

    public Response() {
    }

    public Response(Humano humano){
        this.humano = humano;
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
