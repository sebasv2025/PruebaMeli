package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Humano {

    @Id
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
