package com.co.PruebaMeli.services;

import org.springframework.stereotype.Component;

@Component
public interface IServicioClasificador {
    Response procesarAdn(String[] adn);
}
