package com.ps.Core;

public class PremiumToppings implements Toppings{

    private final int[] sizes = {4,8,12};
    private final String[] meats = {
            "steak",
            "ham",
            "salami",
            "roast beef",
            "chicken",
            "bacon"
    };
    private final String[] cheeses = {
            "american",
            "provolone",
            "cheedar",
            "swiss"
    };
    private int choosenSize;
    private String choosenMeat;
    private String choosenCheese;
    private boolean extraMeat;
    private boolean extraCheese;



    @Override
    public double getTotalPrice()
    {
        return 0.0;
    }
}
