package org.isep.Core;

public class Boss {
    private int damagePoints;

    public Boss(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
}
