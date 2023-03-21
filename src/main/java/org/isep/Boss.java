package org.isep;

public class Boss {
    private String name;
    private int healthPoints;
    private int damagePoints;

    public Boss(String name, int healthPoints, int damagePoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void attack(Wizard wizard) {
        System.out.println(name + " attaque " + wizard.getName() + " !");
        wizard.loseHealthPoints(damagePoints);
        System.out.println(wizard.getName() + " perd " + damagePoints + " points de vie.");
    }
}
