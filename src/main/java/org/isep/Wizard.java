package org.isep;

import java.util.Scanner;

public class Wizard {
    private static final int MAX_HEALTH_POINTS = 100;
    private String name;
    private int healthPoints;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void heal(int points) {
        if (points > 0) {
            int newHealthPoints = this.healthPoints + points;
            if (newHealthPoints > MAX_HEALTH_POINTS) {
                System.out.println("Vous ne pouvez pas récupérer autant de points de vie, vous dépasser vos points de vie maximum.");
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

    public void takeDamage(int points) {
        loseHealthPoints(points);
    }
}
