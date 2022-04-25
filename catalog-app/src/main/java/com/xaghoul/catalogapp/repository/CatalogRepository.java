package com.xaghoul.catalogapp.repository;

import com.xaghoul.catalogapp.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends CrudRepository<ProductEntity, String> {

    List<ProductEntity> findAllBySku(String sku);

    boolean existsBySku(String sku);
}
