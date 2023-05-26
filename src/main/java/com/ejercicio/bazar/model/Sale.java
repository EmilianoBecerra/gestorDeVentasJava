package com.ejercicio.bazar.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Sale {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleCode;
    private LocalDate saleDate = LocalDate.now();
    private double total;
    
    @ManyToMany
    @JoinTable(name = "listSales", joinColumns=@JoinColumn(name="sale_code", nullable = false), inverseJoinColumns=@JoinColumn(name="products_code", nullable=false))
    @JsonIgnoreProperties(value="sales")
    private List<Product> products;
        
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @JsonIgnoreProperties(value="saleList")
    private Client oneClient;

    public Sale() {
    }

    public Sale(Long saleCode, double total, List<Product> products, Client oneClient) {
        this.saleCode = saleCode;
        this.total = total;
        this.products = products;
        this.oneClient = oneClient;
    }
    
    public double sumTotal(){
     
        for(Product product : products ){
            total+= product.getCoste();
        }
        return total;
    }
}
