package com.ps.Core;

public class Drinks implements Product{
    private final String[] drinkSizes = {"Small","Medium","Large"};
    private String selectedSize;
    private int amountOfDrinks;
    private final String[] flavors = {
            "Cola",
            "Diet Cola",
            "Root Beer",
            "Lemon-Lime",
            "Orange Soda",
            "Iced Tea",
            "Lemonade",
            "Fruit Punch",
            "Ginger Ale",
            "Water"
    };
    private String selectedFlavor;

    public Drinks(String selectedSize, int amountOfDrinks, String selectedFlavor) {
        this.selectedSize = selectedSize;
        this.amountOfDrinks = amountOfDrinks;
        this.selectedFlavor = selectedFlavor;
    }

    @Override
    public double getPrice(){
        switch (getSelectedSize().toLowerCase())
        {
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

    public void getAllFlavors()
    {
        for(int i = 0; i < flavors.length;i++)
        {
            System.out.println("[" + i+1 + "] " + flavors[i]);
        }
    }

    public void getDrinkSizes()
    {
        System.out.println("These are the drink sizes we have: ");
        System.out.println("Size: Small'      Price: $2.00");
        System.out.println("Size: Medium'      Price: $2.50");
        System.out.println("Size: Large'     Price: $3.00");
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