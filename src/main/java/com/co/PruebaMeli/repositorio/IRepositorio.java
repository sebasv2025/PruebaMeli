package com.co.PruebaMeli.repositorio;


import com.co.PruebaMeli.models.Humano;

public interface IRepositorio //extends JpaRepository<Humano, String>
 {

    public boolean hayRegistros(String adn);

    public void insertar(Humano humano);

}
