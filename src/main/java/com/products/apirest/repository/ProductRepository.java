package com.products.apirest.repository;

import com.products.apirest.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, UUID> {
    Optional<ProductsModel> findById(UUID id);

    void deleteById(UUID id);
    @Modifying
    @Query("DELETE FROM ProductsModel p WHERE p.marca = :marca")
    List<ProductsModel> search(@Param("marca") String marca);

    void deleteByMarca(String marca);


}
