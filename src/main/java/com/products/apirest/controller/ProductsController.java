package com.products.apirest.controller;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/Products")
    public List<ProductsModel> listProducts(){
        return repository.findAll();
    }

    @GetMapping(value = "/Products/{id}")
    public Optional<ProductsModel> SearchId(@PathVariable(value ="id") UUID id){
        return repository.findById(id);
    }

    @PostMapping(value = "/Products")
    public ProductsModel Insert(@RequestBody ProductsModel productsModel){
        return repository.save(productsModel);

    }

    @DeleteMapping(value = "/Products")
    public void delete(@RequestBody ProductsModel productsModel){
        repository.delete(productsModel);
    }

    @PutMapping("/Products")
    public ProductsModel update(@RequestBody ProductsModel productsModel){
        return repository.save(productsModel);
    }


}
