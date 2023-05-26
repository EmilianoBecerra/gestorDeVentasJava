package com.ejercicio.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String name;
    private String lastName;
    private String dni;    
    
    @OneToMany(mappedBy="oneClient")
    @JsonIgnoreProperties(value="client")
    List<Sale> saleList;

    public Client() {
    }

    public Client(Long idClient, String name, String lastName, String dni) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }
    
    
}
