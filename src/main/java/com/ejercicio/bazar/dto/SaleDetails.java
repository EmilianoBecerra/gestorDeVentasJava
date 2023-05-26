package com.ejercicio.bazar.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class SaleDetails {
   
    private Long idClient;
    private Long idProduct;
    private double coste;
    private int quantityProduct;
    private double total;

    public SaleDetails() {
    }

    public SaleDetails(Long idClient, Long idProduct, double coste, int quantityProduct, double total) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.coste = coste;
        this.quantityProduct = quantityProduct;
        this.total = total;
    }
}
