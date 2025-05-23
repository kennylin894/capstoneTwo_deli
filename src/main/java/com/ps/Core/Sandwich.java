package com.ps.Core;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product{
    private final ArrayList<Integer> breadSizes = new ArrayList<>(List.of(4, 8, 12));
    private int choosenSize;
    private final String[] breadTypes = {"white","wheat","rye","wrap"};
    private String choosenBreadType;
    private boolean isToasted;
    private ArrayList<Toppings> toppings;

    public Sandwich(int choosenSize, String choosenBreadType, boolean isToasted, ArrayList<Toppings> toppings) {
        this.choosenSize = choosenSize;
        this.choosenBreadType = choosenBreadType;
        this.isToasted = isToasted;
        this.toppings = toppings;
    }

    public void getBreadSizes()
    {
        System.out.println("These are the bread sizes we have: ");
        System.out.println("Size: 4in'      Price: $4.00");
        System.out.println("Size: 8in'      Price: $7.00");
        System.out.println("Size: 12in'     Price: $8.50");
    }

    public void getAllBreadTypes()
    {
        for(int i = 0; i < breadTypes.length;i++)
        {
            System.out.println("[" + i+1 + "] " + breadTypes[i]);
        }
    }

    public String getChoosenBreadType() {
        return choosenBreadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public int getChoosenSize() {
        return choosenSize;
    }

    public double getChoosenSizePrice() {
        switch (getChoosenSize())
        {
            case 4:
                return 4.00;
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
        double total = 0.00;
        for(Toppings toppings1 : getToppings())
        {
            total += toppings1.getTotalPrice();
        }
        return total;
    }

    @Override
    public double getPrice()
    {
        double total = 0;
        total += getChoosenSizePrice();
        total += getAllToppingsPrice();
        return total;
    }
}