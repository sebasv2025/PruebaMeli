package com.co.PruebaMeli.services;

import com.co.PruebaMeli.modelo.Humano;

public class Response {

    private Humano humano;

    public Response(Humano humano){
        this.humano = humano;
    }

    public Humano getHumano() {
        return humano;
    }

    public boolean esMutante(){
        return humano.esMutante();
    }
}
