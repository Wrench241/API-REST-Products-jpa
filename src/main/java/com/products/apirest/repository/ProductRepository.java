package com.products.apirest.repository;

import com.products.apirest.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, UUID> {

    List<ProductsModel> findByMarca(String marca);

    List<ProductsModel> findByCategoria(String categoria);

    void deleteByMarca(String marca);


}
