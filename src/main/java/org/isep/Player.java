package org.isep;
public class Player {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;

    public Player(String name, int healthPoints, int attackPoints, int defensePoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public String getName() {
        return name;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void loseHealthPoints(int points) {
        healthPoints -= points;
    }

    public class Wizard extends Player {

        public Wizard(String name, int healthPoints, int attackPoints, int defensePoints) {
            super(name, healthPoints, attackPoints, defensePoints);
        }


        }
    }

