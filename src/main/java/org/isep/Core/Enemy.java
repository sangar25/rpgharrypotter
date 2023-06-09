package org.isep.Core;

import org.isep.Console.Wizard;

public class Enemy {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private int strength;
    private int health;

    public int getHealth() {
            return health;
        }

        public void takeDamage(int damage) {
            health -= damage;
        }


    public Enemy(String name, int healthPoints, int attackPoints, int defensePoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void loseHealthPoints(int points) {
        healthPoints -= points;
    }

    public void trollAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }

    public void basiliskAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }

    public void dementorAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }
    public void mangemortAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }

    public int doloresAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
        return 0;
    }
}