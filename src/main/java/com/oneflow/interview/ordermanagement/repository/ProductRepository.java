package com.oneflow.interview.ordermanagement.repository;

import com.oneflow.interview.ordermanagement.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface to do database operation on MongoDB  via Spring MongoDB JPA.
 * @author - ahmet
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, UUID> {

    /**
     * database method which return data filtered by productName
     * @param  productName name for product
     * @return {@link  Product}  data filter by productName
     */
    Product findByProductName(String productName);

    /**
     * database method which return data filtered by productName
     * @param  productId name for product
     * @return {@link  Product}  data filter by productId
     */
    Product findByProductId(Long productId);

}
