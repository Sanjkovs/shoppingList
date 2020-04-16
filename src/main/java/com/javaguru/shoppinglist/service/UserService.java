package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.repository.HibernateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Component
public class UserService {

    private final HibernateUserRepository userRepository;

    @Autowired
    public UserService(HibernateUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found, id: " + id));
    }

    public void addProductToUser(Long userId, Product product) {
        User user = findUserById(userId);
        user.getProducts().add(product);
        userRepository.update(user);
    }

}
