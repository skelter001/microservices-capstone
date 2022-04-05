package com.xaghoul.catalogapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity {

    @Id
    private String uniqId;
    private String sku;
    private String nameTitle;
    private String description;
    private Double listPrice;
    private Double salePrice;
    private String category;
    private String categoryTree;
    private String averageProductPrice;
    private String productUrl;
}
