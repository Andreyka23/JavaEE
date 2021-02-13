package ru.geekbrains.listener;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository userRepository = new UserRepository();

        userRepository.saveOrUpdate(new User(null, "User 1",
                "Surname 1"));
        userRepository.saveOrUpdate(new User(null, "User 2",
                "Surname 2"));
        userRepository.saveOrUpdate(new User(null, "User 3",
                "Surname 3"));

        sce.getServletContext().setAttribute("userRepository", userRepository);

        CategoryRepository categoryRepository = new CategoryRepository();

        categoryRepository.saveOrUpdate(new Category(null, "1 category"));
        categoryRepository.saveOrUpdate(new Category(null, "2 category"));

        sce.getServletContext().setAttribute("categoryRepository", categoryRepository);
    }
}
