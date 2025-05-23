package com.ps.Core;

import java.util.ArrayList;

public abstract class Toppings{
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
    private int choosenSize;
    private ArrayList<String> choosenToppings;
    private ArrayList<String> choosenSauces;

    public Toppings(int choosenSize, ArrayList<String> choosenToppings, ArrayList<String> choosenSauces) {
        this.choosenSize = choosenSize;
        this.choosenToppings = choosenToppings;
        this.choosenSauces = choosenSauces;
    }

    public int getChoosenSize() {
        return choosenSize;
    }

    public abstract double getTotalPrice();
}