package org.isep;
import java.util.Random;
import java.util.Scanner;


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
