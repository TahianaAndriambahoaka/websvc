package com.example.webservice.mongo.api.repository;

import com.example.webservice.mongo.api.model.Token;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<Token,Integer>{ }
