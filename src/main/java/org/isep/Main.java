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

        System.out.println("LA PREMIERE EPREUVE: The Philosopher’s Stone");
        // créer l'ennemi Troll

        Enemy troll = new Enemy("Troll", 50, 10, 5, 20);

        // afficher le message de combat
        System.out.println("Un Troll sauvage apparaît !");

        // boucle de combat
        while (wizard.getHealthPoints() > 0 && troll.getHealthPoints() > 0) {
            System.out.println("Le Troll attaque " + wizard.getName() + " !");
            troll.trollAttack(wizard);

            // vérifier si le joueur est mort
            if (wizard.getHealthPoints() <= 0) {
                System.out.println(wizard.getName() + " est KO !");
                break;
            }

            // choix du sort
            System.out.println(wizard.getName() + ", que voulez-vous faire ?");
            System.out.println("1. LUMOS");
            System.out.println("2. WINGARDIUM LEVIOSA");
            int choix = scanner.nextInt();

            // utiliser le sort choisi
            if (choix == 1) {
                System.out.println(wizard.getName() + " lance le sort LUMOS sur le Troll !");
                troll.loseHealthPoints(20);
            } else if (choix == 2) {
                System.out.println(wizard.getName() + " lance le sort WINGARDIUM LEVIOSA sur le Troll !");
                troll.loseHealthPoints(30);
            } else {
                System.out.println("Choix invalide.");
            }

            // vérifier si le Troll est mort
            if (troll.getHealthPoints() <= 0) {
                System.out.println("Le Troll est vaincu !");
                break;
            }


        }
    }
}
