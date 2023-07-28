package com.products.apirest.services;

import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    final ProductRepository repo;

    public ProductServices(ProductRepository repo) {
        this.repo = repo;
    }

}
