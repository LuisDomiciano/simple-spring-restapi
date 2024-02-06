package com.luisd.restapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisd.restapi.domain.UserDomain;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDomain> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body( new UserDomain());
    }
}
