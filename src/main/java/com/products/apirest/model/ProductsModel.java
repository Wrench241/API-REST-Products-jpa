package com.products.apirest.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb-product")
public class ProductsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private String products;
    private String nameProducts;

    public ProductsModel(){

    }

    public ProductsModel(UUID id, String products, String nameProducts) {
        this.id = id;
        this.products = products;
        this.nameProducts = nameProducts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }
}