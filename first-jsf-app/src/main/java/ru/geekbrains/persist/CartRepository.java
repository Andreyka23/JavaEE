package ru.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Named
@ApplicationScoped
public class CartRepository {

    private final Map<Long, CartItem> cartMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
    }

    public List<CartItem> findAll() {
        return new ArrayList<>(cartMap.values());
    }

    public CartItem findById(Long id) {
        return cartMap.get(id);
    }

    public void addToCart(Product product) {
        if (cartMap.get(product.getId()) == null) {
            cartMap.put(product.getId(), new CartItem(product, 1L));
        } else {
            cartMap.put(product.getId(), new CartItem(product, this.findById(product.getId()).getCount() + 1 ));
        }
    }

    public void deleteById(Long id) {
        cartMap.remove(id);
    }
}
