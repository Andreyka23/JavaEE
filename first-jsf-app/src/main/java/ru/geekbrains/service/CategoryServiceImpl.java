package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.rest.CategoryServiceRest;
import ru.geekbrains.rest.ProductServiceRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService, CategoryServiceRemote, CategoryServiceRest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryRepr> findAll() {
        return categoryRepository.findAll().stream()
                .map(this::buildProductRepr)
                .collect(Collectors.toList());
    }

    private CategoryRepr buildProductRepr(Category category) {
        CategoryRepr repr = new CategoryRepr();

        repr.setId(category.getId());
        repr.setName(category.getName());

        return repr;
    }

    @Override
    public CategoryRepr findById(Long id) {
        Category category = categoryRepository.findById(id);
        if (category != null) {
            return buildProductRepr(category);
        }
        return null;
    }

    @Override
    public void insert(CategoryRepr category) {
        if (category.getId() != null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(category);
    }

    @Override
    public void update(CategoryRepr category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(category);
    }

    @Override
    public Long countAll() {
        return categoryRepository.countAll();
    }

    @TransactionAttribute
    @Override
    public void saveOrUpdate(CategoryRepr category) {
        logger.info("Saving category with id {}" , category.getId());

        categoryRepository.saveOrUpdate(new Category(category.getId(),category.getName()));
    }

    @TransactionAttribute
    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
