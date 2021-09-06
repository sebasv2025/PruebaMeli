package com.co.PruebaMeli.services;

import com.co.PruebaMeli.modelo.ClasificadorAdn;
import com.co.PruebaMeli.modelo.Transformador;
import com.co.PruebaMeli.repositorio.IHumanoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
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

        assertEquals(HttpStatus.OK, response.obtenerEstado());

    }

    @Test
    void esMutanteConRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnMutante))).thenReturn(true);

        servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
        response = servicioClasificador.procesarAdn(adnMutante);

        assertEquals(HttpStatus.OK, response.obtenerEstado());
    }


    @Test
    void noEsMutanteSinRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnNoMutante))).thenReturn(false);

        servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
        response = servicioClasificador.procesarAdn(adnNoMutante);

        assertEquals(HttpStatus.FORBIDDEN, response.obtenerEstado());
    }

    @Test
    void noEsMutanteConRegistroEnBaseDeDatos() {

        when(humanoRepositorio.existsById(transformador.unificarCadenaAdn(adnNoMutante))).thenReturn(true);

        servicioClasificador = new ServicioClasificador(clasificadorAdn, humanoRepositorio, transformador);
        response = servicioClasificador.procesarAdn(adnNoMutante);

        assertEquals(HttpStatus.FORBIDDEN, response.obtenerEstado());
    }

}