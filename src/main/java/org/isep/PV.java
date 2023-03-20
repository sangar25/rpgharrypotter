package org.isep;
import java.util.Random;

public class PV {
    private int healthPoints;
    private int rewardPoints;
    private Random rand;

    public PV() {
        this.healthPoints = 100;
        this.rewardPoints = 0;
        this.rand = new Random();
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }

    public void attack(PV target) {
        int damage = rand.nextInt(20) + 1;
        target.takeDamage(damage);
        if (target.getHealthPoints() == 0) {
            int reward = rand.nextInt(50) + 1;
            rewardPoints += reward;
            System.out.println("Victory! You earned " + reward + " reward points.");
        }
    }
}
