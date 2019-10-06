package com.sofronov.orderservice.entity;

import com.sofronov.orderservice.entity.enums.Category;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "client_order")
public class ClientOrder {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please provide a goods name")
    @Column(name = "goods_name", nullable = false, length = 60)
    private String goodsName;

    @Column(name = "category")
    private Category category;

    @Column(name = "client_id")
    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
