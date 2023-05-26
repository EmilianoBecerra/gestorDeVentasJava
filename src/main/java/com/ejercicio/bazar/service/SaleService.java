
package com.ejercicio.bazar.service;


import com.ejercicio.bazar.model.Sale;
import com.ejercicio.bazar.repository.ISaleRepository;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepo;

    @Override
    public void addSale(Sale sale) {
        saleRepo.save(sale);
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> listSale = saleRepo.findAll();
        return listSale;
    }

    @Override
    public Sale getSale(Long id) {
        Sale sale = saleRepo.findById(id).orElse(null);
        return sale;
    }

    @Override
    public void editSale(Sale sale) {
        this.addSale(sale);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepo.deleteById(id);
    }

    @Override
    public List<Sale> salesForDay(String date) {
               
        List<Sale> listSale = saleRepo.findAll();
        List<Sale> saleForDay = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        
        for(Sale sale: listSale){
            String formattedString = sale.getSaleDate().format(formatter);
            if(formattedString.equals(date)){
                saleForDay.add(sale);
            }
            
        }
        
        return saleForDay;
        

    }
    
}
