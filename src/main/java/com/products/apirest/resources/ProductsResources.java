package com.products.apirest.resources;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.services.ProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/airlonTest")
@Api(value = "testAir")
public class ProductsResources {

    @Autowired
    private ProductServices services;

    @GetMapping("/searchMarca")
    @ApiOperation(value="search name")
    public List<ProductsModel> search(@RequestParam String marca){
        return services.findByMarca(marca);
    }
    @PostMapping("/Status/{id}")
    public ResponseEntity<String> status(@PathVariable UUID id, @RequestBody ProductsModel productUpdate){
        ProductsModel productExist = services.findById(id).orElse(null);

        if(productExist == null){
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }

        if(productUpdate.getStatus() != null){
            productExist.setStatus(productUpdate.getStatus());
        }

        services.saveStatus(productExist);
        return new ResponseEntity<>("Status do produto atualizado.", HttpStatus.OK);
    }
    @GetMapping("/Products/{id}")
    public Optional<ProductsModel> findById(@PathVariable(value="id") UUID id){
        return services.findById(id);
    }

    @GetMapping("/searchCategoria")
    public List<ProductsModel> searchCategoria(@RequestParam String categoria){
        return services.findByCategoria(categoria);
    }

    @GetMapping("/Products")
    @ApiOperation(value="return all products")
    public List<ProductsModel> listProducts(String status){
        return services.findAll(status);
    }

    @PostMapping(value = "/Products")
    @ApiOperation(value="add a product")
    public ProductsModel Insert(@RequestBody ProductsModel productsModel){
        return services.save(productsModel);

    }
    @DeleteMapping(value = "/Products")
    @ApiOperation(value="delete a product")
    public void delete(String marca){
        services.delete(marca);
    }

    @PutMapping("/Products")
    @ApiOperation(value="update a product")
    public ProductsModel update(@RequestBody ProductsModel productsModel){
        return services.save(productsModel);
    }


}
