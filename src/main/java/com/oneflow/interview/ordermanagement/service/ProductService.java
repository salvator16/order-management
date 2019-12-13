package com.oneflow.interview.ordermanagement.service;

import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.ProductResponse;
import com.oneflow.interview.ordermanagement.model.entity.Product;

import java.util.List;

/**
 * @author - ahmet
 */

public interface ProductService {

    Product save(Long productId, ProductCreateRequest productCreateRequest);

    Product findById(Long productId);

    ProductResponse getProductById(Long productId);

    List<Product> findAll();

    Product update(Long productId);

}
