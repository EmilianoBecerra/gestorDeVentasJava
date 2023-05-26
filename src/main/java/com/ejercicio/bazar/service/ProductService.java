
package com.ejercicio.bazar.service;

import com.ejercicio.bazar.model.Product;
import com.ejercicio.bazar.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepo;

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> listProducts =  productRepo.findAll();
        return listProducts;
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepo.findById(id).orElse(null);
        return product;
    }

    @Override
    public void editProduct(Product product) {
        this.addProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> stockAvailable(int quantity) {
        List<Product> listProduct = this.getProducts();
        List<Product> listMinStock = new ArrayList<>();
        for(Product product : listProduct){
            if(product.getStock() == quantity || product.getStock()<quantity ){
                listMinStock.add(product);
            }
        }
        
        return listMinStock;
    }

    @Override
    public void modifyCosts(double newCoste) {
        List<Product> listProduct = this.getProducts();
        
        for(Product product: listProduct){
            
            product.setCoste(product.getCoste()* newCoste + product.getCoste());
            this.addProduct(product);
        }
    }
    

}
