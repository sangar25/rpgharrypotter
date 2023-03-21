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

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getStrength() {
        return strength;
    }

    public void loseHealthPoints(int points) {
        healthPoints -= points;
    }

    public void attack(Player player) {
        int damage = attackPoints - player.getDefensePoints();
        if (damage > 0) {
            System.out.println(name + " attaque " + player.getName() + " et lui inflige " + damage + " points de dégâts !");
            player.loseHealthPoints(damage);
        } else {
            System.out.println(name + " attaque " + player.getName() + " mais celui-ci parvient à parer l'attaque !");
        }
    }

    public void trollAttack(Player player) {
        int damage = attackPoints - player.getDefensePoints();
        if (damage > 0) {
            System.out.println("Le Troll attaque " + player.getName() + " et lui inflige " + damage + " points de dégâts !");
            player.loseHealthPoints(damage);
        } else {
            System.out.println("Le Troll attaque " + player.getName() + " mais celui-ci parvient à parer l'attaque !");
        }
    }
    public void trollAttack(Wizard wizard) {
        wizard.loseHealthPoints(strength);
    }


    public void winFight() {
        System.out.println(name + " a vaincu son ennemi !");
    }
}
