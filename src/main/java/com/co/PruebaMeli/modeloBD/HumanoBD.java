package com.co.PruebaMeli.modeloBD;


import javax.persistence.*;


@Entity
@Table(name = "humano")
public class HumanoBD {

    @Id
    @Column(name = "adn")
    private String adn;
    @Column(name = "mutante")
    private boolean esMutante;

    public HumanoBD(){

    }

    public HumanoBD(String adn, boolean esMutante){
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