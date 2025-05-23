package com.ps.Core;

public class Drinks implements Product{
    private final String[] drinkSizes = {"Small","Medium","Large"};
    private String selectedSize;
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

    @Override
    public double getTotalPrice(){
        switch (getSelectedSize().toLowerCase())
        {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
        }
        return 0.0;
    }
    public Drinks(String selectedSize, String selectedFlavor) {
        this.selectedSize = selectedSize;
        this.selectedFlavor = selectedFlavor;
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
