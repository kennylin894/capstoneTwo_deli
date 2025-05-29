package com.ps.Core;


import java.util.ArrayList;
import java.util.Arrays;

public class FreeToppings extends Toppings {
    private static final ArrayList<String> regularToppings = new ArrayList<>(Arrays.asList(
            "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
            "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
    ));

    private static final ArrayList<String> sauceToppings = new ArrayList<>(Arrays.asList(
            "Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Isl", "Vinaigrette"
    ));

    private static final ArrayList<String> sideToppings = new ArrayList<>(Arrays.asList(
            "Au Jus", "Sauce"
    ));


    public FreeToppings(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0.0;
    }

    public static ArrayList<String> getToppings() {
        return regularToppings;
    }

    public static ArrayList<String> getSauceToppings() {
        return sauceToppings;
    }

    public static ArrayList<String> getSideToppings() {
        return sideToppings;
    }
}