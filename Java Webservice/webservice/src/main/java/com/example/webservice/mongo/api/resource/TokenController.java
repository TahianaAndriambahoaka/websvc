package com.example.webservice.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import com.example.webservice.mongo.api.model.Token;
import com.example.webservice.mongo.api.repository.TokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController 
{
    @Autowired
    private TokenRepository repository;
    
    @PostMapping("addToken")
    public String saveToken(@RequestBody Token token)
    {
        repository.save(token);
        return "Added Token with id: "+token.getId();
    }

    @GetMapping("/'findAllToken")
    public List<Token> getToken()
    {
        return repository.findAll();
    }

    @GetMapping("/findAllTokens/{id}")
    public Optional<Token> getToken(@PathVariable int id)
    {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteToken(@PathVariable int id)
    {
        repository.deleteById(id);
        return "Token deleted with id: "+id;
    }


}
