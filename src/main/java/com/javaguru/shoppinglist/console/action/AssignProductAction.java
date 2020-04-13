package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Scanner;

@Component
public class AssignProductAction implements Action {

    private static final String ACTION_NAME = "Assign Product";

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public AssignProductAction(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }


    @Override
    @Transactional
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        Long userId = scanner.nextLong();

        System.out.println("Enter product id: ");
        Long productId = scanner.nextLong();

        Product product = productService.findProductById(productId);

        userService.addProductToUser(userId, product);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
