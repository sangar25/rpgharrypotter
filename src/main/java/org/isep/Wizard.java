package org.isep;
import java.util.Scanner;

public class Wizard {
    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        int damagePoints;
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de points de dégâts voulez-vous ajouter ? ");
        damagePoints = sc.nextInt();

        // Faire quelque chose avec la variable damagePoints
    }
}
