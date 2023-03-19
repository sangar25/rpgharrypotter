package org.isep;

public class House {
    private String name;
    private String description;

    public House(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
