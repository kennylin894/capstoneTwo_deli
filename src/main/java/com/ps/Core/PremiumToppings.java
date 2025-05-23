package com.ps.Core;

import java.util.ArrayList;

public class PremiumToppings extends Toppings{
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
            "cheddar",
            "swiss"
    };
    private String choosenMeat;
    private String choosenCheese;
    private boolean extraMeat;
    private boolean extraCheese;

    public PremiumToppings(int choosenSize, ArrayList<String> choosenToppings, ArrayList<String> choosenSauces) {
        super(choosenSize, choosenToppings, choosenSauces);
    }

    public void getAllMeats()
    {
        for(int i = 0; i < meats.length;i++)
        {
            System.out.println("[" + i+1 + "] " + meats[i]);
        }
    }

    public String getChoosenMeat() {
        return choosenMeat;
    }

    public String getChoosenCheese() {
        return choosenCheese;
    }

    public boolean isThereExtraMeat() {
        return extraMeat;
    }

    public boolean isThereExtraCheese() {
        return extraCheese;
    }

    public void getAllCheeses()
    {
        for(int i = 0; i < cheeses.length;i++)
        {
            System.out.println("[" + i+1 + "] " + cheeses[i]);
        }
    }

    public double getMeatPrice()
    {
        double total = 0;
        if(getChoosenSize() == 4)
        {
            total += 1.00;
            if(isThereExtraMeat())
            {
                total += .50;
            }
        }
        else if(getChoosenSize() == 8)
        {
            total += 2.00;
            if(isThereExtraMeat())
            {
                total += 1.00;
            }
        }
        else if(getChoosenSize() == 12)
        {
            total += 3.00;
            if(isThereExtraMeat())
            {
                total += 1.50;
            }
        }
        return total;
    }

    public double getCheesePrice()
    {
        double total = 0;
        if(getChoosenSize() == 4)
        {
            total += .75;
            if(isThereExtraCheese())
            {
                total += .30;
            }
        }
        else if(getChoosenSize() == 8)
        {
            total += 1.50;
            if(isThereExtraCheese())
            {
                total += .60;
            }
        }
        else if(getChoosenSize() == 12)
        {
            total += 2.25;
            if(isThereExtraCheese())
            {
                total += .90;
            }
        }
        return total;
    }

    @Override
    public double getTotalPrice()
    {
        return getMeatPrice() + getCheesePrice();
    }
}