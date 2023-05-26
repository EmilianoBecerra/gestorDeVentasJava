package com.ejercicio.bazar.controller;

import com.ejercicio.bazar.model.Sale;
import com.ejercicio.bazar.service.ISaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")
public class SaleController {
    
    @Autowired
    private ISaleService saleServ;
    
    @GetMapping("/")
    public List<Sale> getSales(){
        
        List<Sale> listSale = saleServ.getSales();
        
        return listSale;
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Sale getSale(@PathVariable Long id){
        return saleServ.getSale(id);
    }
    
    @GetMapping("/dia/{date}")
    public List<Sale> getSaleForDay(@PathVariable String date){
        List<Sale> listSaleForDay = saleServ.salesForDay(date);
        
                
        return listSaleForDay;
       
    }
    
    @PostMapping("/agregar")
    public String addSale(@RequestBody Sale sale){
        sale.setTotal(sale.sumTotal());
        saleServ.addSale(sale);
        return "Se creó una nueva venta con el código ";
    }
       
    @PutMapping("/editar")
    public String editSale(Sale sale){
         saleServ.editSale(sale);
         return "Se modificó la venta con el código : " + sale.getSaleCode();
    }
        
    @DeleteMapping("/borrar/{id}")
    public String deleteSale(@PathVariable Long id){
        saleServ.deleteSale(id);
        return "Se eliminó correctamente la venta";
    }
    
    
}
