package com.products.apirest.repository;

import com.products.apirest.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, UUID> {

    List<ProductsModel> findByMarcaAndStatus(String marca, String status);
    Optional<ProductsModel> findById(UUID id);

    List<ProductsModel> findByCategoriaAndStatus(String categoria, String status);


    List<ProductsModel> findByStatus(String status);


}
