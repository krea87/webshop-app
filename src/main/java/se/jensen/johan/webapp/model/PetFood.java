package se.jensen.johan.webapp.model;

public class PetFood extends Product{
    private String animal;
    private AgeCategory age;
    @Override
    public String category() {
        return "Category: " + getProductCategory();
    }
}
