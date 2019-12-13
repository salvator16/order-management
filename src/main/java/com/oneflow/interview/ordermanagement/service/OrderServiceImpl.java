package com.oneflow.interview.ordermanagement.service;

import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;
import com.oneflow.interview.ordermanagement.model.entity.Order;
import com.oneflow.interview.ordermanagement.repository.OrderRepository;
import com.oneflow.interview.ordermanagement.validation.OrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author - ahmet
 */

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderValidation orderValidation;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderValidation orderValidation, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderValidation = orderValidation;
        this.productService = productService;
    }

    @Override
    public Order save(OrderCreateRequest orderCreateRequest) {
        orderValidation.validateOrderSave(orderCreateRequest);
        productService.update(orderCreateRequest.getProductId());
        return orderRepository.save(transformToOrder(orderCreateRequest));
    }

    @Override
    public List<Order> findByUsernameOrders(String username) {
        return orderRepository.findByUsername(username);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    private Order transformToOrder(OrderCreateRequest orderCreateRequest){
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setProductId(orderCreateRequest.getProductId());
        order.setUsername(orderCreateRequest.getUsername());
        order.setAddress(orderCreateRequest.getAddress());
        return order;
    }

}
