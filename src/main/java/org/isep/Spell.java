package org.isep;

import java.util.Random;

public enum Spell {
    LUMOS(5),
    WINGARDIUM_LEVIOSA(80),
    EXPECTO_PATRONUM(70),
    AVADA_KEDAVRA(5);

    private int successRate;

    // Constructeur de l'enum Spell
    private Spell(int successRate) {
        this.successRate = successRate;
    }

    // Méthode pour lancer le sort
    public void cast() {
        Random rand = new Random();
        int roll = rand.nextInt(100) + 1; // nombre aléatoire entre 1 et 100 inclus
        if (roll <= successRate) {
            System.out.println("Sort réussi !");
            // Faire quelque chose ici si le sort réussit
        } else {
            System.out.println("Le sort a échoué...");
            // Faire quelque chose ici si le sort échoue
        }
    }

    // Méthode pour récupérer le taux de réussite du sort
    public int getSuccessRate() {
        return successRate;
    }
}
