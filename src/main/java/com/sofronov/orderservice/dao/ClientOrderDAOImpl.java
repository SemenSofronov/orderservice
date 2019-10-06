package com.sofronov.orderservice.dao;

import com.sofronov.orderservice.entity.ClientOrder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class ClientOrderDAOImpl extends SimpleJpaRepository<ClientOrder, Long> implements ClientOrderDAO {

    public ClientOrderDAOImpl(EntityManager entityManager) {
        super(ClientOrder.class, entityManager);
    }

    @Override
    public Iterable<ClientOrder> loadOrdersByClientId(Long clientId) {
        return findAll((Specification<ClientOrder>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("clientId"), clientId));
    }
}
