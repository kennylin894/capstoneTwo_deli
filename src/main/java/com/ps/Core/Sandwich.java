package com.ps.Core;

import java.util.ArrayList;

public class Sandwich implements Product{
    private final int[] breadSizes = {4,8,12};
    private int choosenSize;
    private final String[] breadTypes = {"white","wheat","rye","wrap"};
    private String choosenBreadType;
    private boolean isToasted;
    private ArrayList<Toppings> toppings;

    public void getBreadSizes()
    {
        System.out.println("These are the bread sizes we have: ");
        System.out.println("Size: 4in'      Price: $4.00");
        System.out.println("Size: 8in'      Price: $7.00");
        System.out.println("Size: 12in'     Price: $8.50");
    }

    public void getAllBreadTypes()
    {
        for(int i = 0; i < breadTypes.length-1;i++)
        {
            System.out.println("[" + i + "] " + breadTypes[i]);
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

    @Override
    public double getTotalPrice()
    {
        return 0.0;
    }
}