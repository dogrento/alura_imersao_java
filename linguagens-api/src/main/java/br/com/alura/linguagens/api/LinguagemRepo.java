package br.com.alura.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepo extends MongoRepository <Linguagem, String> {
    
}
