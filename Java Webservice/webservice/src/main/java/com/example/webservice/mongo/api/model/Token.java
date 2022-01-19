package com.example.webservice.mongo.api.model;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Token")
public class Token 
{
    @Id
    private int id;
    private String token;

    public String getToken()
    {
        return token;
    }

    public int getId()
    {
        return id;
    }

}
