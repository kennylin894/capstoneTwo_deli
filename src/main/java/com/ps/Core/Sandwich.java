package com.ps.Core;

import java.util.ArrayList;
import java.util.Arrays;

public class Sandwich implements Product{
    private final static ArrayList<Integer> sizes = new ArrayList<>(Arrays.asList(4, 8, 12));

    private int choosenSize;
    private final static ArrayList<String> breadTypes = new ArrayList<>(Arrays.asList("white", "wheat", "rye", "wrap","italian"));
    private String choosenBreadType;
    private boolean isToasted;
    private ArrayList<Toppings> toppings;

    public Sandwich(int choosenSize, String choosenBreadType, boolean isToasted, ArrayList<Toppings> toppings) {
        this.choosenSize = choosenSize;
        this.choosenBreadType = choosenBreadType;
        this.isToasted = isToasted;
        this.toppings = toppings;
    }

    public static ArrayList<String> getAllBreadTypes()
    {
        return breadTypes;
    }

    public static ArrayList<Integer> getAllSizes() {
        return sizes;
    }

    public String getChoosenBreadType() {
        return choosenBreadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public int getChoosenSize() {
        return this.choosenSize;
    }

    public double getChoosenSizePrice() {
        switch (getChoosenSize())
        {
            case 4:
                return 5.50;
            case 8:
                return 7.00;
            case 12:
                return 8.50;
        }
        return 0.0;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public double getAllToppingsPrice()
    {
        double topppingTotal = 0.0;
        for(Toppings toppings1: toppings)
        {
            topppingTotal += toppings1.getPrice(getChoosenSize());
        }
        return topppingTotal;
    }

    @Override
    public double getPrice()
    {
        double total = 0;
        total += getChoosenSizePrice();
        total += getAllToppingsPrice();
        return total;
    }

    public void setChoosenSize(int choosenSize) {
        this.choosenSize = choosenSize;
    }

    public void setChoosenBreadType(String choosenBreadType) {
        this.choosenBreadType = choosenBreadType;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }
}