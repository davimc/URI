package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.entities.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers ON products.id_providers = providers.id " +
            "WHERE products.amount BETWEEN :min AND :max " +
            "AND providers.name LIKE CONCAT(:beginName,'%')")
    public List<ProductMinProjection> search1(int min, int max, String beginName);

    @Query("SELECT new com.devsuperior.uri2621.entities.dto.ProductMinDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount BETWEEN :min AND :max " +
            "AND obj.provider.name LIKE CONCAT(:beginName,'%')")
    public List<ProductMinDTO> search2(int min, int max, String beginName);
}
