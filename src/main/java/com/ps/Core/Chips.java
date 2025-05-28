package com.ps.Core;

import java.util.ArrayList;

public class Chips implements Product{
    private static final ArrayList<String> chipOptions = new ArrayList<String>() {{
        add("Original");
        add("BBQ");
        add("Sour Cream & Onion");
        add("Salt & Vinegar");
        add("Jalapeño");
        add("Cheddar Cheese");
        add("Lime");
        add("Sea Salt");
        add("Kettle Cooked");
        add("Spicy Nacho");
        add("Flamin' Hot");
        add("Cool Ranch");
        add("Honey BBQ");
        add("Dill Pickle");
        add("Sweet Chili");
        add("Buffalo");
        add("Pretzels");
        add("Popcorn");
        add("Trail Mix");
        add("Granola Bar");
        add("Cookies");
        add("Crackers");
        add("Peanuts");
        add("Mixed Nuts");
    }};
    private String chosenChip;
    private final double price = 1.50;
    private int amountOfChips;

    public Chips(String chosenChip,int amountOfChips) {
        this.chosenChip = chosenChip;
        this.amountOfChips = amountOfChips;
    }

    public void getAllChips()
    {
        for(int i = 0; i < chipOptions.size();i++)
        {
            System.out.println("[" + i+1 + "] " + chipOptions.get(i));
        }
    }

    public String getChosenChip() {
        return chosenChip;
    }

    public int getAmountOfChips() {
        return amountOfChips;
    }

    @Override
    public double getPrice()
    {
        return this.price * getAmountOfChips();
    }

    public static ArrayList<String> getChipAllOptions() {
        return chipOptions;
    }

    public void setChosenChip(String chosenChip) {
        this.chosenChip = chosenChip;
    }

    public void setAmountOfChips(int amountOfChips) {
        this.amountOfChips = amountOfChips;
    }
}