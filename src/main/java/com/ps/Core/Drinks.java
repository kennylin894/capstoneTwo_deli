package com.ps.Core;

import java.util.ArrayList;

public class Drinks implements Product {
    private String selectedSize;
    private int amountOfDrinks = 1;
    private final ArrayList<String> flavors = new ArrayList<String>() {{
        add("Cola");
        add("Diet Cola");
        add("Root Beer");
        add("Lemon-Lime");
        add("Orange Soda");
        add("Iced Tea");
        add("Lemonade");
        add("Fruit Punch");
        add("Ginger Ale");
        add("Water");
    }};
    private String selectedFlavor;

    public Drinks(String selectedSize, int amountOfDrinks, String selectedFlavor) {
        this.selectedSize = selectedSize;
        this.amountOfDrinks = amountOfDrinks;
        this.selectedFlavor = selectedFlavor;
    }

    @Override
    public double getPrice() {
        switch (getSelectedSize().toLowerCase()) {
            case "small":
                return getAmountOfDrinks() * 2.00;
            case "medium":
                return getAmountOfDrinks() * 2.50;
            case "large":
                return getAmountOfDrinks() * 3.00;
        }
        return 0.0;
    }

    public int getAmountOfDrinks() {
        return amountOfDrinks;
    }

    public void getAllFlavors() {
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println("[" + i + 1 + "] " + flavors.get(i));
        }
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    public String getSelectedFlavor() {
        return selectedFlavor;
    }

    public void setSelectedFlavor(String selectedFlavor) {
        this.selectedFlavor = selectedFlavor;
    }
}