package com.products.apirest.resources;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.services.ProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/airlonTest")
@Api(value = "testAir")
public class ProductsResources {

    @Autowired
    private ProductServices services;

    @GetMapping("/Search")
    @ApiOperation(value="search name")
    public List<ProductsModel> search(@RequestParam String marca){
        return services.search(marca);
    }

    @GetMapping("/Products")
    @ApiOperation(value="return all products")
    public List<ProductsModel> listProducts(){
        return services.findAll();
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
