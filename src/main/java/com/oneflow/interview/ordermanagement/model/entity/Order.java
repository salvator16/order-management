package com.oneflow.interview.ordermanagement.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * @author - ahmet
 */
@Document("order")
public class Order extends BaseEntity{

    @NotNull
    private Long productId;
    @NotNull
    private String username;
    @NotNull
    private String address;

    public Order() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
