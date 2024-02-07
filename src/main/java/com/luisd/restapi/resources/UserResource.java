package com.luisd.restapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luisd.restapi.domain.UserDomain;
import com.luisd.restapi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    private final UserService userService;
    
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDomain> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(this.userService.findById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<UserDomain>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDomain> update(@PathVariable Integer id, @RequestBody UserDomain obj) {
        UserDomain newUser = userService.update(id, obj);
        return ResponseEntity.ok().body(newUser);
    }

    @PostMapping
    public ResponseEntity<UserDomain> create(@RequestBody UserDomain obj) {
        UserDomain newUser = userService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
