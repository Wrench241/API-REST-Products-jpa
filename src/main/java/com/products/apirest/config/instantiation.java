package com.products.apirest.config;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {
    final ProductRepository repository;

    public instantiation(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        ProductsModel p1 = new ProductsModel(null, "notebook","samsung");
        ProductsModel p2 = new ProductsModel(null, "notebook","dell");

        repository.saveAll(Arrays.asList(p1,p2));


    }
}
