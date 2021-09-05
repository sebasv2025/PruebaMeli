package com.co.PruebaMeli.modelo;

import org.springframework.stereotype.Component;

@Component
public class Transformador implements ITransformador {

    @Override
    public char[][] modelarAdnEnMatriz(String [] adn){

        char[][] matrizAdn = new char[adn.length][adn.length];

        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn.length; j++) {
                matrizAdn[i][j] = adn[i].charAt(j);
            }
        }
        return matrizAdn;
    }

    @Override
    public String unificarCadenaAdn(String[] adn){

        StringBuilder cadenaAdn = new StringBuilder(255);

        for (int i=0; i<adn.length; i++){
            for(int j=0; j<adn.length; j++){
                cadenaAdn.append(adn[i].charAt(j));
            }
        }
        return cadenaAdn.toString();
    }


}
