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
        for(int i = 0; i < chipOptions.length-1;i++)
        {
            System.out.println("[" + i + "] " + chipOptions[i]);
        }
    }

    public String getChoosenChip() {
        return choosenChip;
    }

    public int getAmountOfChips() {
        return amountOfChips;
    }

    @Override
    public double getTotalPrice()
    {
        return this.price * getAmountOfChips();
    }
}