package com.ps.Core;

public abstract class Topping {
    protected String name;
    protected boolean isPremium;

    public Topping(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public abstract double getPrice(int sandwichSize);

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }
}