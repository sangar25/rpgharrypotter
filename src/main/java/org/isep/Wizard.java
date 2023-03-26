package org.isep;

import java.util.Scanner;

public class Wizard {
    public static final int MAX_HEALTH_POINTS = 100;

    private String name;
    private int healthPoints;
    private House house;

    public Wizard(String name) {
        this(name, MAX_HEALTH_POINTS);
    }


    public Wizard(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = Math.min(healthPoints, MAX_HEALTH_POINTS);
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void heal(int points) {
        if (points > 0) {
            int newHealthPoints = this.healthPoints + points;
            if (newHealthPoints > MAX_HEALTH_POINTS) {
                System.out.println("Vous ne pouvez pas récupérer autant de points de vie, vous dépassez vos points de vie maximum.");
                return;
            }
            this.healthPoints = newHealthPoints;
            System.out.println(this.name + " récupère " + points + " points de vie !");
            System.out.println("Il a maintenant " + this.healthPoints + " points de vie.");
        }
    }

    public void loseHealthPoints(int points) {
        if (points > 0) {
            healthPoints -= points;
            System.out.println(name + " perd " + points + " points de vie !");
            System.out.println("Il reste " + healthPoints + " points de vie à " + name + ".");
            if (healthPoints <= 0) {
                System.out.println(name + " est vaincu...");
            }
        }
    }

    public void usePotion(Potion potion) {
        int healingPower = potion.getHealingPower();
        heal(healingPower);
        System.out.println(this.name + " utilise " + potion.getName() + " et récupère " + healingPower + " points de vie !");
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void increaseDamage(int damageIncrement) {
        for (Spell spell : Spell.values()) {
            if (spell.damagePoints > 0) {
                spell.damagePoints += damageIncrement;
            }
        }
        System.out.println("Ton sort a été amélioré, votre sort a maintenant un bonus de " + damageIncrement + " points de dégâts !");
    }

    public void setHouse(House house) {
        this.house = house;
    }
    public House getHouse() {
        return house;
    }


}
