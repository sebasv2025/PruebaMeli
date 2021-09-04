package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.repositorio;

import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.Humano;
import org.springframework.stereotype.Component;

@Component
public class Repositorio implements IRepositorio {
    @Override
    public boolean hayRegistros(String adn) {
        return false;
    }

    @Override
    public void insertar(Humano humano) {

    }
}
