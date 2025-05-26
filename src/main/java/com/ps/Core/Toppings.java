package com.ps.Core;

import java.util.ArrayList;
import java.util.List;

public abstract class Toppings{
    private final static ArrayList<Integer> sizes = new ArrayList<>(List.of(4, 8, 12));
    private final static ArrayList<String> toppings = new ArrayList<>(List.of(
            "lettuce",
            "peppers",
            "onions",
            "tomatoes",
            "jalapenos",
            "cucumbers",
            "pickles",
            "guacamole",
            "mushrooms"
    ));
    private final static ArrayList<String> sauces = new ArrayList<>(List.of(
            "mayo",
            "mustard",
            "ketchup",
            "ranch",
            "thousand island",
            "vinaigrette"
    ));
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

    public static ArrayList<String> getToppings() {
        return toppings;
    }

    public static ArrayList<String> getSauceToppings() {
        return sauces;
    }

}