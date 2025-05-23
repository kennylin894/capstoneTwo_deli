package com.ps.Core;

public class Chips implements Product{
    private final String[] chipOptions = {
            "Original",
            "BBQ",
            "Sour Cream & Onion",
            "Salt & Vinegar",
            "Jalapeño",
            "Cheddar Cheese",
            "Lime",
            "Sea Salt",
            "Kettle Cooked",
            "Spicy Nacho"
    };
    private String choosenChip;
    private final double price = 1.50;
    private int amountOfChips;

    public Chips(String choosenChip,int amountOfChips) {
        this.choosenChip = choosenChip;
        this.amountOfChips = amountOfChips;
    }

    public void getAllChips()
    {
        for(int i = 0; i < chipOptions.length;i++)
        {
            System.out.println("[" + i+1 + "] " + chipOptions[i]);
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