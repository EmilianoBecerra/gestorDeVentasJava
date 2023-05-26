package com.ejercicio.bazar.controller;

import com.ejercicio.bazar.model.Product;
import com.ejercicio.bazar.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
    @Autowired
    private IProductService productServ;
    
    @GetMapping("/")
    public List<Product> getProducts(){
        List<Product> listProduct = productServ.getProducts();
        return listProduct;
    }
    
    @GetMapping("")
    public List<Product> getStockProducts(@RequestParam int quantity){
        List<Product> productsStock = productServ.stockAvailable(quantity);
        return productsStock;
    }
        
    @PostMapping("/agregar")
    public String addProduct(@RequestBody Product product){
        productServ.addProduct(product);
        return "Se creó un producto con el código" + " " +  product.getProductCode();
    }
    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        Product product = productServ.getProduct(id);
        return product;
    }
    
    
    @PutMapping("/editar")
    public String editProduct(@RequestBody Product product){
        productServ.editProduct(product);
        return "Se creó un nuevo producto con el código " + product.getProductCode();
    }
    
    @PutMapping("/modificarCostos")
    public String modifyCosts(@RequestParam double porcentaje){
        productServ.modifyCosts(porcentaje);
        return "Se aumentó un " + (porcentaje * 100) + " % Los costos";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteProduct(@PathVariable Long id){
        
        productServ.deleteProduct(id);
        
        return "Se eliminó correctamente el producto";
    }
            
    
}
