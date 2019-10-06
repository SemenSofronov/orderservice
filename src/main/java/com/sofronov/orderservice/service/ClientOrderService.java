package com.sofronov.orderservice.service;

import com.sofronov.orderservice.dao.ClientOrderDAO;
import com.sofronov.orderservice.entity.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientOrderService {

    private ClientOrderDAO clientOrderDAO;

    @Autowired
    public ClientOrderService(ClientOrderDAO clientOrderDAO) {
        this.clientOrderDAO = clientOrderDAO;
    }

    public Iterable<ClientOrder> getOrders() {
        return clientOrderDAO.findAll();
    }

    public ClientOrder update(Long clientOrderId, ClientOrder clientOrder) {
        Optional<ClientOrder> optionalClientOrder = clientOrderDAO.findById(clientOrderId);
        if (optionalClientOrder.isPresent()) {
            ClientOrder oldClientOrder = optionalClientOrder.get();

            oldClientOrder.setGoodsName(clientOrder.getGoodsName());
            oldClientOrder.setCategory(clientOrder.getCategory());

            return clientOrderDAO.save(oldClientOrder);
        }

        return null;
    }

    public ClientOrder create(ClientOrder clientOrder) {
        return clientOrderDAO.save(clientOrder);
    }

    public Boolean delete(Long clientOrderId) {
        Optional<ClientOrder> optionalClientOrder = clientOrderDAO.findById(clientOrderId);
        if (optionalClientOrder.isPresent()) {
            clientOrderDAO.delete(optionalClientOrder.get());
            return true;
        }
        return false;
    }

    public Iterable<ClientOrder> getOrdersByClientId(Long clientId) {
        return clientOrderDAO.loadOrdersByClientId(clientId);
    }
}
