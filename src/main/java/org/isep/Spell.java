package org.isep;

import java.util.Random;

public enum Spell {
    LUMOS(70, 5),
    WINGARDIUM_LEVIOSA(50, 30),
    EXPECTO_PATRONUM(70, 70),
    AVADA_KEDAVRA(5, 100);

    private int successRate;
    public int damagePoints;

    // Constructor for enum Spell
    private Spell(int successRate, int damagePoints) {
        this.successRate = successRate;
        this.damagePoints = damagePoints;
    }

    // Method to cast the spell
    public int cast() {
        Random rand = new Random();
        int roll = rand.nextInt(100) + 1; // random number between 1 and 100 inclusive
        if (roll <= successRate) {
            System.out.println("Spell successful!");
            return damagePoints;
        } else {
            System.out.println("Spell failed...");
            return 0;
        }
    }

    // Method to get the success rate of the spell
    public int getSuccessRate() {
        return successRate;
    }

    // Method to get the damage points of the spell
    public int getDamagePoints() {
        return damagePoints;
    }
}
