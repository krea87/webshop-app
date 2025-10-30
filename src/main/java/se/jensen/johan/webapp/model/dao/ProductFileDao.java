package se.jensen.johan.webapp.model.dao;

import se.jensen.johan.webapp.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFileDao implements ProductDao{
    private final List<Product> products = new ArrayList<>();
    private final File file = new File ("products.txt");




    @Override
    public List<Product> getAllProducts() {

        if(!file.exists()) {
            System.out.println("No file found, creating new one");
            return products;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = fromFileString(line);
                if(product != null){
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product fromFileString(String line){

        String[] parts = line.split(";", 5);

        String category = parts[0];
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];

        Product product = null;

        switch (category) {
            case "PET_FOOD":
                product = new PetFood();
                break;
            case "PET_TOY":
                product = new PetToy();
                break;
            case "PET_ACCESSORY":
                product = new PetAccessory();
                break;
            default:
                System.out.println("Unknown category: " + category);
        }

        product.setProductCategory(ProductCategory.valueOf(category));
        product.setArticleNumber(articleNumber);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);

        return product;
    }

    @Override
    public void addProduct(Product product) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(product.toFileString());
            writer.newLine();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    @Override
    public Product findProductByArticleNumber(String articleNumber) {
        for (Product product : getAllProducts())
            if (product.getArticleNumber().equals(articleNumber)) {
                return  product;
            }
        return null;
    }
}
