package com.oneflow.interview.ordermanagement.service;

import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.ProductResponse;
import com.oneflow.interview.ordermanagement.model.entity.Product;
import com.oneflow.interview.ordermanagement.repository.ProductRepository;
import com.oneflow.interview.ordermanagement.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author - ahmet
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductValidation productValidation;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductValidation productValidation) {
        this.productRepository = productRepository;
        this.productValidation = productValidation;
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findByProductId(productId);
    }



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Long productId) {
        Product product = findById(productId);
        productValidation.validateProductExist(product);
        productValidation.validateProductStockCount(product);
        decreaseStockCount(product);
        return productRepository.save(product);
    }

    @Override
    public Product save(Long productId, ProductCreateRequest productCreateRequest) {
        productValidation.validateProductIdExist(productId);
        productValidation.validateProductSave(productCreateRequest);
        return productRepository.save(transformToProduct(productId, productCreateRequest));
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = findById(productId);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setStockCount(product.getStockCount());
        return productResponse;
    }

    private Product transformToProduct(Long productId, ProductCreateRequest productCreateRequest){
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setProductId(productId);
        product.setProductName(productCreateRequest.getProductName());
        product.setStockCount(productCreateRequest.getStockCount());
        return product;
    }

    private void decreaseStockCount(Product product) {
        int stockCount = product.getStockCount();
        product.setStockCount(stockCount - 1);
    }
}
