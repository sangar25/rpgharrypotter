package org.isep.Console;

import org.isep.Core.House;

public class Wizard {
    public static final int MAX_HEALTH_POINTS = 100;

    private String name;
    private int healthPoints;
    private int damagePoints;
    private House house;

    public Wizard(String name) {
        this(name, MAX_HEALTH_POINTS, 0);
    }

    public Wizard(String name, int healthPoints, int damagePoints) {
        this.name = name;
        this.healthPoints = Math.min(healthPoints, MAX_HEALTH_POINTS);
        this.damagePoints = damagePoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
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
            System.out.println("BRAVO VOUS AVEZ REUSSI LE NIVEAU.");
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

    public void gainHealthPoints(int healthPointsIncrement) {
        setHealthPoints(getHealthPoints() + healthPointsIncrement);
        System.out.println(this.name + " gagne " + healthPointsIncrement + " points de vie !");
        System.out.println("Il a maintenant " + this.healthPoints + " points de vie.");
    }

    public void increaseDamage() {
        increaseDamagePoints(10);
    }

    public void increaseDamagePoints(int damagePointsIncrement) {
        this.damagePoints += damagePointsIncrement;
        System.out.println(this.name + " augmente ses points de dégâts de " + damagePointsIncrement + ".");
        System.out.println("Il a maintenant " + this.damagePoints + " points de dégâts.");
    }

    public House getHouse() {
        return house;
    }

    public void destroyJournal(String journalName) {
        System.out.println(this.name + " utilise un des crocs pour détruire le " + journalName + ".");
    }

    // Méthode de calcul de distance entre deux points

    public static double distance(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

}
