package se.jensen.johan.webapp.model;

public enum ProductCategory {
    PET_FOOD("Pet Food"), PET_TOY("Pet Toy"), PET_ACCESSORY("Pet Accessory");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
