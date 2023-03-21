package org.isep;

import java.util.Random;

public class Wand {
    private String wood;
    private int length;
    private Core core;

    public Wand(String wood, int length, Core core) {
        this.wood = wood;
        this.length = length;
        this.core = core;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public int getPower() {
        Random rand = new Random();
        return rand.nextInt(10) + 1; // Random integer between 1 and 10
    }

    public static void main(String[] args) {
        String[] woods = {"oak", "pine", "birch", "ash", "maple"};
        Random rand = new Random();

        // Choose random values for the wand
        int randomLength = rand.nextInt(12) + 8; // random integer between 8 and 19
        String randomWood = woods[rand.nextInt(woods.length)];
        Core randomCore = Core.randomCore();

        // Create a new wand with the random values
        Wand wand = new Wand(randomWood, randomLength, randomCore);

        // Print out the wand's properties
        System.out.println("Wood: " + wand.getWood());
        System.out.println("Length: " + wand.getLength());
        System.out.println("Core: " + wand.getCore().name());
        System.out.println("Power: " + wand.getPower());
    }
}
