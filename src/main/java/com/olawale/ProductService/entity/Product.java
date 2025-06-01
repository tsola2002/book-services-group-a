package com.olawale.ProductService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;

@Entity
@Table(name = "PRODUCT_LIBRARY")
public class Product {
    @Id
    @Column(name = "COL_PRODUCT_ID", unique = true)
    private Long productId;

    @Column(name = "COL_PRODUCT_TITLE")
    private String productTitle;

    @Column(name = "COL_DESCRIPTION")
    private String productDescription;

    @Column(name = "COL_AUTHOR")
    private String productAuthor;

    public Product() {}

    @Generated
    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    @Generated
    public void setProductTitle(final String productTitle) {
        this.productTitle = productTitle;
    }

    @Generated
    public void setProductDescription(final String productDescription) {
        this.productDescription = productDescription;
    }

    @Generated
    public void setProductAuthor(final String productAuthor) {
        this.productAuthor = productAuthor;
    }

    @Generated
    public Long getProductId() {
        return this.productId;
    }

    @Generated
    public String getProductTitle() {
        return this.productTitle;
    }

    @Generated
    public String getProductDescription() {
        return this.productDescription;
    }

    @Generated
    public String getProductAuthor() {
        return this.productAuthor;
    }
}
