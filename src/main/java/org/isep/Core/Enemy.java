package org.isep.Core;

import org.isep.Console.Wizard;

public class Enemy {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private int strength;

    public Enemy(String name, int healthPoints, int attackPoints, int defensePoints, int strength) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.strength = strength;
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

    public void dementorAttack(Wizard wizard) {wizard.loseHealthPoints(strength);
    }
}
