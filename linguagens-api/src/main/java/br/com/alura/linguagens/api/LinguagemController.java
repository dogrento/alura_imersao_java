package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Term;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LinguagemController {

    @Autowired
    private LinguagemRepo repo;

    @GetMapping("/")
    public String homePage(){

        String test = "seu merda";
        return test;
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){

        List<Linguagem> linguagens = repo.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repo.save(linguagem);
        return linguagemSalva;
    }
}
