package com.luisd.restapi.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luisd.restapi.domain.UserDomain;
import com.luisd.restapi.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDomain findById(Integer id) {
        Optional<UserDomain> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}
