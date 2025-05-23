package com.ps.Core;

public class RegularToppings implements Toppings{

    private final int[] sizes = {4,8,12};
    private final String[] toppings = {
            "lettuce",
            "peppers",
            "onions",
            "tomatoes",
            "jalapenos",
            "cucumbers",
            "pickles",
            "guacamole",
            "mushrooms"
    };
    private final String[] sauces = {
            "mayo",
            "mustard",
            "ketchup",
            "ranch",
            "thousand island",
            "vinaigrette"
    };
    private int chooseSize;
    private String choosenToppings;
    private String choosenSauces;

    @Override
    public double getTotalPrice()
    {
        return 0.0;
    }
}
