package org.isep;
import java.util.Random;

import java.util.Random;

public class Wand {
    private String wood;
    private int length;
    private Core core;

    public Wand() {
        // Default values for wood and length
        this.wood = "unknown";
        this.length = 0;
    }

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

    public static void main(String[] args) {
        String[] woods = {"oak", "pine", "birch", "ash", "maple"};
        Random rand = new Random();
        Wand wand = new Wand();

        // Choose random values for the wand
        int randomLength = rand.nextInt(12) + 8; // random integer between 8 and 19
        String randomWood = woods[rand.nextInt(woods.length)];

        // Set the values for the wand
        wand.setLength(randomLength);
        wand.setWood(randomWood);

    }
}