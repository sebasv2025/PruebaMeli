package com.co.PruebaMeli.models;


public class Humano {


    private String adn;

    private boolean esMutante;

    public Humano (String adn, boolean esMutante){
        this.adn = adn;
        this.esMutante = esMutante;
    }

    public String obtenerAdn() {
        return adn;
    }

    public boolean esMutante() {
        return esMutante;
    }
}
