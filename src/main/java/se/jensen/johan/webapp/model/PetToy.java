package se.jensen.johan.webapp.model;

public class PetToy extends Product {
    private String animal;
    private AgeCategory age;

    @Override
    String category() {
        return "Category: " + getProductCategory();
    }

}
