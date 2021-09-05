package com.co.PruebaMeli.services;

import com.co.PruebaMeli.entidades.EntidadHumano;
import com.co.PruebaMeli.modelo.Humano;
import com.co.PruebaMeli.repositorio.IHumanoRepositorio;
import com.co.PruebaMeli.modelo.ClasificadorAdn;
import com.co.PruebaMeli.modelo.ITransformador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioClasificador implements IServicioClasificador{

    private ClasificadorAdn clasificadorAdn;
    private IHumanoRepositorio repositorio;
    private ITransformador transformador;

    @Autowired
    public ServicioClasificador(ClasificadorAdn clasificadorAdn, IHumanoRepositorio humanoRepositorio, ITransformador transformador){
        this.clasificadorAdn = clasificadorAdn;
        this.repositorio = humanoRepositorio;
        this.transformador = transformador;
    }

    @Override
    public Response procesarAdn(String[] adn){
        /*
        if(repositorio.existeAdn(transformador.unificarCadenaAdn(adn))){
            throw new ExcepcionMutante("El adn ya existe.");
        }*/

        EntidadHumano entidadHumano = new EntidadHumano(transformador.unificarCadenaAdn(adn), clasificadorAdn.esMutante(adn));
        repositorio.save(entidadHumano);

        Humano humano = new Humano(transformador.unificarCadenaAdn(adn), clasificadorAdn.esMutante(adn));
        return new Response(humano);
    }

}
