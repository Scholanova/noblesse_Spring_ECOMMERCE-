package com.scholanova.ecommerce.order.controller;

import com.scholanova.ecommerce.order.entity.Orders;
import com.scholanova.ecommerce.order.repository.OrderRepository;
import com.scholanova.ecommerce.order.service.OrderService;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/carts")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") Orders order) { return order;}

    @PostMapping
    public Orders createOrder() { return orderRepository.save(new Orders()); }
    


}

