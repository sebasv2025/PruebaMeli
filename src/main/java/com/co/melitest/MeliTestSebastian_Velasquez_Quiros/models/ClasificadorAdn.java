package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasificadorAdn {


    private Transformador transformador;

    @Autowired
    public  ClasificadorAdn(Transformador transformador){
        this.transformador = transformador;
    }


    public boolean esMutante(String [] adn){
        return esMutanteLineal(adn) || esMutanteDiagonal(adn) || esMutanteDiagonalInv(adn);
    }

    private boolean esMutanteLineal(String [] adn){
        
        char[][] nuevaMatriz = transformador.modelarAdnEnMatriz(adn);

        int accountant = 0;
        char[] adnMuestra = "ACTG".toCharArray();


        for(int i= 0; i< adnMuestra.length; i++){
            for(int j= 0; j< adn.length; j++){
                for (int k=0; k< adn.length ; k++){
                    if (adnMuestra[i] == nuevaMatriz[k][j] || adnMuestra[i] == nuevaMatriz[j][k]){
                        accountant++;
                    }else if(accountant >= 4)
                    {
                        return true;
                    }else{
                        accountant=0;
                    }
                }
                if (accountant >= 4){
                    return true;
                }else {
                    accountant=0;
                }
            }
        }
        return false;
    }


    private boolean esMutanteDiagonal(String[] adn) {
        int ancho = adn.length;
        int alto = adn.length;
        char[][] nuevaMatriz = transformador.modelarAdnEnMatriz(adn);

        int accountant = 0;
        char[] adnMuestra = "ACTG".toCharArray();

        for(int i= 0; i< adnMuestra.length; i++){
            for (int diagonal = 1 - ancho; diagonal <= alto - 1; diagonal += 1) {
                for (int vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
                     vertical < alto && horizontal < ancho;
                     vertical += 1, horizontal += 1) {
                    //System.out.println(nuevaMatriz[vertical][horizontal]);

                    if (adnMuestra[i] == nuevaMatriz[vertical][horizontal]){
                        accountant++;
                    }else if(accountant >= 4)
                    {
                        return true;
                    }else{
                        accountant=0;
                    }

                }
                //System.out.println("\r");

                //Se inicia nueva evaluación de ADN
                if (accountant >= 4){
                    return true;
                }else {
                    accountant=0;
                }

            }
            return false;
        }
        return false;
    }


    private boolean esMutanteDiagonalInv(String[] adn) {
        int ancho = adn.length;
        int alto = adn.length;
        int anchoAux = ancho;

        int accountant = 0;
        char[] adnMuestra = "GCTA".toCharArray();

        char[][] nuevaMatriz = transformador.modelarAdnEnMatriz(adn);

        for(int i= 0; i< adnMuestra.length; i++){
            anchoAux = ancho;
            for (int diagonal = 1 - ancho; diagonal <= alto - 1; diagonal += 1) {
                for (int vertical = Math.max(ancho - Math.abs(diagonal) - 1, anchoAux - 1), horizontal = -Math.min(0, diagonal);
                     vertical < alto && horizontal < ancho && vertical >= 0;
                     vertical -= 1, horizontal += 1) {

                    System.out.println(nuevaMatriz[vertical][horizontal]);

                    if (adnMuestra[i] == nuevaMatriz[vertical][horizontal]){
                        accountant++;
                    }else if(accountant >= 4)
                    {
                        return true;
                    }else{
                        accountant=0;
                    }
                }

                System.out.println("\r");

                if (accountant >= 4){
                    return true;
                }else {
                    accountant=0;
                }

                if (diagonal == 0) {
                    anchoAux = 1;
                }

            }
        }
        return false;
    }

}
