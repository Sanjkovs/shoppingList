package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductListAplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.execute();
    }
}
