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
    }

    public void attack(PV target) {
        int damage = rand.nextInt(20) + 1;
        target.takeDamage(damage);
        if (target.getHealthPoints() == 0) {
            int reward = rand.nextInt(50) + 1;
            rewardPoints += reward;
            System.out.println("Victoire ! Vous avez gagné " + reward + " points de récompense.");
        }
    }

    public void winFight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous avez gagné le combat !");

        System.out.println("Voulez-vous augmenter vos points de vie (1) ou vos points de dégâts (2) ?");
        int choix = sc.nextInt();

        if (choix == 1) {
            // Augmenter les points de vie
            healthPoints += 10;
            System.out.println("Vos points de vie ont été augmentés de 10. Vous avez maintenant " + healthPoints + " points de vie.");
        } else if (choix == 2) {
            // Augmenter les points de dégâts
            System.out.print("Combien de points de dégâts voulez-vous ajouter ? ");
            int damagePoints = sc.nextInt();
            System.out.println("Vos points de dégâts ont été augmentés de " + damagePoints + ". Vous infligez maintenant " + damagePoints + " points de dégâts.");
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
