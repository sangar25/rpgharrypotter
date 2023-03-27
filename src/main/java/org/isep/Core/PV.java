package org.isep.Core;
import java.util.Random;;


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



    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        else if (healthPoints > 100) {
            healthPoints = 100;
        }
    }



    public void loseHealthPoints(int points) {
        healthPoints -= points;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        else if (healthPoints > 100) {
            healthPoints = 100;
        }
    }

}
