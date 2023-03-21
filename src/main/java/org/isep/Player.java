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

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void loseHealthPoints(int points) {
        healthPoints -= points;
    }

    public void attack(Enemy enemy) {
        int damage = attackPoints - enemy.getDefensePoints();
        if (damage > 0) {
            System.out.println(name + " attaque " + enemy.getName() + " et lui inflige " + damage + " points de dégâts !");
            enemy.loseHealthPoints(damage);
            if (enemy.getHealthPoints() <= 0) {
                enemy.winFight();
            }
        } else {
            System.out.println(name + " attaque " + enemy.getName() + " mais celui-ci parvient à parer l'attaque !");
        }
    }

    public void winFight() {
        System.out.println(name + " a vaincu son ennemi !");
    }
    public class Wizard extends Player {

        public Wizard(String name, int healthPoints, int attackPoints, int defensePoints) {
            super(name, healthPoints, attackPoints, defensePoints);
        }

        public void trollAttack(Enemy enemy) {
            int damage = getAttackPoints() - enemy.getDefensePoints();
            if (damage > 0) {
                System.out.println(getName() + " attaque " + enemy.getName() + " avec un sortilège et lui inflige " + damage + " points de dégâts !");
                enemy.loseHealthPoints(damage);
                if (enemy.getHealthPoints() <= 0) {
                    enemy.winFight();
                }
            } else {
                System.out.println(getName() + " attaque " + enemy.getName() + " avec un sortilège mais celui-ci parvient à parer l'attaque !");
            }
        }
    }
}
