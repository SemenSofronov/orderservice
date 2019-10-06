package com.sofronov.orderservice.controller;

import com.sofronov.orderservice.entity.ClientOrder;
import com.sofronov.orderservice.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "orders")
public class ClientOrderController {

    private ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @GetMapping(value = "/list")
    public Iterable<ClientOrder> getOrders() {
        return clientOrderService.getOrders();
    }

    @GetMapping(value = "/client-list/{clientId}")
    public Iterable<ClientOrder> getOrdersByClientId(@PathVariable("clientId") Long clientId) {
        return clientOrderService.getOrdersByClientId(clientId);
    }

    @PostMapping(value = "/update/{orderId}", consumes = "application/json")
    public ClientOrder update(@PathVariable("orderId") Long orderId, @Valid @RequestBody ClientOrder clientOrder) {
        return clientOrderService.update(orderId, clientOrder);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ClientOrder create(@Valid @RequestBody ClientOrder clientOrder) {
        return clientOrderService.create(clientOrder);
    }

    @GetMapping(value = "/delete/{orderId}", consumes = "application/json")
    public Boolean delete(@PathVariable("orderId") Long orderId) {
        return clientOrderService.delete(orderId);
    }

}
