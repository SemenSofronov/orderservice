package com.sofronov.orderservice.entity.enums;

public enum Category {

    GOOD("good"),
    SERVICE("service");

    private final String id;

    Category (String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Category fromId(String id) {
        for (Category category : Category.values()) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

}
