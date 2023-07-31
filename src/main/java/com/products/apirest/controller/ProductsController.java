package com.products.apirest.controller;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
@Api(value = "API REST Products")
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/Products")
    @ApiOperation(value="return all products")
    public List<ProductsModel> listProducts(){
        return repository.findAll();
    }

    @GetMapping(value = "/Products/{id}")
    @ApiOperation(value="search and return a id")
    public Optional<ProductsModel> SearchId(@PathVariable(value ="id") UUID id){
        return repository.findById(id);
    }

    @PostMapping(value = "/Products")
    @ApiOperation(value="add a product")
    public ProductsModel Insert(@RequestBody ProductsModel productsModel){
        return repository.save(productsModel);

    }

    @DeleteMapping(value = "/Products")
    @ApiOperation(value="delete a product")
    public void delete(@RequestBody ProductsModel productsModel){
        repository.delete(productsModel);
    }

    @PutMapping("/Products")
    @ApiOperation(value="update a product")
    public ProductsModel update(@RequestBody ProductsModel productsModel){
        return repository.save(productsModel);
    }


}
