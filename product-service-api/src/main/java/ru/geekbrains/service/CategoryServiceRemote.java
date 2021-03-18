package ru.geekbrains.service;

import java.util.List;

public interface CategoryServiceRemote {
    List<CategoryRepr> findAll();

    CategoryRepr findById(Long id);

    Long countAll();
}
