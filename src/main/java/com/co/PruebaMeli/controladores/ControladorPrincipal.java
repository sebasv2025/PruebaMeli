package com.co.PruebaMeli.controladores;


import com.co.PruebaMeli.repositorio.IHumanoRepositorio;
import com.co.PruebaMeli.services.IServicioClasificador;
import com.co.PruebaMeli.services.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorPrincipal {

    private IServicioClasificador clasificador;

    @Autowired
    public ControladorPrincipal(IServicioClasificador clasificador){
        this.clasificador = clasificador;
    }

    @RequestMapping(value = "/mutante", method = RequestMethod.POST, consumes = "application/json", headers = "Accept=application/json")
    public boolean postMutantes(@RequestBody String[] adn) {

        Response response = clasificador.procesarAdn(adn);
        return response.esMutante();
    }

}
