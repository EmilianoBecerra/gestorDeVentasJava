package com.ejercicio.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    private String name;
    private String brand;
    private double coste;
    private int stock;
        
    @ManyToMany(mappedBy="products")
    @JsonIgnoreProperties(value="products")
    private List<Sale> sales;
       
    
    public Product() {
    }

    public Product(Long productCode, String name, String brand, double coste, int stock, List<Sale> sales, Long quantity) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.coste = coste;
        this.stock = stock;
        this.sales = sales;
    }
}
