package se.jensen.johan.webapp.model;

public abstract class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;
    private ProductCategory productCategory; // Not needed for this project to have this and enum but I want to try and "prepare" for later


    public abstract String category();

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Title:" + title
                + "\n Article number: " + articleNumber
                + "\n Price: " + price
                + "\n Description: " + description
                + "\n Category: " + productCategory.getDisplayName();
    }
}
