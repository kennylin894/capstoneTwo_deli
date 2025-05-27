package com.ps;

import com.ps.Core.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class UserInterface {

    private static JFrame mainFrame;
    private static ArrayList<Product> currentOrder = new ArrayList<>();

    private UserInterface() {
        System.out.println("Object be created.");
    }

    public static void mainMenuBluePrint() {
        mainFrame.setSize(650, 600);
        mainFrame.setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - mainFrame.getWidth()) / 2;
        int y = (screenSize.height - mainFrame.getHeight()) / 2;
        mainFrame.setLocation(x, y);

        //making the background white
        Color logoBg = new Color(255, 255, 255);
        mainFrame.getContentPane().setBackground(logoBg);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7, 1, 10, 20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // DELI logo image
        ImageIcon icon = new ImageIcon("src/main/resources/images/logo.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 70, 30, 30));
        leftPanel.setBackground(logoBg);
        leftPanel.add(imageLabel);
        mainFrame.add(leftPanel, BorderLayout.WEST);

        //Buttons
        JButton menuButton = new JButton("View Menu");
        JButton orderYourOwnSandwichButton = new JButton("BYO Sandwich");
        JButton orderPreMadeSandwich = new JButton("Order Sandwiches");
        JButton orderChipsButton = new JButton("Order Chips");
        JButton orderDrinksButton = new JButton("Order Drinks");
        JButton viewCheckoutCartButton = new JButton("View Cart/Checkout");
        JButton exitButton = new JButton("Exit");
        Font menuFont = new Font("SansSerif", Font.BOLD, 13);

        JButton[] buttons = {
                menuButton, orderYourOwnSandwichButton, orderPreMadeSandwich, orderChipsButton,
                orderDrinksButton, viewCheckoutCartButton, exitButton
        };
        //setting the color of buttons
        for (JButton button : buttons) {
            button.setFont(menuFont);
            button.setBackground(new Color(173, 216, 230));
        }

        menuPanel.add(menuButton);
        menuButton.addActionListener(e -> showMenuScreen());

        menuPanel.add(orderYourOwnSandwichButton);
        orderYourOwnSandwichButton.addActionListener(e -> showOrderSandwichScreen());

        //TODO : premade sandwiches (BONUS)
        menuPanel.add(orderPreMadeSandwich);

        //TODO: needs to be able to order chips, more than 1 chip if needed.
        menuPanel.add(orderChipsButton);

        //TODO order drinks (more than 1)
        menuPanel.add(orderDrinksButton);
        orderDrinksButton.addActionListener(e -> showOrderDrinksScreen());

        //TODO: user can view the cart, and remove a sandwich if wanted
        //maybe edit a order, dont know how hard thatll be.
        // TODO: prints reciept and checkout
        menuPanel.add(viewCheckoutCartButton);
        viewCheckoutCartButton.addActionListener(e -> showViewCartMenu());

        menuPanel.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
        mainFrame.add(menuPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }

    public static void initMainMenu() {
        mainFrame = new JFrame("DELI-cious - Main menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuBluePrint();
    }

    public static void newinitMainMenu() {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuBluePrint();
    }

    private static void showMenuScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel foodMenuScreen = new JPanel(new BorderLayout());
        foodMenuScreen.setBackground(Color.WHITE);

        JLabel menuTitle = new JLabel("Menu", SwingConstants.CENTER);
        menuTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        foodMenuScreen.add(menuTitle, BorderLayout.NORTH);

        // Scrollable text area
        JTextArea menuTextArea = new JTextArea();
        menuTextArea.setEditable(false);
        menuTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        menuTextArea.setText("""
                +--------------------------------------------------------------+
                |                   BUILD YOUR OWN SANDWICH                    |
                +------------------+----------+----------+----------+----------+
                | Category         |   Item   |   4"     |   8"     |   12"    |
                +------------------+----------+----------+----------+----------+
                | Base Sandwich    |          |  $5.50   |  $7.00   |  $8.50   |
                +------------------+----------+----------+----------+----------+
                | Bread Choices    | White    |          |          |          |
                |                  | Wheat    |          |          |          |
                |                  | Rye      |          |          |          |
                |                  | Wrap     |          |          |          |
                +------------------+----------+----------+----------+----------+
                | Meats            | Steak    |  $1.00   |  $2.00   |  $3.00   |
                |                  | Ham      |  $1.00   |  $2.00   |  $3.00   |
                |                  | Salami   |  $1.00   |  $2.00   |  $3.00   |
                |                  | Roast Bf |  $1.00   |  $2.00   |  $3.00   |
                |                  | Chicken  |  $1.00   |  $2.00   |  $3.00   |
                |                  | Bacon    |  $1.00   |  $2.00   |  $3.00   |
                | Extra Meat       |    +     |  $0.50   |  $1.00   |  $1.50   |
                +------------------+----------+----------+----------+----------+
                | Cheese           | American |  $0.75   |  $1.50   |  $2.25   |
                |                  | Provolone|  $0.75   |  $1.50   |  $2.25   |
                |                  | Cheddar  |  $0.75   |  $1.50   |  $2.25   |
                |                  | Swiss    |  $0.75   |  $1.50   |  $2.25   |
                | Extra Cheese     |    +     |  $0.30   |  $0.60   |  $0.90   |
                +------------------+----------+----------+----------+----------+
                | Toppings (Free)  | Lettuce  |          |          |          |
                |                  | Peppers  |          |          |          |
                |                  | Onions   |          |          |          |
                |                  | Tomatoes |          |          |          |
                |                  | Jalapeños|          |          |          |
                |                  | Cucumbers|          |          |          |
                |                  | Pickles  |          |          |          |
                |                  | Guac     |          |          |          |
                |                  | Mushrooms|          |          |          |
                +------------------+----------+----------+----------+----------+
                | Sauces (Free)    | Mayo     |          |          |          |
                |                  | Mustard  |          |          |          |
                |                  | Ketchup  |          |          |          |
                |                  | Ranch    |          |          |          |
                |                  | 1000 Isl.|          |          |          |
                |                  | Vinaigret|          |          |          |
                +------------------+----------+----------+----------+----------+
                | Sides (Free)     | Au Jus   |          |          |          |
                |                  | Sauce    |          |          |          |
                +------------------+----------+----------+----------+----------+
                |                            Drinks                            |
                +------------------+----------+----------+----------+----------+
                |         Sizes         |  Small     |  Medium    |  Large     |
                +------------------+----------+----------+----------+----------+
                | Cola                  |  $2.00     |  $2.50     |  $3.00     |
                | Diet Cola             |  $2.00     |  $2.50     |  $3.00     |
                | Root Beer             |  $2.00     |  $2.50     |  $3.00     |
                | Lemon-Lime            |  $2.00     |  $2.50     |  $3.00     |
                | Orange Soda           |  $2.00     |  $2.50     |  $3.00     |
                | Iced Tea              |  $2.00     |  $2.50     |  $3.00     |
                | Lemonade              |  $2.00     |  $2.50     |  $3.00     |
                | Fruit Punch           |  $2.00     |  $2.50     |  $3.00     |
                | Ginger Ale            |  $2.00     |  $2.50     |  $3.00     |
                | Water                 |  $2.00     |  $2.50     |  $3.00     |
                +------------------+----------+----------+----------+----------+
                |                            Chips                             |
                +------------------+----------+----------+----------+----------+
                | Original             |  $1.50                                |
                | BBQ                  |  $1.50                                |
                | Sour Cream & Onion   |  $1.50                                |
                | Salt & Vinegar       |  $1.50                                |
                | Jalapeño             |  $1.50                                |
                | Cheddar Cheese       |  $1.50                                |
                | Lime                 |  $1.50                                |
                | Sea Salt             |  $1.50                                |
                | Kettle Cooked        |  $1.50                                |
                | Spicy Nacho          |  $1.50                                |
                +------------------+----------+----------+----------+----------+
                """);
        JScrollPane scrollPane = new JScrollPane(menuTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        foodMenuScreen.add(scrollPane, BorderLayout.CENTER);
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(173, 216, 230));
        backButton.addActionListener(e -> newinitMainMenu());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(backButton);
        foodMenuScreen.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.getContentPane().add(foodMenuScreen);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private static void showOrderSandwichScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel orderSandwichScreen = new JPanel();
        orderSandwichScreen.setLayout(new BoxLayout(orderSandwichScreen, BoxLayout.Y_AXIS));
        orderSandwichScreen.setBackground(Color.WHITE);
        orderSandwichScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel titleLabel = new JLabel("Build Your Own Sandwich");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderSandwichScreen.add(titleLabel);
        orderSandwichScreen.add(Box.createRigidArea(new Dimension(0, 15)));

        //sandwich size option dropdown UI
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
        sizePanel.setBackground(Color.WHITE);
        sizePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sizeOptionsLabel = new JLabel("Choose Size (inches):");
        sizeOptionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JComboBox<Integer> sizeOptionsBox = new JComboBox<>(Sandwich.getAllSizes().toArray(new Integer[0]));
        sizeOptionsBox.setSelectedItem(4);
        sizeOptionsBox.setMaximumSize(new Dimension(300, 30));
        sizeOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        sizePanel.add(sizeOptionsLabel);
        sizePanel.add(sizeOptionsBox);
        sizePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        orderSandwichScreen.add(sizePanel);

        //bread option dropdown UI
        JPanel breadPanel = new JPanel();
        breadPanel.setLayout(new BoxLayout(breadPanel, BoxLayout.Y_AXIS));
        breadPanel.setBackground(Color.WHITE);
        breadPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel breadOptionsLabel = new JLabel("Choose Bread:");
        breadOptionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JComboBox breadOptionsBox = new JComboBox<>(Sandwich.getAllBreadTypes().toArray(new String[0]));
        breadOptionsBox.setSelectedItem("White");
        breadOptionsBox.setMaximumSize(new Dimension(300, 30));
        breadOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        breadPanel.add(breadOptionsLabel);
        breadPanel.add(breadOptionsBox);


        JCheckBox toastedCheckBox = new JCheckBox("Is Toasted");
        toastedCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        toastedCheckBox.setOpaque(false);
        breadPanel.add(toastedCheckBox);

        breadPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        orderSandwichScreen.add(breadPanel);

        //add 5 columns
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new GridLayout(1, 5, 10, 0));

        ArrayList<JCheckBox> meatCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> cheeseCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> toppingCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> sauceCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> sidesCheckBoxes = new ArrayList<>();

        //Meats
        JPanel meatsPanel = new JPanel();
        meatsPanel.setLayout(new BoxLayout(meatsPanel, BoxLayout.Y_AXIS));
        meatsPanel.setBackground(Color.WHITE);
        meatsPanel.setBorder(BorderFactory.createTitledBorder("Meats"));
        for (String meat : PremiumToppings.getMeatToppings()) {
            JCheckBox cb = new JCheckBox(meat);
            cb.setOpaque(false);
            meatsPanel.add(cb);
            meatCheckBoxes.add(cb);
        }

        //cheese
        JPanel cheesesPanel = new JPanel();
        cheesesPanel.setLayout(new BoxLayout(cheesesPanel, BoxLayout.Y_AXIS));
        cheesesPanel.setBackground(Color.WHITE);
        cheesesPanel.setBorder(BorderFactory.createTitledBorder("Cheeses"));
        for (String cheese : PremiumToppings.getCheeseToppings()) {
            JCheckBox cb = new JCheckBox(cheese);
            cheesesPanel.add(cb);
            cb.setOpaque(false);
            cheeseCheckBoxes.add(cb);
        }

        //normal toppings
        JPanel normalToppingsPanel = new JPanel();
        normalToppingsPanel.setLayout(new BoxLayout(normalToppingsPanel, BoxLayout.Y_AXIS));
        normalToppingsPanel.setBackground(Color.WHITE);
        normalToppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        for (String topping : Toppings.getToppings()) {
            JCheckBox cb = new JCheckBox(topping);
            cb.setOpaque(false);
            normalToppingsPanel.add(cb);
            toppingCheckBoxes.add(cb);
        }

        //sauces
        JPanel saucesPanel = new JPanel();
        saucesPanel.setLayout(new BoxLayout(saucesPanel, BoxLayout.Y_AXIS));
        saucesPanel.setBackground(Color.WHITE);
        saucesPanel.setBorder(BorderFactory.createTitledBorder("Sauces"));
        for (String sauce : Toppings.getSauceToppings()) {
            JCheckBox cb = new JCheckBox(sauce);
            cb.setOpaque(false);
            saucesPanel.add(cb);
            sauceCheckBoxes.add(cb);
        }

        //sides
        JPanel sidesPanel = new JPanel();
        sidesPanel.setLayout(new BoxLayout(sidesPanel, BoxLayout.Y_AXIS)); // Fixed: changed saucesPanel to sidesPanel
        sidesPanel.setBackground(Color.WHITE);
        sidesPanel.setBorder(BorderFactory.createTitledBorder("Sides"));
        for (String sides : Toppings.getSideToppings()) {
            JCheckBox cb = new JCheckBox(sides);
            cb.setOpaque(false);
            sidesPanel.add(cb);
            sidesCheckBoxes.add(cb);
        }

        toppingsPanel.add(meatsPanel);
        toppingsPanel.add(cheesesPanel);
        toppingsPanel.add(normalToppingsPanel);
        toppingsPanel.add(saucesPanel);
        toppingsPanel.add(sidesPanel);

        meatsPanel.setOpaque(false);
        cheesesPanel.setOpaque(false);
        toppingsPanel.setOpaque(false);
        saucesPanel.setOpaque(false);
        sidesPanel.setOpaque(false);

        //fixed very long vertical columns
        toppingsPanel.setMaximumSize(toppingsPanel.getPreferredSize());

        orderSandwichScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        orderSandwichScreen.add(toppingsPanel);
        orderSandwichScreen.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //cancel order and add buttons
        int buttonSpacing = 15;
        JButton addToCartButton = new JButton("Add to Cart");
        JButton cancelOrderButton = new JButton("Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            Integer selectedSize = (Integer) sizeOptionsBox.getSelectedItem();
            String selectedBread = (String) breadOptionsBox.getSelectedItem();
            boolean isToasted = false;
            if (toastedCheckBox.isSelected()) {
                isToasted = true;
            }
            ArrayList<String> toppings = new ArrayList<>();
            ArrayList<Topping> actualToppings = new ArrayList<>();
            boolean hasMeats = false;
            for (JCheckBox cb : meatCheckBoxes) {
                if (cb.isSelected()) {
                    hasMeats = true;
                    toppings.add(cb.getText());
                }
            }
            boolean hasCheese = false;
            for (JCheckBox cb : cheeseCheckBoxes) {
                if (cb.isSelected()) {
                    hasCheese = true;
                    toppings.add(cb.getText());
                }
            }
            boolean hasToppings = false;
            for (JCheckBox cb : toppingCheckBoxes) {
                if (cb.isSelected()) {
                    hasToppings = true;
                    toppings.add(cb.getText());
                }
            }
            boolean hasSauce = false;
            for (JCheckBox cb : sauceCheckBoxes) {
                if (cb.isSelected()) {
                    hasSauce = true;
                    toppings.add(cb.getText());
                }
            }
            boolean hasSides = false;
            for (JCheckBox cb : sidesCheckBoxes) {
                if (cb.isSelected()) {
                    hasSides = true;
                    toppings.add(cb.getText());
                }
            }
            for (String i : toppings) {
                if (Toppings.getToppings().contains(i)) {
                    actualToppings.add(new Toppings(i));
                }
                if (Toppings.getSideToppings().contains(i)) {
                    actualToppings.add(new Toppings(i));
                }
                if (Toppings.getSauceToppings().contains(i)) {
                    actualToppings.add(new Toppings(i));
                }
                if (PremiumToppings.getCheeseToppings().contains(i)) {
                    if (i.equals("extra cheese")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
                if (PremiumToppings.getMeatToppings().contains(i)) {
                    if (i.equals("extra meat")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
            }
            Sandwich sandwich = new Sandwich(selectedSize, selectedBread, isToasted, actualToppings);
            currentOrder.add(sandwich);
            if (!hasMeats) {
                JOptionPane.showMessageDialog(mainFrame, "Your order has no meats!", "No Meats", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!hasCheese) {
                JOptionPane.showMessageDialog(mainFrame, "Your order has no cheeses!", "No Cheeses", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!hasToppings) {
                JOptionPane.showMessageDialog(mainFrame, "Your order has no toppings!", "No Toppings", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!hasSauce) {
                JOptionPane.showMessageDialog(mainFrame, "Your order has no sauces!", "No Sauces", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!hasSides) {
                JOptionPane.showMessageDialog(mainFrame, "Your order has no sides!", "No Sauces", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(mainFrame, "Order was added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            newinitMainMenu();
        });

        //cancelling the order
        cancelOrderButton.addActionListener(e -> {
            newinitMainMenu();
        });
        int maxWidth = Math.max(addToCartButton.getPreferredSize().width, cancelOrderButton.getPreferredSize().width);
        int maxHeight = Math.max(addToCartButton.getPreferredSize().height, cancelOrderButton.getPreferredSize().height);
        Dimension maxSize = new Dimension(maxWidth, maxHeight);
        addToCartButton.setMaximumSize(maxSize);
        cancelOrderButton.setMaximumSize(maxSize);
        buttonsPanel.add(addToCartButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, buttonSpacing)));
        buttonsPanel.add(cancelOrderButton);

        orderSandwichScreen.add(Box.createRigidArea(new Dimension(0, 15)));
        orderSandwichScreen.add(buttonsPanel);
        orderSandwichScreen.add(Box.createRigidArea(new Dimension(0, 10)));

        mainFrame.getContentPane().add(orderSandwichScreen);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void addChipsMenu() {
        //TODO
    }

    private static void showOrderDrinksScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel orderDrinksScreen = new JPanel();
        orderDrinksScreen.setLayout(new BoxLayout(orderDrinksScreen, BoxLayout.Y_AXIS));
        orderDrinksScreen.setBackground(Color.WHITE);
        orderDrinksScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Order Drinks");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderDrinksScreen.add(titleLabel);
        orderDrinksScreen.add(Box.createRigidArea(new Dimension(0, 15)));

        // Drink flavor selection dropdown UI
        JPanel flavorPanel = new JPanel();
        flavorPanel.setLayout(new BoxLayout(flavorPanel, BoxLayout.Y_AXIS));
        flavorPanel.setBackground(Color.WHITE);
        flavorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel flavorOptionsLabel = new JLabel("Choose Flavor:");
        flavorOptionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //all drink flavors
        String[] flavors = Drinks.getAllFlavors().toArray(new String[0]);
        JComboBox<String> flavorOptionsBox = new JComboBox<>(flavors);
        flavorOptionsBox.setSelectedItem("Cola");
        flavorOptionsBox.setMaximumSize(new Dimension(300, 30));
        flavorOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        flavorPanel.add(flavorOptionsLabel);
        flavorPanel.add(flavorOptionsBox);
        flavorPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        orderDrinksScreen.add(flavorPanel);

        //drink options dropdown
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
        sizePanel.setBackground(Color.WHITE);
        sizePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sizeOptionsLabel = new JLabel("Choose Size:");
        sizeOptionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sizes = {"Small", "Medium", "Large"};
        JComboBox<String> sizeOptionsBox = new JComboBox<>(sizes);
        sizeOptionsBox.setSelectedItem("Small");
        sizeOptionsBox.setMaximumSize(new Dimension(300, 30));
        sizeOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        sizePanel.add(sizeOptionsLabel);
        sizePanel.add(sizeOptionsBox);
        sizePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        orderDrinksScreen.add(sizePanel);


        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.Y_AXIS));
        quantityPanel.setBackground(Color.WHITE);
        quantityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Integer[] quantities = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        JComboBox<Integer> quantityBox = new JComboBox<>(quantities);
        quantityBox.setSelectedItem(1);
        quantityBox.setMaximumSize(new Dimension(300, 30));
        quantityBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityBox);
        quantityPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        orderDrinksScreen.add(quantityPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addToCartButton = new JButton("Add to Cart");
        JButton cancelOrderButton = new JButton("Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            String selectedFlavor = (String) flavorOptionsBox.getSelectedItem();
            String selectedSize = (String) sizeOptionsBox.getSelectedItem();
            Integer selectedQuantity = (Integer) quantityBox.getSelectedItem();

            //create new drink and add to cart
            Drinks drink = new Drinks(selectedSize, selectedQuantity, selectedFlavor);
            currentOrder.add(drink);

            JOptionPane.showMessageDialog(mainFrame, String.format("Added %d %s %s drink(s) to cart!",
                            selectedQuantity, selectedSize, selectedFlavor),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            newinitMainMenu();
        });

        //cancel the order
        cancelOrderButton.addActionListener(e -> {
            newinitMainMenu();
        });

        int maxWidth = Math.max(addToCartButton.getPreferredSize().width, cancelOrderButton.getPreferredSize().width);
        int maxHeight = Math.max(addToCartButton.getPreferredSize().height, cancelOrderButton.getPreferredSize().height);
        Dimension maxSize = new Dimension(maxWidth, maxHeight);
        addToCartButton.setMaximumSize(maxSize);
        cancelOrderButton.setMaximumSize(maxSize);

        addToCartButton.setBackground(new Color(173, 216, 230));
        cancelOrderButton.setBackground(new Color(173, 216, 230));

        buttonsPanel.add(addToCartButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonsPanel.add(cancelOrderButton);

        orderDrinksScreen.add(buttonsPanel);
        orderDrinksScreen.add(Box.createRigidArea(new Dimension(0, 10)));

        mainFrame.getContentPane().add(orderDrinksScreen);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private static void showViewCartMenu() {
        mainFrame.getContentPane().removeAll();

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel cartTitle = new JLabel("Your Cart", SwingConstants.CENTER);
        cartTitle.setFont(new Font("Arial", Font.BOLD, 24));
        cartPanel.add(cartTitle, BorderLayout.NORTH);

        JTextArea cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);
        cartTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        double totalPrice = 0;

        if (currentOrder.isEmpty()) {
            cartTextArea.setText("Your cart is empty.");
        } else {
            boolean sandwichLabelPrinted = false;
            boolean drinkLabelPrinted = false;
            boolean chipLabelPrinted = false;
            int count = 1;
            //very bad way for sorting (displaying) sandwiches first etc sandwichs -> drinks -> chips
            for (Product item : currentOrder) {
                if (item instanceof Sandwich) {
                    if (!sandwichLabelPrinted) {
                        cartTextArea.setText("-----Sandwiches-----\n");
                        sandwichLabelPrinted = true;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Sandwich #" + count).append("\n");
                    stringBuilder.append("-------------------").append("\n");
                    stringBuilder.append("Size: " + ((Sandwich) item).getChoosenSize()).append("'").append("\n");
                    stringBuilder.append("Bread: " + ((Sandwich) item).getChoosenBreadType()).append("\n");
                    if (((Sandwich) item).isToasted()) {
                        stringBuilder.append(" * is Toasted").append("\n");
                    }
                    stringBuilder.append("Toppings").append("\n").append("===================").append("\n");
                    for (Topping toppings : ((Sandwich) item).getToppings()) {
                        if (toppings.getName().equals("extra meat")) {
                            stringBuilder.append(" * " + "extra meat(s)").append("\n");
                        } else if (toppings.getName().equals("extra cheese")) {
                            stringBuilder.append(" * " + ("extra cheese(s)")).append("\n");
                        } else {
                            stringBuilder.append("- " + toppings.getName()).append("\n");
                        }
                    }
                    stringBuilder.append("-------------------").append("\n");
                    stringBuilder.append("Price : $").append(item.getPrice()).append("\n");
                    stringBuilder.append("-------------------").append("\n").append("\n");
                    cartTextArea.append(stringBuilder.toString());
                    count++;
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Drinks) {
                    if (!drinkLabelPrinted) {
                        cartTextArea.append("------Drinks-------\n");
                        drinkLabelPrinted = true;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Drink Order").append("\n");
                    stringBuilder.append("-------------------").append("\n");
                    stringBuilder.append("Flavor: ").append(((Drinks) item).getSelectedFlavor()).append("\n");
                    stringBuilder.append("Size: ").append(((Drinks) item).getSelectedSize()).append("\n");
                    stringBuilder.append("Quantity: ").append(((Drinks) item).getAmountOfDrinks()).append("\n");
                    stringBuilder.append("Price: $").append(String.format("%.2f", item.getPrice())).append("\n");
                    stringBuilder.append("-------------------").append("\n");
                    cartTextArea.append(stringBuilder.toString());
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    //TODO
                }
            }

            if (totalPrice >= 10.00) {
                cartTextArea.append("╔═════════════════════════╗\n");
                cartTextArea.append(String.format("║    TOTAL: $%.2f     ║\n", totalPrice));
                cartTextArea.append("╚═════════════════════════╝\n");
            } else {
                cartTextArea.append("╔═════════════════════════╗\n");
                cartTextArea.append(String.format("║    TOTAL: $%.2f      ║\n", totalPrice));
                cartTextArea.append("╚═════════════════════════╝\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        cartPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));

        JButton btnBack = new JButton("Back to Main Menu");
        btnBack.addActionListener(e -> newinitMainMenu());

        JButton btnClearCart = new JButton("Clear Cart");
        btnClearCart.addActionListener(e -> {
            currentOrder.clear();
            showViewCartMenu();
        });

        JButton btnCheckOut = new JButton("Checkout");
        btnCheckOut.addActionListener(e -> checkOutMenu());

        buttonPanel.add(btnBack);
        buttonPanel.add(btnClearCart);
        buttonPanel.add(btnCheckOut);

        cartPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(cartPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static void checkOutMenu() {

    }
}
