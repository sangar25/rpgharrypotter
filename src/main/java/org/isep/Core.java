package org.isep;

import java.util.Random;

public class Core {
    private String type;

    public Core(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Core randomCore() {
        String[] coreTypes = {"Dragon heartstring", "Phoenix feather", "Unicorn hair"};
        Random rand = new Random();
        int index = rand.nextInt(coreTypes.length);
        return new Core(coreTypes[index]);
    }
}
