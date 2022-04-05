package com.xaghoul.catalogapp.mapper;


import com.xaghoul.catalogapp.entity.ProductEntity;
import dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDTO productDTO);

    ProductDTO toModel(ProductEntity productEntity);
}
