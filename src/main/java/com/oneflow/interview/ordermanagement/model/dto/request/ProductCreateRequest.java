package com.oneflow.interview.ordermanagement.model.dto.request;

/**
 * @author - ahmet
 */

public class ProductCreateRequest {

    private String productName;
    private Integer stockCount;

    public ProductCreateRequest() {}

    public ProductCreateRequest(String productName, Integer stockCount) {
        this.productName = productName;
        this.stockCount = stockCount;
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
}
