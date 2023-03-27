package org.isep.Console;

public enum PotionType {
    VULNERA_SANENTUR("Vulnera Sanentur", 5),
    EPISKEY("Episkey", 10);

    private String name;
    private int healingPower;

    PotionType(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;
    }


    public String getName() {
        return name;
    }

    public int getHealingPower() {
        return healingPower;
    }

}
