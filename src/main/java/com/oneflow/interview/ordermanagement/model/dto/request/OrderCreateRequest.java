package com.oneflow.interview.ordermanagement.model.dto.request;

/**
 * @author - ahmet
 */

public class OrderCreateRequest {

    private Long productId;
    private String username;
    private String address;

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
