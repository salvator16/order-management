package com.oneflow.interview.ordermanagement.model.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author - ahmet
 */

@Document("product")
public class Product extends BaseEntity{

    @NotNull
    @Indexed(name = "product_id_index")
    private Long productId;

    private String productName;
    private Integer stockCount;

    public Product() {
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return getProductId().equals(product.getProductId()) &&
                getProductName() == product.getProductName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(),getProductName());
    }

}
