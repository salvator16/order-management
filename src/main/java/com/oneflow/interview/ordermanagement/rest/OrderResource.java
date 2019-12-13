package com.oneflow.interview.ordermanagement.rest;

import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.OrderResponse;
import com.oneflow.interview.ordermanagement.model.entity.Order;
import com.oneflow.interview.ordermanagement.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author - ahmet
 */
@RestController
@RequestMapping("/order")
public class OrderResource {

    private static final Logger log = LogManager.getLogger(OrderResource.class);

    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/find/{username}" , produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Order>> getOrderByUsername(@PathVariable("username") final String username) {
        return ResponseEntity.ok(orderService.findByUsernameOrders(username));
    }

    @GetMapping(value = "/list" , produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Order>> getAllProducts() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody final OrderCreateRequest orderCreateRequest) {
        log.info("Order infos : ", orderCreateRequest.getUsername()," ", orderCreateRequest.getAddress());
        return getOrderSaveResponse(orderCreateRequest);
    }

    private ResponseEntity<OrderResponse> getOrderSaveResponse(OrderCreateRequest orderCreateRequest) {
        Order order = orderService.save(orderCreateRequest);
        OrderResponse orderResponse = new OrderResponse(order.getProductId(),order.getUsername(),order.getAddress());
        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(orderResponse.getProductId())
                        .toUri();
        return ResponseEntity.created(uri).body(orderResponse);
    }

}
