package com.products.apirest.model;

import java.io.Serializable;
import java.util.UUID;

public class ProductCreatedEvent implements Serializable {
    private UUID productId;
    private String marcaProduct;
    private String categoriaProduct;

    public ProductCreatedEvent(UUID productId, String marcaProduct, String categoriaProduct){
        this.productId = productId;
        this.marcaProduct = marcaProduct;
        this.categoriaProduct = categoriaProduct;
    }
    public UUID getProductId() {
        return productId;
    }
    public String getMarcaProduct() {
        return marcaProduct;
    }
    public String getCategoriaProduct(){
        return categoriaProduct;
    }
}
