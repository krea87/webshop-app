package se.jensen.johan.webapp.model;

public class PetAccessory extends Product {
    private String animal;

    @Override
    String category() {
        return "Category: " + getProductCategory();
    }
}
