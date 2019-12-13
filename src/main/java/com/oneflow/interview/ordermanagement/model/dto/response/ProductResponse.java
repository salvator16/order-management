package com.oneflow.interview.ordermanagement.model.dto.response;

import java.util.Objects;

/**
 * @author - ahmet
 */

public class ProductResponse {

    private Long productId;
    private String productName;
    private Integer stockCount;

    public String getProductName() {
        return productName;
    }

    public ProductResponse() {}

    public ProductResponse(Long productId, String productName, Integer stockCount) {
        this.productId = productId;
        this.productName = productName;
        this.stockCount = stockCount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductResponse)) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(getProductId(), that.getProductId()) &&
                Objects.equals(getProductName(), that.getProductName()) &&
                Objects.equals(getStockCount(), that.getStockCount());
    }

}
