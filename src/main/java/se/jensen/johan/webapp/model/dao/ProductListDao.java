package se.jensen.johan.webapp.model.dao;

import se.jensen.johan.webapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListDao implements ProductDao{
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product findProductByArticleNumber(String articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
