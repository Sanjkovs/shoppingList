package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindUserByIdAction implements Action {

    private static final String ACTION_NAME = "Find User by ID";

    private final UserService userService;

    @Autowired
    public FindUserByIdAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User id: ");
        Long id = scanner.nextLong();
        User user = userService.findUserById(id);
        System.out.println("Response " + user);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
