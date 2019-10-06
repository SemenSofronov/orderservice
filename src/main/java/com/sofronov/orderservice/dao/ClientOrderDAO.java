package com.sofronov.orderservice.dao;

import com.sofronov.orderservice.entity.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderDAO extends CrudRepository<ClientOrder, Long> {

    Iterable<ClientOrder> loadOrdersByClientId(Long clientId);
}
