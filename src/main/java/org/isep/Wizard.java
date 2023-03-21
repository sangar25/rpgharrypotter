package org.isep;

import java.util.Scanner;

public class Wizard {
    private String name;
    private int healthPoints;

    public Wizard(String name) {
        this(name, 100); // Appelle le constructeur complet avec des points de vie par défaut de 100
    }

    public Wizard(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
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

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void castSpell(Spell spell, PV target) {
        System.out.println(this.getName() + " lance le sort " + spell.toString());
        spell.cast();
        if (spell == Spell.AVADA_KEDAVRA) {
            System.out.println("Le sort Avada Kedavra ne laisse aucune chance à sa cible...");
            target.takeDamage(100); // tue instantanément la cible
        } else {
            target.takeDamage(20); // inflige 20 points de dégâts à la cible
        }
    }

    public void loseHealthPoints(int points) {
        this.healthPoints -= points;
        System.out.println(this.name + " perd " + points + " points de vie !");
        System.out.println("Il reste " + this.healthPoints + " points de vie à " + this.name + ".");
    }
}
