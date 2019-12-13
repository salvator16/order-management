package com.oneflow.interview.ordermanagement.validation;

import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.entity.Product;

/**
 * @author - ahmet
 */

public interface ProductValidation {

    void validateProductSave(ProductCreateRequest productCreateRequest);

    void validateProductIdExist(Long productId);

    void validateProductStockCount(Product product);

    void validateProductExist(Product product);


}
