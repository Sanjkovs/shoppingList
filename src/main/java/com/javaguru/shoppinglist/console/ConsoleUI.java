package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<Action> actions;

    @Autowired
    public ConsoleUI(List<Action> actions) {
        this.actions = actions;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;
        while (response>=0) {
            printMenu();
            try {
//                System.out.println("1. Create product");
//                System.out.println("2. Find product by id");
//                System.out.println("3. Exit");
                response = scanner.nextInt();
                actions.get(response).execute();
            } catch (Exception e) {
                System.out.println("Error! Please try again");
                System.out.println(e.getMessage());
//                System.out.println(e.printStackTrace());
            }
        }

    }
    private void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }

//    private void createProduct() {
////        productService.createProduct(product);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter product name: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter product price: ");
//        BigDecimal price = new BigDecimal(scanner.nextLine());
//        System.out.println("Enter product discount: ");
//        BigDecimal discount = new BigDecimal(scanner.nextLine());
//        System.out.println("Enter product category: ");
//        String category = scanner.nextLine();
//        System.out.println("Enter product description: ");
//        String description = scanner.nextLine();
//
//        Product product = new Product();
//        product.setName(name);
//        product.setPrice(price);
//        product.setDiscount(discount);
//        product.setCategory(category);
//        product.setDescription(description);
//
//        Long id = productService.createProduct(product);
//        System.out.println("ID: " + id);
//    }
//
//    private void findProduct() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter product id: ");
//        Long id = scanner.nextLong();
//        Product findProductResult = productService.findProductById(id);
//        System.out.println(findProductResult);
//    }
}
