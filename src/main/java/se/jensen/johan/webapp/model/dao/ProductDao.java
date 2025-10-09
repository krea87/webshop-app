package se.jensen.johan.webapp.model.dao;

import se.jensen.johan.webapp.model.Product;

import java.util.List;

//Interface to control where the data is stored
public interface ProductDao {

    public List<Product> getAllProducts(); // Get all products and return as a list

    public void addProduct(Product product); // Add a new product to the list

    public Product findProductByArticleNumber(String articleNumber); // Find a product by Article number




}
