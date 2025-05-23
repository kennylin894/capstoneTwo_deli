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

    @Override
    public double getTotalPrice()
    {
        return this.price;
    }
}
