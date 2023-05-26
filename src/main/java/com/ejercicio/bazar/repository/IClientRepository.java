package com.ejercicio.bazar.repository;

import com.ejercicio.bazar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{
    
}
