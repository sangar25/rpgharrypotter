package org.isep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue à Poudlard!");

        System.out.println("Tout d'abord, vous devez choisir un nom de sorcier..");
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de votre sorcier : ");
        String wizardName = sc.nextLine();

        Wizard wizard = new Wizard(wizardName);
        System.out.println("Joli prénom ! " + wizard.getName() + "!");

        System.out.println("Suis moi on va chercher ta baguette mais n'oublie pas, c'est la baguette qui choisit le sorcier.");
        Wand wand = new Wand("chêne", 12, Core.randomCore());
        Core core = Core.randomCore();

        wand.setCore(core);
        System.out.println("Ta baguette t'a choisi ! C'est du bois de " + wand.getWood() + " et elle mesure " + wand.getLength() + " pouces, avec comme coeur " + wand.getCore() + ".");

        System.out.println("Il est maintenant temps de choisir votre maison de Poudlard.");
        SortingHat sortingHat = new SortingHat();
        System.out.println("Votre maison est...");
        System.out.println(sortingHat.randomHouse().getName() + "!");

        PV pv = new PV();
        int healthPoints = pv.getHealthPoints();
        System.out.println("LE JEU PEUT ENFIN COMMENCER TU COMMENCES AVEC " + healthPoints + " POINTS DE VIE");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous lancer le sort LUMOS ou le sort WINGARDIUM LEVIOSA ?");
        System.out.println("1. LUMOS");
        System.out.println("2. WINGARDIUM LEVIOSA");

        int choix = scanner.nextInt();

        if (choix == 1) {
            // L'utilisateur a choisi le sort LUMOS
            System.out.println(wizard.getName() + " lance le sort LUMOS sur la cible !");
            pv.winFight();
        } else if (choix == 2) {
            // L'utilisateur a choisi le sort WINGARDIUM LEVIOSA
            System.out.println(wizard.getName() + " lance le sort WINGARDIUM LEVIOSA sur la cible !");
            pv.winFight();
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
