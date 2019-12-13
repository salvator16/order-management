package com.oneflow.interview.ordermanagement.service;

import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;
import com.oneflow.interview.ordermanagement.model.entity.Order;

import java.util.List;

/**
 * @author - ahmet
 */

public interface OrderService {

    Order save(OrderCreateRequest orderCreateRequest);

    List<Order> findByUsernameOrders(String username);

    List<Order> findAll();

}
