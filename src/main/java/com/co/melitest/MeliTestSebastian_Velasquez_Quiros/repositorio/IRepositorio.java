package com.co.melitest.MeliTestSebastian_Velasquez_Quiros.repositorio;


import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.Humano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorio //extends JpaRepository<Humano, String>
 {

    public boolean hayRegistros(String adn);

    public void insertar(Humano humano);

}
