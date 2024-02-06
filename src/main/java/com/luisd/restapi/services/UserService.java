package com.luisd.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luisd.restapi.domain.UserDomain;
import com.luisd.restapi.repositories.UserRepository;
import com.luisd.restapi.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDomain findById(Integer id) {
        Optional<UserDomain> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", type: " + UserDomain.class.getName()));
    }

    public List<UserDomain> findAll() {
       return userRepository.findAll();
    }

    public UserDomain update(Integer id, UserDomain obj) {
        UserDomain newUser = findById(id);
        newUser.setName(obj.getName());
        newUser.setLogin(obj.getLogin());
        newUser.setPassword(obj.getPassword());
        return userRepository.save(newUser);   
    }

    public UserDomain create(UserDomain obj) {
        obj.setId(null);
        return userRepository.save(obj);
    }
}
