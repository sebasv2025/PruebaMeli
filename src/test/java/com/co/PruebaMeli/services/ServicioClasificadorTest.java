package com.co.PruebaMeli.services;

import com.co.PruebaMeli.entidades.EntidadHumano;
import com.co.PruebaMeli.modelo.ClasificadorAdn;
import com.co.PruebaMeli.modelo.Humano;
import com.co.PruebaMeli.modelo.ITransformador;
import com.co.PruebaMeli.modelo.Transformador;
import com.co.PruebaMeli.repositorio.IHumanoRepositorio;
import com.co.PruebaMeli.services.excepcion.ExcepcionMutante;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.transform.sax.SAXSource;

import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionAction.Fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ServicioClasificadorTest {

    Response response;
    String[] adnMutante =  {"AASDADS", "SASTAST", "TASGASG", "GGASGGG", "GGSSTGG", "GGSGGSA", "GGASGSA"};
    String[] adnNoMutante =  {"AASDADS", "SASTAST", "TASGASG", "GGASGGG", "GGSSTGG", "GGSGGSA", "ASTTGSA"};

    Transformador transformador = new Transformador();
    ClasificadorAdn clasificadorAdn = new ClasificadorAdn(transformador);
    private ServicioClasificador servicioClasificador;

    @Mock
    private IHumanoRepositorio humanoRepositorio;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ServicioClasificador servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);

    }

    @Test
    void esMutanteSinRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnMutante))).thenReturn(false);

        servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
        response = servicioClasificador.procesarAdn(adnMutante);

        assertEquals(true, response.esMutante());

    }

    @Test
    void esMutanteConRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnMutante))).thenReturn(true);

        try{
            servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
            response = servicioClasificador.procesarAdn(adnMutante);
        }catch(ExcepcionMutante excepcionMutante) {
            assertEquals("El adn ya existe.", excepcionMutante.getMensajeError());
        }
    }

    @Test
    void noEsMutanteSinRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnNoMutante))).thenReturn(false);

        servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
        response = servicioClasificador.procesarAdn(adnNoMutante);

        assertEquals(false, response.esMutante());
    }


}