package com.ps.Core;

import java.util.ArrayList;
import java.util.Arrays;

public class PremiumToppings extends Topping {
    private static final ArrayList<String> meatToppings = new ArrayList<>(Arrays.asList(
            "Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon", "extra meat"
    ));

    private static final ArrayList<String> cheeseToppings = new ArrayList<>(Arrays.asList(
            "American", "Provolone", "Cheddar", "Swiss", "extra cheese"
    ));

    private boolean extraMeat = false;
    private boolean extraCheese = false;

    public PremiumToppings(String name, boolean extra) {
        super(name, true);
        if (meatToppings.contains(name)) {
            this.extraMeat = extra;
        } else if (cheeseToppings.contains(name)) {
            this.extraCheese = extra;
        }
    }

    @Override
    public double getPrice(int sandwichSize) {
        double extraCheesePrice = 0;
        double extraMeatPrice = 0;
        if (isExtraCheese()) {
            switch (sandwichSize) {
                case 4:
                    extraCheesePrice = .30;
                    break;
                case 8:
                    extraCheesePrice = 0.60;
                    break;
                case 12:
                    extraCheesePrice = 0.90;
                    break;
            }
        }
        if (isExtraMeat()) {
            switch (sandwichSize) {
                case 4:
                    extraMeatPrice = .50;
                    break;
                case 8:
                    extraMeatPrice = 1.00;
                    break;
                case 12:
                    extraMeatPrice = 1.50;
                    break;
            }
        }
        if (meatToppings.contains(name) && !name.equals("extra meat")) {
            return getMeatPrice(sandwichSize) + extraMeatPrice;
        } else if (cheeseToppings.contains(name) && !name.equals("extra cheese")) {
            return getCheesePrice(sandwichSize) + extraCheesePrice;
        } else if (name.equals("extra meat")) {
            return extraMeatPrice;
        } else if (name.equals("extra cheese")) {
            return extraCheesePrice;
        }
        return 0.0;
    }

    public static double getMeatPrice(int sandwichSize) {
        switch (sandwichSize) {
            case 4:
                return 1.00;
            case 8:
                return 2.00;
            case 12:
                return 3.00;
            default:
                return 0.0;
        }
    }

    public static double getCheesePrice(int sandwichSize) {
        switch (sandwichSize) {
            case 4:
                return 0.75;
            case 8:
                return 1.50;
            case 12:
                return 2.25;
            default:
                return 0.0;
        }
    }

    public void setExtraMeat() {
        this.extraMeat = true;
    }

    public void setExtraCheese() {
        this.extraCheese = true;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public static ArrayList<String> getMeatToppings() {
        return meatToppings;
    }

    public static ArrayList<String> getCheeseToppings() {
        return cheeseToppings;
    }
}