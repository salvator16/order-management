package com.oneflow.interview.ordermanagement.model.dto.response;

import com.oneflow.interview.ordermanagement.model.entity.Product;

/**
 * @author - ahmet
 */

public class OrderResponse {

    private Long productId;
    private String username;
    private String address;

    public OrderResponse() {}

    public OrderResponse(Long productId, String username, String address) {
        this.productId = productId;
        this.username = username;
        this.address = address;
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
