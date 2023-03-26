package org.isep;

public enum Spell {
    LUMOS(70, 5),
    WINGARDIUM_LEVIOSA(50, 30),
    EXPECTO_PATRONUM(70, 70),
    AVADA_KEDAVRA(5, 100),
    INCENDIO("Incendio", 25),
    ÉPÉE ("l'épée légendaire de Godric Gryﬀindor", 50),
    BOMBARDIA("Bombardia", 35);



    private int successRate;
    public int damagePoints;
    public String spellName;

    // Constructor for enum Spell
    Spell(int successRate, int damagePoints) {
        this.successRate = successRate;
        this.damagePoints = damagePoints;
    }

    // Constructor for enum Spell with a spell name
    Spell(String spellName, int damagePoints) {
        this.spellName = spellName;
        this.successRate = 60; // default success rate
        this.damagePoints = damagePoints;
    }

    // Method to get the damage points of the spell
    public int getDamagePoints() {
        return damagePoints;
    }

    // Method to get the damage increment of the spell

    public String getName() {
        return spellName;
    }

}
