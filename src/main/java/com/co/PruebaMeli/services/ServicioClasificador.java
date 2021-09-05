package com.co.PruebaMeli.services;

import com.co.PruebaMeli.modeloBD.HumanoBD;
import com.co.PruebaMeli.models.Humano;
import com.co.PruebaMeli.repositorio.IHumanoBD;
import com.co.PruebaMeli.models.ClasificadorAdn;
import com.co.PruebaMeli.models.ITransformador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioClasificador {

    private ClasificadorAdn clasificadorAdn;
    private IHumanoBD repositorio;
    private ITransformador transformador;

    @Autowired
    public ServicioClasificador(ClasificadorAdn clasificadorAdn, IHumanoBD repositorio, ITransformador transformador){
        this.clasificadorAdn = clasificadorAdn;
        this.repositorio = repositorio;
        this.transformador = transformador;
    }



    public Response procesar(String[] adn){

        String cadenaAdn = transformador.unificarCadenaAdn(adn);


        /*if(repositorio.hayRegistros(cadenaAdn)){
            throw new ExcepcionMutante("El adn ya existe.");
        }
         */
        boolean esMutante = clasificadorAdn.esMutante(adn);

        Humano humano = new Humano(cadenaAdn, esMutante);
        HumanoBD humanooo = new HumanoBD("ABD", false);

        repositorio.save(humanooo);

        return new Response(humano);


    }

}
