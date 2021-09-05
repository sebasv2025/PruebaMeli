package com.co.PruebaMeli;

import com.co.PruebaMeli.models.Humano;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionPruebaMeli {

	public Humano humano = new Humano("AASDADS", false);


	public static void main(String[] args) {
		SpringApplication.run(AplicacionPruebaMeli.class, args);
	}

}
