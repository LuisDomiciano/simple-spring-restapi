package com.luisd.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisd.restapi.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Integer>{
    
}
