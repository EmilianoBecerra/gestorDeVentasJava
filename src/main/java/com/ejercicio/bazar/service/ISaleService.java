package com.ejercicio.bazar.service;

import com.ejercicio.bazar.model.Sale;
import java.util.List;


public interface ISaleService {
    
    public void addSale(Sale sale);
    
    public List<Sale> getSales();
    
    public Sale getSale(Long id);
    
    public void editSale(Sale sale);
    
    public void deleteSale(Long id);
    
    public List<Sale> salesForDay(String date);
    
    
    
    
    
    
    
}
