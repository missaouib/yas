package com.yas.search.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


@Document(indexName = "product")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseDocument {
    @Id
    private Long id;

    private String name;

    private String slug;

    private Double price;

    private Boolean isPublished;

    private Boolean isVisibleIndividually;

    private Long thumbnailMediaId;

    protected Boolean isActive;

    @Field(type = FieldType.Object)
    private Brand brand;

    @Field(type = FieldType.Nested)
    private List<ProductCategory> productCategories;

    @Field(type = FieldType.Nested)
    private List<ProductAttributeValue> attributeValues;
}