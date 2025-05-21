package com.olawale.ProductService.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(
        name = "PRODUCT_LIBRARY"
)
public class Product {
    @Id
    @Column(
            name = "COL_PRODUCT_ID",
            unique = true
    )
    private Long productId;
    @Column(
            name = "COL_PRODUCT_TITLE"
    )
    private String productTitle;
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @Column(
            name = "COL_YEAR"
    )
    private LocalDate year;
    @Column(
            name = "COL_PRICE"
    )
    private String productPrice;

    public Product() {
    }

    @Generated
    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    @Generated
    public void setProductTitle(final String productTitle) {
        this.productTitle = productTitle;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @Generated
    public void setYear(final LocalDate year) {
        this.year = year;
    }

    @Generated
    public void setProductPrice(final String productPrice) {
        this.productPrice = productPrice;
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
    public LocalDate getYear() {
        return this.year;
    }

    @Generated
    public String getProductPrice() {
        return this.productPrice;
    }
}
