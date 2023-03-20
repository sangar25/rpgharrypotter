package org.isep;

public class Potion {
    private String name;
    private int healingPower;

    public Potion(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;
    }

    public String getName() {
        return name;
    }

    public int getHealingPower() {
        return healingPower;
    }
}
