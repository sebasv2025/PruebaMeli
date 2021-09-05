package com.co.PruebaMeli.entidades;


import javax.persistence.*;


@Entity
@Table(name = "humano")
public class EntidadHumano {

    @Id
    @Column(name = "adn")
    private String adn;
    @Column(name = "mutante")
    private boolean esMutante;

    public EntidadHumano(){

    }

    public EntidadHumano(String adn, boolean esMutante){
        this.adn = adn;
        this.esMutante = esMutante;
    }


    public String obtenerAdn() {
        return adn;
    }

    public boolean mutante() {
        return esMutante;
    }

}