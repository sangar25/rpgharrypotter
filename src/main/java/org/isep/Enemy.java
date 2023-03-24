package org.isep;
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

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }


    public int getDefensePoints() {
        return defensePoints;
    }


    public void loseHealthPoints(int points) {
        healthPoints -= points;
    }



    public void trollAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }



}
