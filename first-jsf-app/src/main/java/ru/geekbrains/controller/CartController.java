package ru.geekbrains.controller;

import ru.geekbrains.persist.CartItem;
import ru.geekbrains.persist.CartRepository;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private CartRepository cartRepository;

    public List<CartItem> getAllCart() {
        return cartRepository.findAll();
    }

    public void addToCart(Product product) {
        cartRepository.addToCart(product);
    }

    public void removeFromCart(Product product) {
        cartRepository.deleteById(product.getId());
    }
}
