package com.co.PruebaMeli.controladores;


import com.co.PruebaMeli.services.IServicioClasificador;
import com.co.PruebaMeli.services.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControladorPrincipal {

    private IServicioClasificador clasificador;

    @Autowired
    public ControladorPrincipal(IServicioClasificador clasificador){
        this.clasificador = clasificador;
    }

    @PostMapping("/mutant")
    public ResponseEntity<Response> postMutant(@RequestParam String[] dna) {

        Response response = clasificador.procesarAdn(dna);
        return new ResponseEntity<>(response, response.obtenerEstado());
    }

}
