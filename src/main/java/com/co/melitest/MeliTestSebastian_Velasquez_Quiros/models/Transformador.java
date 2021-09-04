package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models;

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
    public String unificarCadenaAdn(String[] adn) {
        return null;
    }


}
