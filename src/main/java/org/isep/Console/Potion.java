package org.isep.Console;

public class Potion {
    private PotionType type;

    public Potion(PotionType type) {
        this.type = type;
    }

    public String getName() {
        return type.getName();
    }

    public int getPower() {
        return type.getHealingPower();
    }

    public int getHealingPower() {
        return type.getHealingPower();
    }

    public void use(Wizard wizard) {
        int power = getPower();
        if (power > 0) {
            int newHealthPoints = wizard.getHealthPoints() + power;
            if (newHealthPoints > Wizard.MAX_HEALTH_POINTS) {
                System.out.println("Vous ne pouvez pas récupérer autant de points de vie, vous dépassez vos points de vie maximum.");
                return;
            }
            wizard.setHealthPoints(newHealthPoints);
            System.out.println(wizard.getName() + " récupère " + power + " points de vie !");
            System.out.println("vous avez maintenant " + wizard.getHealthPoints() + " points de vie.");
        } else {
            int damagePoints = Math.abs(power);
            wizard.loseHealthPoints(damagePoints);
        }
    }
}
