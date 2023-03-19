package org.isep;

import java.util.Random;

public class SortingHat {
    private House[] houses;

    public SortingHat() {
        houses = new House[4];
        houses[0] = new House("Gryffondor", "Vous appartenez peut-être à Gryffondor,\nOù habitent les braves au cœur,\nLeur audace, leur nerf et leur galanterie\nSéparent Gryffondor des autres maisons;");
        houses[1] = new House("Poufsouffle", "Vous appartenez peut-être à Poufsouffle,\nOù l'on est juste et loyal,\nCes patients Poufsouffle sont vrais\nEt sans peur devant le travail;");
        houses[2] = new House("Serpentard", "Ou peut-être à la sage vieille maison Serpentard,\nSi vous avez un esprit alerte,\nLà où ceux qui ont de l'esprit et apprennent\nTrouvent toujours leur place;");
        houses[3] = new House("Serdaigle", "Ou peut-être à Serdaigle,\nVous vous ferez de vrais amis,\nCes gens rusés utilisent tous les moyens\nPour atteindre leur but.");
    }

    public House randomHouse() {
        Random rand = new Random();
        int index = rand.nextInt(houses.length);
        return houses[index];
    }
}
