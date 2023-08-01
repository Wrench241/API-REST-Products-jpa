package com.products.apirest.config;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        ProductsModel p1 = new ProductsModel(null, "notebook","samsung");
        ProductsModel p2 = new ProductsModel(null, "notebook","dell");

        repository.saveAll(Arrays.asList(p1,p2));


    }
}
