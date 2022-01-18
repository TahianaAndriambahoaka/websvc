package com.example.webservice.controller;

//import com.example.webservice.message.response.JwtResponse;
import com.example.webservice.model.User;
import com.example.webservice.security.jwt.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRestAPIs 
{

	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
    JwtProvider jwtProvider;
	
	/*@Autowired
    private UserRepository userRepository;*/

	@GetMapping("/api/test/user")
	public ResponseEntity<?> userAccess() 
    {
		User u = new User("coucou","ca va");
        return ResponseEntity.ok(u);
	}

}