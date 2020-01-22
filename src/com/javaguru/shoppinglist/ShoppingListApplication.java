package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        if (name.length() < 3 || name.length() > 32) {
                            System.out.println("Name should be not less, than 3 letters and not more, than 100");
                            break;
                        }
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        if (price.compareTo(BigDecimal.ZERO) <= 0) {
                            System.out.println("Price should be more than 0");
                            break;
                        }
                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        if(discount.intValue() > 100 || discount.intValue() < 0) {
                            System.out.println("Discount should be not more than 100 and not less than 0");
                            break;
                        }
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setId(productIdSequence);
                        product.setCategory(category);
                        product.setDescription(description);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
