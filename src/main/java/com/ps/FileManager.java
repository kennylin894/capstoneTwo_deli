package com.ps;

import com.ps.Core.*;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileManager {

    public static double populateOrderSummary(JTextArea textArea, ArrayList<Product> currentOrder) {
        double totalPrice = 0;

        if (currentOrder.isEmpty()) {
            textArea.setText("No items in order.");
            return 0.0;
        }
        else
        {
            StringBuilder summary = new StringBuilder();
            summary.append("═══════════════════════════════════════\n");
            summary.append("           DELI-cious Receipt           \n");
            summary.append("═══════════════════════════════════════\n\n");
            boolean sandwichLabelPrinted = false;
            boolean drinkLabelPrinted = false;
            boolean chipLabelPrinted = false;
            int sandwichCount = 1;

            for (Product item : currentOrder) {
                if (item instanceof Sandwich) {
                    if (!sandwichLabelPrinted) {
                        summary.append("-----SANDWICHES-----\n");
                        sandwichLabelPrinted = true;
                    }
                    summary.append("Sandwich #").append(sandwichCount).append("\n");
                    summary.append("-------------------\n");
                    summary.append("Size: ").append(((Sandwich) item).getChoosenSize()).append("\"\n");
                    summary.append("Bread: ").append(((Sandwich) item).getChoosenBreadType()).append("\n");
                    if (((Sandwich) item).isToasted()) {
                        summary.append(" * Toasted\n");
                    }
                    summary.append("Toppings:\n");
                    for (Topping topping : ((Sandwich) item).getToppings()) {
                        if (topping.getName().equals("extra meat")) {
                            summary.append(" * Extra Meat\n");
                        } else if (topping.getName().equals("extra cheese")) {
                            summary.append(" * Extra Cheese\n");
                        } else {
                            summary.append("- ").append(topping.getName()).append("\n");
                        }
                    }
                    summary.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n\n");
                    sandwichCount++;
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Drinks) {
                    if (!drinkLabelPrinted) {
                        summary.append("-----DRINKS-----\n");
                        drinkLabelPrinted = true;
                    }
                    summary.append("Drink Order\n");
                    summary.append("-------------------\n");
                    summary.append("Flavor: ").append(((Drinks) item).getSelectedFlavor()).append("\n");
                    summary.append("Size: ").append(((Drinks) item).getSelectedSize()).append("\n");
                    summary.append("Quantity: ").append(((Drinks) item).getAmountOfDrinks()).append("\n");
                    summary.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n\n");
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    if (!chipLabelPrinted) {
                        summary.append("-----CHIPS-----\n");
                        chipLabelPrinted = true;
                    }
                    summary.append("Chips Order\n");
                    summary.append("-------------------\n");
                    summary.append("Flavor: ").append(((Chips) item).getChosenChip()).append("\n");
                    summary.append("Quantity: ").append(((Chips) item).getAmountOfChips()).append("\n");
                    summary.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n\n");
                    totalPrice += item.getPrice();
                }
            }
            summary.append("═══════════════════════════════════════\n");
            summary.append(String.format("TOTAL: $%.2f\n", totalPrice));
            summary.append("═══════════════════════════════════════\n");
            summary.append("Thank you for your order!\n");

            textArea.setText(summary.toString());
            return totalPrice;
        }
    }

    public static void generateReceipt(double totalPrice, ArrayList<Product> currentOrder) {
        try {
            File receiptsDir = new File("receipts");
            if (!receiptsDir.exists()) {
                receiptsDir.mkdirs();
            }
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String filename = "receipts/" + now.format(formatter) + ".txt";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write("═══════════════════════════════════════");
            bufferedWriter.newLine();
            bufferedWriter.write("           DELI-cious Receipt           ");
            bufferedWriter.newLine();
            bufferedWriter.write("═══════════════════════════════════════");
            bufferedWriter.newLine();
            bufferedWriter.write("Date: " + now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")));
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            boolean sandwichLabelPrinted = false;
            boolean drinkLabelPrinted = false;
            boolean chipLabelPrinted = false;
            int sandwichCount = 1;
            for (Product item : currentOrder) {
                if (item instanceof Sandwich) {
                    if (!sandwichLabelPrinted) {
                        bufferedWriter.write("-----SANDWICHES-----");
                        bufferedWriter.newLine();
                        sandwichLabelPrinted = true;
                    }
                    bufferedWriter.write("Sandwich #" + sandwichCount);
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Size: " + ((Sandwich) item).getChoosenSize() + "\"");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Bread: " + ((Sandwich) item).getChoosenBreadType());
                    bufferedWriter.newLine();
                    if (((Sandwich) item).isToasted()) {
                        bufferedWriter.write(" * Toasted");
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("Toppings:");
                    bufferedWriter.newLine();
                    for (Topping topping : ((Sandwich) item).getToppings()) {
                        if (topping.getName().equals("extra meat")) {
                            bufferedWriter.write(" * Extra Meat");
                            bufferedWriter.newLine();
                        } else if (topping.getName().equals("extra cheese")) {
                            bufferedWriter.write(" * Extra Cheese");
                            bufferedWriter.newLine();
                        } else {
                            bufferedWriter.write("- " + topping.getName());
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.write("Price: $" + String.format("%.2f", item.getPrice()));
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                    sandwichCount++;
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Drinks) {
                    if (!drinkLabelPrinted) {
                        bufferedWriter.write("-----DRINKS-----");
                        bufferedWriter.newLine();
                        drinkLabelPrinted = true;
                    }
                    bufferedWriter.write("Drink Order");
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Flavor: " + ((Drinks) item).getSelectedFlavor());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Size: " + ((Drinks) item).getSelectedSize());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Quantity: " + ((Drinks) item).getAmountOfDrinks());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price: $" + String.format("%.2f", item.getPrice()));
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    if (!chipLabelPrinted) {
                        bufferedWriter.write("-----CHIPS-----");
                        bufferedWriter.newLine();
                        chipLabelPrinted = true;
                    }
                    bufferedWriter.write("Chips Order");
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Flavor: " + ((Chips) item).getChosenChip());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Quantity: " + ((Chips) item).getAmountOfChips());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price: $" + String.format("%.2f", item.getPrice()));
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.write("═══════════════════════════════════════");
            bufferedWriter.newLine();
            bufferedWriter.write("TOTAL: $" + String.format("%.2f", totalPrice));
            bufferedWriter.newLine();
            bufferedWriter.write("═══════════════════════════════════════");
            bufferedWriter.newLine();
            bufferedWriter.write("Thank you for choosing DELI-cious!");
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error saving receipt: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}