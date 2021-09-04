package com.co.melitest.MeliTestSebastian_Velasquez_Quiros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.co.melitest.MeliTestSebastian_Velasquez_Quiros.models.Humano;

@SpringBootApplication
public class MeliTestSebastianVelasquezQuirosApplication {

	public Humano Humano = new Humano("AASDADS", false);


	public static void main(String[] args) {
		SpringApplication.run(MeliTestSebastianVelasquezQuirosApplication.class, args);
	}

}
