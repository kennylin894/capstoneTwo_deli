package com.ps.Core;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> cart;

    public Order() {
        cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }
}