package org.isep;

import java.util.Random;

public class SortingHat {
    public House[] houses;

    public SortingHat() {
        houses = new House[4];
        houses[0] = new House("Gryffondor", "Vous appartenez peut-être à Gryffondor, Où habitent les braves au cœur, Leur audace, leur nerf et leur galanterie Séparent Gryffondor des autres maisons;");
        houses[1] = new House("Poufsouffle", "Vous appartenez peut-être à Poufsouffle, Où l'on est juste et loyal, Ces patients Poufsouffle sont vrais Et sans peur devant le travail;");
        houses[2] = new House("Serpentard", "Ou peut-être à la sage vieille maison Serpentard, Si vous avez un esprit alerte, Là où ceux qui ont de l'esprit et apprennent Trouvent toujours leur place;");
        houses[3] = new House("Serdaigle", "Ou peut-être à Serdaigle,Vous vous ferez de vrais amis,Ces gens rusés utilisent tous les moyens Pour atteindre leur but.");
    }

    public House randomHouse() {
        Random rand = new Random();
        int index = rand.nextInt(houses.length);
        return houses[index];
    }
    public House getHouseByName(String name) {
        for (House house : houses) {
            if (house.getName().equals(name)) {
                return house;
            }
        }
        return null; // House with given name not found
    }

}
