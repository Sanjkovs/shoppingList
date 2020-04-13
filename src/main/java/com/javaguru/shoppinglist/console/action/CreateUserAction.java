package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateUserAction implements Action {

    private static final String ACTION_NAME = "Create user";

    private final UserService userService;

    @Autowired
    public CreateUserAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user login: ");
        String login = scanner.nextLine();
        System.out.println("Enter user password: ");
        String password = scanner.nextLine();

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        Long response = userService.createUser(user);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
