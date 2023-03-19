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
        System.out.println("Jolie prenom !, " + wizard.getName() + "!");

        System.out.println("Suis moi on va chercher ta baguette mais oublie pas la baguette choisit le sorcier");
        Wand wand = new Wand();
        Core core = Core.randomCore();
        wand.setCore(core);
        System.out.println("Your wand has chosen you! It has a " + wand.getWood() + " wood and a " + wand.getLength() + " inch length, with a " + wand.getCore() + " core.");

        System.out.println("Il est maintenant temps de vous répartir dans votre maison de Poudlard.");
        SortingHat sortingHat = new SortingHat();
        System.out.println("votre maison est ...");
        System.out.println(sortingHat.randomHouse().getName() + "!");

        Player player = new Player();
        int healthPoints = player.getHealthPoints();
        System.out.println("LE JEU PEUT ENFIN COMMENCER TU COMMENCES AVEC " + healthPoints + " POINTS DE VIE");
    }
}
