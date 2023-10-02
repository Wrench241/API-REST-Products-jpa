package com.products.apirest.services;

import com.products.apirest.model.ProductCreatedEvent;
import com.products.apirest.model.ProductsModel;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repo;

    @Autowired
    private EventProducer eventProducer;

    public ProductsModel saveStatus(ProductsModel productsModel){
        return repo.save(productsModel);
    }
    public ProductsModel save(ProductsModel productsModel) {
        // Configurar o status como "ativo"
        productsModel.setStatus("ativo");

        // Salvar o produto no banco de dados
        ProductsModel savedProduct = repo.save(productsModel);

        // Publicar o evento de criação do produto após o salvamento bem-sucedido
        ProductCreatedEvent event = new ProductCreatedEvent(savedProduct.getId(), savedProduct.getMarca(), savedProduct.getCategoria());
        eventProducer.createEvent(event);

        // Retornar o produto salvo
        return savedProduct;
    }

    public List<ProductsModel> findByMarca(String marca) {
        return repo.findByMarcaAndStatus(marca, "ativo");
    }
    public List<ProductsModel> findAll(){
        return repo.findByStatus("ativo");
    }
    public List<ProductsModel> findByCategoria(String categoria){
        return repo.findByCategoriaAndStatus(categoria, "ativo");
    }
    public Optional<ProductsModel> findById(UUID id){
       return repo.findById(id);
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }


}
