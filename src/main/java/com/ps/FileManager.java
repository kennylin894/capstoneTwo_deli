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
                        summary.append("-----Sandwiches-----\n");
                        sandwichLabelPrinted = true;
                    }
                    if(((Sandwich) item).getSandwichName().equals("custom"))
                    {
                        summary.append("Sandwich #" + sandwichCount).append("\n");
                    }
                    else
                    {
                        summary.append(((Sandwich) item).getSandwichName()).append("\n");
                    }
                    summary.append("-------------------\n");
                    summary.append("Size: ").append(((Sandwich) item).getChoosenSize()).append("'\n");
                    summary.append("Bread: ").append(((Sandwich) item).getChoosenBreadType()).append("\n");
                    if (((Sandwich) item).isToasted()) {
                        summary.append(" * is Toasted\n");
                    }
                    summary.append("Toppings\n");
                    summary.append("===================\n");
                    for (Toppings toppings : ((Sandwich) item).getToppings()) {
                        if (toppings instanceof PremiumToppings) {
                            summary.append("- ").append(toppings.getName()).append("\n");
                            if (((PremiumToppings) toppings).isExtraMeat()) {
                                summary.append(" * extra meat(s)").append("\n");
                            }
                            if (((PremiumToppings) toppings).isExtraCheese()) {
                                summary.append(" * extra cheese(s)").append("\n");
                            }
                        } else {
                            summary.append("- " + toppings.getName()).append("\n");
                        }
                    }
                    summary.append("-------------------\n");
                    summary.append("Price : $").append(String.format("%.2f", item.getPrice())).append("\n");
                    summary.append("-------------------\n");
                    sandwichCount++;
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Drinks) {
                    if (!drinkLabelPrinted) {
                        summary.append("------Drinks-------\n");
                        drinkLabelPrinted = true;
                    }
                    summary.append("Drinks\n");
                    summary.append("-------------------\n");
                    summary.append("Flavor: ").append(((Drinks) item).getSelectedFlavor()).append("\n");
                    summary.append("Size: ").append(((Drinks) item).getSelectedSize()).append("\n");
                    summary.append("Quantity: ").append(((Drinks) item).getAmountOfDrinks()).append("\n");
                    summary.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n");
                    summary.append("-------------------\n");
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    if (!chipLabelPrinted) {
                        summary.append("-------Chips-------\n");
                        chipLabelPrinted = true;
                    }
                    summary.append("Chips\n");
                    summary.append("-------------------\n");
                    summary.append("Flavor: ").append(((Chips) item).getChosenChip()).append("\n");
                    summary.append("Quantity: ").append(((Chips) item).getAmountOfChips()).append("\n");
                    summary.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n");
                    summary.append("-------------------\n");
                    totalPrice += item.getPrice();
                }
            }
            if (totalPrice >= 10.00) {
                summary.append("╔═════════════════════════╗\n");
                summary.append(String.format("║    TOTAL: $%.2f     ║\n", totalPrice));
                summary.append("╚═════════════════════════╝\n");
            } else {
                summary.append("╔═════════════════════════╗\n");
                summary.append(String.format("║    TOTAL: $%.2f      ║\n", totalPrice));
                summary.append("╚═════════════════════════╝\n");
            }
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
                        bufferedWriter.write("-----Sandwiches-----");
                        bufferedWriter.newLine();
                        sandwichLabelPrinted = true;
                    }
                    if(((Sandwich) item).getSandwichName().equals("custom"))
                    {
                        bufferedWriter.write("Sandwich #" + sandwichCount);
                        bufferedWriter.newLine();
                    }
                    else
                    {
                        bufferedWriter.write(((Sandwich) item).getSandwichName());
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Size: " + ((Sandwich) item).getChoosenSize() + "'");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Bread: " + ((Sandwich) item).getChoosenBreadType());
                    bufferedWriter.newLine();
                    if (((Sandwich) item).isToasted()) {
                        bufferedWriter.write(" * is Toasted");
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("Toppings");
                    bufferedWriter.newLine();
                    bufferedWriter.write("===================");
                    bufferedWriter.newLine();
                    for (Toppings toppings : ((Sandwich) item).getToppings()) {
                        if (toppings instanceof PremiumToppings) {
                            bufferedWriter.write("- " + toppings.getName());
                            bufferedWriter.newLine();
                            if (((PremiumToppings) toppings).isExtraMeat()) {
                                bufferedWriter.write(" * extra meat(s)");
                                bufferedWriter.newLine();
                            }
                            if (((PremiumToppings) toppings).isExtraCheese()) {
                                bufferedWriter.write(" * extra cheese(s)");
                                bufferedWriter.newLine();
                            }
                        } else {
                            bufferedWriter.write("- " + toppings.getName());
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price : $" + String.format("%.2f", item.getPrice()));
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    sandwichCount++;
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Drinks) {
                    if (!drinkLabelPrinted) {
                        bufferedWriter.write("------Drinks-------");
                        bufferedWriter.newLine();
                        drinkLabelPrinted = true;
                    }
                    bufferedWriter.write("Drinks");
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
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    if (!chipLabelPrinted) {
                        bufferedWriter.write("-------Chips-------");
                        bufferedWriter.newLine();
                        chipLabelPrinted = true;
                    }
                    bufferedWriter.write("Chips");
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Flavor: " + ((Chips) item).getChosenChip());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Quantity: " + ((Chips) item).getAmountOfChips());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Price: $" + String.format("%.2f", item.getPrice()));
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                }
            }
            if (totalPrice >= 10.00) {
                bufferedWriter.write("╔═════════════════════════╗");
                bufferedWriter.newLine();
                bufferedWriter.write(String.format("║    TOTAL: $%.2f        ║", totalPrice));
                bufferedWriter.newLine();
                bufferedWriter.write("╚═════════════════════════╝");
                bufferedWriter.newLine();
            } else {
                bufferedWriter.write("╔═════════════════════════╗");
                bufferedWriter.newLine();
                bufferedWriter.write(String.format("║    TOTAL: $%.2f         ║", totalPrice));
                bufferedWriter.newLine();
                bufferedWriter.write("╚═════════════════════════╝");
                bufferedWriter.newLine();
            }
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