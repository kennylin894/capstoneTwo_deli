package com.ps.Core;

public abstract class Toppings {
    protected String name;
    protected boolean isPremium;

    public Toppings(String name, boolean isPremium) {
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