package org.isep.Core;

public class House {
    private String name;
    private String description;
    private int points;
    private int potionEffectiveness; // Efficacité des potions
    private int spellPower; // Puissance des sorts
    private int resilience; // Résilience aux dégâts
    private int accuracy; // Précision


    public static final String GRYFFONDOR = "Gryffondor";
        public static final String POUFSOUFFLE = "Poufsouffle";
        public static final String SERPENTARD = "Serpentard";
        public static final String SERDAIGLE = "Serdaigle";

        // Autres propriétés et méthodes de la classe House

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public House(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
