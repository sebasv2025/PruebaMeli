package com.co.PruebaMeli.repositorio;

import com.co.PruebaMeli.modeloBD.HumanoBD;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IHumanoBD extends JpaRepository<HumanoBD, String> {

    //public boolean hayRegistros(String adn);
}
