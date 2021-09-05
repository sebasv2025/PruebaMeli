package com.co.PruebaMeli.controllers;


import com.co.PruebaMeli.modeloBD.HumanoBD;
import com.co.PruebaMeli.models.Greeting;
import com.co.PruebaMeli.repositorio.IHumanoBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IHumanoBD repo;




    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {


        HumanoBD humanoBD = new HumanoBD("ADN", false);
        repo.save(humanoBD);



        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }

    @PostMapping("/mutant")
    public int postMutante(String dna){
        return  1;
    }




}
