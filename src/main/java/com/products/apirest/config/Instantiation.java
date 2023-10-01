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
      //  ProductsModel p1 = new ProductsModel(null, "apple","celular",343.4);
       // ProductsModel p2 = new ProductsModel(null, "samsung","notebook",21.23);
        // ProductsModel p3 = new ProductsModel(null,"nokia","celular",323.23);

        //repository.saveAll(Arrays.asList(p1,p2,p3));


    }
}
