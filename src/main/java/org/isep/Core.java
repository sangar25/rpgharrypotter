package org.isep;

import java.util.Random;

public enum Core {
    plumedefénix,
    corail,
    poiludeblaireau,
    crindelicorne,
    moustachedetroll,
    cornedebasilic;

    // méthode statique pour retourner une instance de Core
    public static Core randomCore() {
        Core[] cores = Core.values(); // Récupère toutes les valeurs de l'énumération
        Random random = new Random(); // Initialise un générateur de nombres aléatoires
        int index = random.nextInt(cores.length); // Récupère un index aléatoire dans le tableau de valeurs
        return cores[index]; // Retourne la valeur correspondante
    }
}