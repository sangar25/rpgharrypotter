package org.isep;

public enum PotionType {
    VULNERA_SANENTUR("Vulnera Sanentur", 5),
    EPISKEY("Episkey", 10);

    private String name;
    private int healingPower;

    private PotionType(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;
    }

    private PotionType(int healingPower) {
        this.healingPower = healingPower;
    }
    public String getName() {
        return name;
    }

    public int getHealingPower() {
        return healingPower;
    }

}
