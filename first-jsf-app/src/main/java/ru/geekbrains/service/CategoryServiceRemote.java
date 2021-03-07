package ru.geekbrains.service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CategoryServiceRemote {
    List<CategoryRepr> findAll();

    CategoryRepr findById(Long id);

    Long countAll();
}
