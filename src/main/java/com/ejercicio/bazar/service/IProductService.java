package com.ejercicio.bazar.service;

import com.ejercicio.bazar.model.Product;
import java.util.List;


public interface IProductService {
    
    public void addProduct(Product product);
    
    public List<Product> getProducts();
    
    public Product getProduct(Long id);
    
    public void editProduct(Product product);
    
    public void deleteProduct(Long id);
    
    public void modifyCosts(double newCoste);
    
    public List<Product> stockAvailable(int quantity);
    
}
