package org.isep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hogwarts!");

        System.out.println("First, you need to choose a wizard name.");
        String wizardName = "Harry Potter"; // replace with user input

        Wizard wizard = new Wizard(wizardName);
        System.out.println("Perfect, " + wizard.getName() + "!");

        System.out.println("Let's go to Ollivander's to get your wand.");
        System.out.println("The wand chooses the wizard, remember?");
        Wand wand = new Wand();
        Core core = Core.randomCore();
        wand.setCore(core);
        System.out.println("Your wand has chosen you! It has a " + wand.getWood() + " wood and a " + wand.getLength() + " inch length, with a " + wand.getCore() + " core.");

        System.out.println("Now it's time to get sorted into your Hogwarts house.");
        SortingHat sortingHat = new SortingHat();
        System.out.println("Right... I have just the place for you...");
        System.out.println(sortingHat.randomHouse().getName() + "!");
    }
}
