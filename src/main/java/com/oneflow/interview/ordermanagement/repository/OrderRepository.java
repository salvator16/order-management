package com.oneflow.interview.ordermanagement.repository;

import com.oneflow.interview.ordermanagement.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author - ahmet
 */

public interface OrderRepository extends MongoRepository<Order, UUID> {

    /**
     * database method which return data filtered by username
     * @param  username name for product
     * @return {@link  Order}  data filter by productName
     */
    List<Order> findByUsername(String username);


}
