package se.jensen.johan.webapp.controller;

import se.jensen.johan.webapp.model.*;
import se.jensen.johan.webapp.model.dao.ProductDao;
import se.jensen.johan.webapp.model.dao.ProductListDao;
import se.jensen.johan.webapp.ui.ScannerUI;
import se.jensen.johan.webapp.ui.UI;
import se.jensen.johan.webapp.util.Messages;

import java.util.Scanner;

public class Application {
    UI ui = new ScannerUI();
    ProductDao productDao = new ProductListDao();

    public void runApplication() {

        boolean isRunning = true;

        while (isRunning) {
            String menuChoice = ui.menu(); // the menu with the choices for the user

            switch (menuChoice) {
                case "1" -> {
                    if (productDao.getAllProducts().isEmpty()) {
                        System.out.println("The list is empty. Add a product");
                    } else {
                        for (Product p : productDao.getAllProducts()) {
                            System.out.println(p);
                        }
                    }
                }
                case "2" -> addProductMenu();
                case "3" -> findProductMenu();
                case "4" -> isRunning = false;
            }
        }

        if (ui instanceof ScannerUI scannerUI) {
            scannerUI.closeScanner();
        }
    }

    private void addProductMenu() {
        Product product = null;
        ProductCategory category = null;
        String choice = ui.prompt("Select category: \n 1. Pet Food \n 2. Pet Toy \n 3. Pet Accessory");
        switch (choice) {
            case "1" -> {
                product = new PetFood();
                category = ProductCategory.PET_FOOD;
            }
            case "2" -> {
                product = new PetToy();
                category = ProductCategory.PET_TOY;
            }
            case "3" -> {
                product = new PetAccessory();
                category = ProductCategory.PET_ACCESSORY;
            }
            default -> ui.info(Messages.INVALID_INPUT);
        }
        if (product != null) {
            product.setProductCategory(category);
            String articleNumber = ui.prompt("Enter the Article Number: ");
            product.setArticleNumber(articleNumber);
            String title = ui.prompt("Enter the title: ");
            product.setTitle(title);
            double price = Double.parseDouble(ui.prompt("Enter the price: "));
            product.setPrice(price);
            String description = ui.prompt("Write a description: ");
            product.setDescription(description);
            productDao.addProduct(product);
        }

    }

    private void findProductMenu() {
        String articleNumber = ui.prompt("Enter the Article Number");
        Product product = productDao.findProductByArticleNumber(articleNumber);

        if (product == null) {
            ui.info("No product found with that article number");
        } else {
            ui.info("Product found: ");
            System.out.println(product);
        }
    }
}
