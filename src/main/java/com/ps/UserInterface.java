package com.ps;

import javax.swing.*;
import java.awt.*;

public class UserInterface {

    public static void initMainMenu()
    {
        JFrame frame = new JFrame("DELI-cious - Main menu *Made By: Kenny*");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        //making the background white
        Color logoBg = new Color(255, 255, 255);
        frame.getContentPane().setBackground(logoBg);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7,1,10,20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // DELI logo image
        ImageIcon icon = new ImageIcon("D:\\Edit\\Edit Pics\\image-imageonline.co-merged (1).png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(logoBg);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 30));
        leftPanel.setBackground(logoBg);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(imageLabel);
        frame.add(leftPanel, BorderLayout.WEST);

        //Buttons
        JButton menuButton = new JButton("View Menu");
        JButton orderSandwichButton = new JButton("Order Sandwhich");
        JButton orderChipsButton = new JButton("Order Chips");
        JButton orderDrinksButton = new JButton("Order Drinks");
        JButton viewCartButton = new JButton("View Cart");
        JButton checkoutButton = new JButton("Checkout");
        JButton exitButton = new JButton("Exit");
        Font menuFont = new Font("SansSerif", Font.BOLD, 13);

        JButton[] buttons = {
                menuButton, orderSandwichButton, orderChipsButton,
                orderDrinksButton, viewCartButton, checkoutButton, exitButton
        };
        //setting the color of buttons
        for (JButton button : buttons) {
            button.setFont(menuFont);
            button.setBackground(new Color(173, 216, 230));
        }

        //TODO: needs to display the menu/prices
        menuPanel.add(menuButton);

        //TODO: needs to be able to add sandwich to cart including all the toppings (can be more than 1 topping)
        menuPanel.add(orderSandwichButton);

        //TODO: needs to be able to order chips, more than 1 chip if needed.
        menuPanel.add(orderChipsButton);

        //TODO order drinks (more than 1)
        menuPanel.add(orderDrinksButton);

        //TODO: user can view the cart, and remove a sandwich if wanted
        //maybe edit a order, dont know how hard thatll be.
        menuPanel.add(viewCartButton);

        //TODO: prints reciept and checkout
        menuPanel.add(checkoutButton);

        //TODO: exits the program
        menuPanel.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(menuPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }
}
