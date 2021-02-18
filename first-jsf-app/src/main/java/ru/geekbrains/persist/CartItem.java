package ru.geekbrains.persist;

import java.math.BigDecimal;

public class CartItem {

    private Product product;

    private Long count;

    public CartItem() {
    }

    public CartItem(Product product, Long count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
