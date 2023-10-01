package com.products.apirest.services;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repo;

    public List<ProductsModel> findByMarca(String marca) {
        return repo.findByMarca(marca);
    }
    public List<ProductsModel> findAll(){
        return repo.findAll();
    }
    public List<ProductsModel> findByCategoria(String categoria){
        return repo.findByCategoria(categoria);
    }
    public Optional<ProductsModel> findById(UUID id){
       return repo.findById(id);
    }
    public ProductsModel save(ProductsModel productsModel){
        return repo.save(productsModel);
    }
    public void delete(String marca){
        repo.deleteByMarca(marca);
    }

}
