package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.services;

import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.ClasificadorAdn;
import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.Humano;
import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.ITransformador;
import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.repositorio.IRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioClasificador {

    private ClasificadorAdn clasificadorAdn;
    private IRepositorio repositorio;
    private ITransformador transformador;

    @Autowired
    public ServicioClasificador(ClasificadorAdn clasificadorAdn, IRepositorio repositorio, ITransformador transformador){
        this.clasificadorAdn = clasificadorAdn;
        this.repositorio = repositorio;
        this.transformador = transformador;
    }



    public Response procesar(String[] adn){

        String cadenaAdn = transformador.unificarCadenaAdn(adn);


        if(repositorio.hayRegistros(cadenaAdn)){
            throw new ExcepcionMutante("El adn ya existe.");
        }
        boolean esMutante = clasificadorAdn.esMutante(adn);

        Humano humano = new Humano(cadenaAdn, esMutante);
        repositorio.insertar(humano);

        return new Response(humano);


    }

}
