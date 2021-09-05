package com.co.PruebaMeli.repositorio;

import com.co.PruebaMeli.entidades.EntidadHumano;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IHumanoRepositorio extends JpaRepository<EntidadHumano, String> {

     //boolean existeAdn(String adn);
}
