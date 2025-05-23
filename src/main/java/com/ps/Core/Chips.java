package com.ps.Core;

import java.util.ArrayList;

public class Chips implements Product{
    private final ArrayList<String> chipOptions = new ArrayList<String>() {{
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
    }};
    private String choosenChip;
    private final double price = 1.50;
    private int amountOfChips;

    public Chips(String choosenChip,int amountOfChips) {
        this.choosenChip = choosenChip;
        this.amountOfChips = amountOfChips;
    }

    public void getAllChips()
    {
        for(int i = 0; i < chipOptions.size();i++)
        {
            System.out.println("[" + i+1 + "] " + chipOptions.get(i));
        }
    }

    public String getChoosenChip() {
        return choosenChip;
    }

    public int getAmountOfChips() {
        return amountOfChips;
    }

    @Override
    public double getPrice()
    {
        return this.price * getAmountOfChips();
    }
}