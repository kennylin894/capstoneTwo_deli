package com.ps;

import com.ps.Core.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class UserInterface {

    private static JFrame mainFrame;
    private static final ArrayList<Product> currentOrder = new ArrayList<>();

    private UserInterface() {
        System.out.println("Object cant be created.");
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
        JButton menuButton = new JButton("\uD83D\uDCCB  View Menu");
        JButton orderYourOwnSandwichButton = new JButton("\uD83C\uDF5E  BYO Sandwich");
        JButton orderPreMadeSandwich = new JButton("🥙  Order Sandwiches");
        JButton orderChipsButton = new JButton("🍿 Order Chips");
        JButton orderDrinksButton = new JButton("☕  Order Drinks");
        JButton viewCheckoutCartButton = new JButton("\uD83D\uDED2  View Cart/Checkout");
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

        menuPanel.add(orderChipsButton);
        orderChipsButton.addActionListener(e -> showOrderChipsScreen());

        menuPanel.add(orderDrinksButton);
        orderDrinksButton.addActionListener(e -> showOrderDrinksScreen());

        menuPanel.add(viewCheckoutCartButton);
        viewCheckoutCartButton.addActionListener(e -> showViewCartMenu());

        menuPanel.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
        mainFrame.add(menuPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }

    public static void initMainMenu() {
        mainFrame = new JFrame("DELI-cious - Main menu [By: Kenny Lin]");
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
        +----------------------------------------------------------------------+
        |                    SIGNATURE SANDWICHES                              |
        +------------------+------------------+----------+----------+----------+
        | Sandwich         | Ingredients      |   4"     |   8"     |   12"    |
        +------------------+------------------+----------+----------+----------+
        | BLT Classic      | White Bread      |  $8.00   |  $10.25  |  $12.50  |
        | (Toasted)        | Toasted          |          |          |          |
        |                  | Bacon            |          |          |          |
        |                  | American Cheese  |          |          |          |
        |                  | Lettuce          |          |          |          |
        |                  | Tomato           |          |          |          |
        |                  | Mayo             |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Philly Steak     | White Bread      |  $8.25   |  $10.50  |  $12.75  |
        | (Toasted)        | Toasted          |          |          |          |
        |                  | Steak            |          |          |          |
        |                  | American Cheese  |          |          |          |
        |                  | Peppers          |          |          |          |
        |                  | Onions           |          |          |          |
        |                  | Mayo             |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Italian Sub      | White Bread      | $10.50   | $13.25   | $15.25   |
        |                  | Ham              |          |          |          |
        |                  | Salami           |          |          |          |
        |                  | Provolone        |          |          |          |
        |                  | Lettuce          |          |          |          |
        |                  | Tomato           |          |          |          |
        |                  | Onion            |          |          |          |
        |                  | Vinaigrette      |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Turkey Club      | Wheat Bread      |  $9.75   | $12.25   | $14.50   |
        | (Toasted)        | Toasted          |          |          |          |
        |                  | Chicken          |          |          |          |
        |                  | Bacon            |          |          |          |
        |                  | Swiss Cheese     |          |          |          |
        |                  | Lettuce          |          |          |          |
        |                  | Tomato           |          |          |          |
        |                  | Ranch            |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Veggie Supreme   | Rye Bread        |  $7.75   | $10.00   | $12.25   |
        |                  | Cheddar Cheese   |          |          |          |
        |                  | Swiss Cheese     |          |          |          |
        |                  | Lettuce          |          |          |          |
        |                  | Tomato           |          |          |          |
        |                  | Peppers          |          |          |          |
        |                  | Onions           |          |          |          |
        |                  | Cucumbers        |          |          |          |
        |                  | Mushrooms        |          |          |          |
        |                  | Ranch            |          |          |          |
        +------------------+------------------+----------+----------+----------+
        |                   BUILD YOUR OWN SANDWICH                            |
        +------------------+------------------+----------+----------+----------+
        | Category         | Item             |   4"     |   8"     |   12"    |
        +------------------+------------------+----------+----------+----------+
        | Base Sandwich    |                  |  $5.50   |  $7.00   |  $8.50   |
        +------------------+------------------+----------+----------+----------+
        | Bread Choices    | White            |          |          |          |
        |                  | Wheat            |          |          |          |
        |                  | Rye              |          |          |          |
        |                  | Wrap             |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Meats            | Steak            |  $1.00   |  $2.00   |  $3.00   |
        |                  | Ham              |  $1.00   |  $2.00   |  $3.00   |
        |                  | Salami           |  $1.00   |  $2.00   |  $3.00   |
        |                  | Roast Beef       |  $1.00   |  $2.00   |  $3.00   |
        |                  | Chicken          |  $1.00   |  $2.00   |  $3.00   |
        |                  | Bacon            |  $1.00   |  $2.00   |  $3.00   |
        | Extra Meat       | +                |  $0.50   |  $1.00   |  $1.50   |
        +------------------+------------------+----------+----------+----------+
        | Cheese           | American         |  $0.75   |  $1.50   |  $2.25   |
        |                  | Provolone        |  $0.75   |  $1.50   |  $2.25   |
        |                  | Cheddar          |  $0.75   |  $1.50   |  $2.25   |
        |                  | Swiss            |  $0.75   |  $1.50   |  $2.25   |
        | Extra Cheese     | +                |  $0.30   |  $0.60   |  $0.90   |
        +------------------+------------------+----------+----------+----------+
        | Toppings (Free)  | Lettuce          |          |          |          |
        |                  | Peppers          |          |          |          |
        |                  | Onions           |          |          |          |
        |                  | Tomatoes         |          |          |          |
        |                  | Jalapeños        |          |          |          |
        |                  | Cucumbers        |          |          |          |
        |                  | Pickles          |          |          |          |
        |                  | Guacamole        |          |          |          |
        |                  | Mushrooms        |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Sauces (Free)    | Mayo             |          |          |          |
        |                  | Mustard          |          |          |          |
        |                  | Ketchup          |          |          |          |
        |                  | Ranch            |          |          |          |
        |                  | Thousand Islands |          |          |          |
        |                  | Vinaigrette      |          |          |          |
        +------------------+------------------+----------+----------+----------+
        | Sides (Free)     | Au Jus           |          |          |          |
        |                  | Sauce            |          |          |          |
        +------------------+------------------+----------+----------+----------+
        |                            Drinks                                    |
        +------------------+------------------+----------+----------+----------+
        | Sizes            |                  | Small    | Medium   | Large    |
        +------------------+------------------+----------+----------+----------+
        | Cola             |                  |  $2.00   |  $2.50   |  $3.00   |
        | Diet Cola        |                  |  $2.00   |  $2.50   |  $3.00   |
        | Root Beer        |                  |  $2.00   |  $2.50   |  $3.00   |
        | Lemon-Lime       |                  |  $2.00   |  $2.50   |  $3.00   |
        | Orange Soda      |                  |  $2.00   |  $2.50   |  $3.00   |
        | Iced Tea         |                  |  $2.00   |  $2.50   |  $3.00   |
        | Lemonade         |                  |  $2.00   |  $2.50   |  $3.00   |
        | Fruit Punch      |                  |  $2.00   |  $2.50   |  $3.00   |
        | Ginger Ale       |                  |  $2.00   |  $2.50   |  $3.00   |
        | Water            |                  |  $2.00   |  $2.50   |  $3.00   |
        +------------------+------------------+----------+----------+----------+
        |                            Chips                                     |
        +-------------------+------------------+----------+----------+---------+
        | Original          |                  |  $1.50   |          |         |
        | BBQ               |                  |  $1.50   |          |         |
        | Sour Cream & Onion|                  |  $1.50   |          |         |
        | Salt & Vinegar    |                  |  $1.50   |          |         |
        | Jalapeño          |                  |  $1.50   |          |         |
        | Cheddar Cheese    |                  |  $1.50   |          |         |
        | Lime              |                  |  $1.50   |          |         |
        | Sea Salt          |                  |  $1.50   |          |         |
        | Kettle Cooked     |                  |  $1.50   |          |         |
        | Spicy Nacho       |                  |  $1.50   |          |         |
        +------------------+-------------------+----------+----------+---------+
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
            boolean isToasted = toastedCheckBox.isSelected();
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

    private static void showOrderChipsScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel orderChipsScreen = new JPanel();
        orderChipsScreen.setLayout(new BoxLayout(orderChipsScreen, BoxLayout.Y_AXIS));
        orderChipsScreen.setBackground(Color.WHITE);
        orderChipsScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Order Chips");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderChipsScreen.add(titleLabel);
        orderChipsScreen.add(Box.createRigidArea(new Dimension(0, 15)));

        // Chip flavor selection dropdown UI
        JPanel flavorPanel = new JPanel();
        flavorPanel.setLayout(new BoxLayout(flavorPanel, BoxLayout.Y_AXIS));
        flavorPanel.setBackground(Color.WHITE);
        flavorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel flavorOptionsLabel = new JLabel("Choose Flavor:");
        flavorOptionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //all chip flavors
        String[] flavors = Chips.getChipAllOptions().toArray(new String[0]);
        JComboBox<String> flavorOptionsBox = new JComboBox<>(flavors);
        flavorOptionsBox.setSelectedItem("Original");
        flavorOptionsBox.setMaximumSize(new Dimension(300, 30));
        flavorOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        flavorPanel.add(flavorOptionsLabel);
        flavorPanel.add(flavorOptionsBox);
        flavorPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        orderChipsScreen.add(flavorPanel);

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
        orderChipsScreen.add(quantityPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addToCartButton = new JButton("Add to Cart");
        JButton cancelOrderButton = new JButton("Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            String selectedFlavor = (String) flavorOptionsBox.getSelectedItem();
            Integer selectedQuantity = (Integer) quantityBox.getSelectedItem();

            boolean found = false;

            for(Product product : currentOrder) {
                if(product instanceof Chips) {
                    Chips existingChips = (Chips) product;
                    if(existingChips.getChosenChip().equals(selectedFlavor)) {
                        int newQuantity = existingChips.getAmountOfChips() + selectedQuantity;
                        existingChips.setAmountOfChips(newQuantity);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) {
                Chips chips = new Chips(selectedFlavor, selectedQuantity);
                currentOrder.add(chips);
            }
            JOptionPane.showMessageDialog(mainFrame, String.format("Added %d %s chip(s) to cart!",
                            selectedQuantity, selectedFlavor),
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

        orderChipsScreen.add(buttonsPanel);
        orderChipsScreen.add(Box.createRigidArea(new Dimension(0, 10)));

        mainFrame.getContentPane().add(orderChipsScreen);
        mainFrame.revalidate();
        mainFrame.repaint();
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

            boolean found = false;
            for(Product product : currentOrder) {
                if(product instanceof Drinks) {
                    Drinks existingDrinks = (Drinks) product;
                    if(existingDrinks.getSelectedFlavor().equals(selectedFlavor) && existingDrinks.getSelectedSize().equals(selectedSize)) {
                        int newQuantity = existingDrinks.getAmountOfDrinks() + selectedQuantity;
                        existingDrinks.setAmountOfDrinks(newQuantity);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) {
                Drinks drinks = new Drinks(selectedSize,selectedQuantity, selectedFlavor);
                currentOrder.add(drinks);
            }
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
        cartPanel.setBorder(new EmptyBorder(5, 20, 20, 20));
        cartPanel.setBackground(Color.WHITE);

        JLabel cartTitle = new JLabel("Checkout", SwingConstants.CENTER);
        cartTitle.setFont(new Font("Arial", Font.BOLD, 24));
        cartTitle.setBorder(new EmptyBorder(5, 0, 15, 0));
        cartTitle.setBackground(Color.WHITE);
        cartTitle.setOpaque(true);
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
                    stringBuilder.append("-------------------").append("\n");
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
                    String stringBuilder = "Drink Order" + "\n" +
                            "-------------------" + "\n" +
                            "Flavor: " + ((Drinks) item).getSelectedFlavor() + "\n" +
                            "Size: " + ((Drinks) item).getSelectedSize() + "\n" +
                            "Quantity: " + ((Drinks) item).getAmountOfDrinks() + "\n" +
                            "Price: $" + String.format("%.2f", item.getPrice()) + "\n" +
                            "-------------------" + "\n";
                    cartTextArea.append(stringBuilder);
                    totalPrice += item.getPrice();
                }
            }
            for (Product item : currentOrder) {
                if (item instanceof Chips) {
                    if (!chipLabelPrinted) {
                        cartTextArea.append("-------Chips-------\n");
                        chipLabelPrinted = true;
                    }
                    String stringBuilder = "Chips Order" + "\n" +
                            "-------------------" + "\n" +
                            "Flavor: " + ((Chips) item).getChosenChip() + "\n" +
                            "Quantity: " + ((Chips) item).getAmountOfChips() + "\n" +
                            "Price: $" + String.format("%.2f", item.getPrice()) + "\n" +
                            "-------------------" + "\n";
                    cartTextArea.append(stringBuilder);
                    totalPrice += item.getPrice();
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
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Cart"));
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        //remove panel
        JPanel removePanel = new JPanel();
        removePanel.setLayout(new BoxLayout(removePanel, BoxLayout.Y_AXIS));
        removePanel.setBackground(Color.WHITE);
        removePanel.setBorder(BorderFactory.createTitledBorder("Remove Items"));
        removePanel.setPreferredSize(new Dimension(300, 0));
        JLabel removeLabel = new JLabel("Select item to remove:");
        removeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        removePanel.add(removeLabel);
        removePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Create dropdown with cart items
        JComboBox<String> itemDropdown = new JComboBox<>();
        itemDropdown.setMaximumSize(new Dimension(250, 30));
        itemDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);

        //shows the user things in the cart that they can remove
        if (!currentOrder.isEmpty()) {
            int itemIndex = 1;
            for (Product item : currentOrder) {
                StringBuilder stringBuilder = new StringBuilder();
                if (item instanceof Sandwich) {
                    stringBuilder.append("Sandwich #").append(itemIndex)
                            .append(" (").append(((Sandwich) item).getChoosenSize()).append("\", ")
                            .append(((Sandwich) item).getChoosenBreadType()).append(") - $")
                            .append(String.format("%.2f", item.getPrice()));
                } else if (item instanceof Drinks) {
                    stringBuilder.append("Drink (").append(((Drinks) item).getSelectedSize())
                            .append(" ").append(((Drinks) item).getSelectedFlavor())
                            .append(" x").append(((Drinks) item).getAmountOfDrinks())
                            .append(") - $").append(String.format("%.2f", item.getPrice()));
                } else if (item instanceof Chips) {
                    stringBuilder.append("Chips (").append(((Chips) item).getChosenChip())
                            .append(" x").append(((Chips) item).getAmountOfChips())
                            .append(") - $").append(String.format("%.2f", item.getPrice()));
                }
                itemDropdown.addItem(stringBuilder.toString());
                itemIndex++;
            }
        } else {
            itemDropdown.addItem("Your cart is empty.");
        }
        removePanel.add(itemDropdown);
        removePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JButton removeButton = new JButton("Remove Selected Item");
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeButton.setBackground(new Color(255, 100, 100));
        removeButton.addActionListener(e -> {
            if (itemDropdown.getSelectedIndex() >= 0 && !currentOrder.isEmpty()) {
                int selectedIndex = itemDropdown.getSelectedIndex();
                Product removedItem = currentOrder.get(selectedIndex);
                currentOrder.remove(selectedIndex);
                String itemType = "";
                if (removedItem instanceof Sandwich) itemType = "Sandwich";
                else if (removedItem instanceof Drinks) itemType = "Drink";
                else if (removedItem instanceof Chips) itemType = "Chips";
                JOptionPane.showMessageDialog(mainFrame,
                        itemType + " removed from cart!",
                        "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                showViewCartMenu();
            }
        });
        removePanel.add(removeButton);

        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(removePanel, BorderLayout.EAST);
        cartPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton btnBack = new JButton("Back to Main Menu");
        btnBack.addActionListener(e -> newinitMainMenu());

        JButton btnClearCart = new JButton("Clear Cart");
        btnClearCart.addActionListener(e -> {
            currentOrder.clear();
            showViewCartMenu();
        });
        JButton btnCheckOut = new JButton("Checkout");
        btnCheckOut.addActionListener(e -> checkOutMenu());

        int maxWidth = Math.max(btnBack.getPreferredSize().width,
                Math.max(btnClearCart.getPreferredSize().width, btnCheckOut.getPreferredSize().width));
        int maxHeight = Math.max(btnBack.getPreferredSize().height,
                Math.max(btnClearCart.getPreferredSize().height, btnCheckOut.getPreferredSize().height));
        Dimension buttonSize = new Dimension(maxWidth, maxHeight);

        btnBack.setPreferredSize(buttonSize);
        btnClearCart.setPreferredSize(buttonSize);
        btnCheckOut.setPreferredSize(buttonSize);

        buttonPanel.add(btnBack);
        buttonPanel.add(btnClearCart);
        buttonPanel.add(btnCheckOut);

        cartPanel.add(buttonPanel, BorderLayout.SOUTH);
        cartPanel.setBackground(Color.WHITE);

        mainFrame.add(cartPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static void checkOutMenu() {
        mainFrame.getContentPane().removeAll();
        JPanel checkoutPanel = new JPanel(new BorderLayout());
        checkoutPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        checkoutPanel.setBackground(Color.WHITE);
        JLabel checkoutTitle = new JLabel("Order Summary", SwingConstants.CENTER);
        checkoutTitle.setFont(new Font("Arial", Font.BOLD, 24));
        checkoutTitle.setBorder(new EmptyBorder(5, 0, 15, 0));
        checkoutPanel.add(checkoutTitle, BorderLayout.NORTH);

        //order summary
        JTextArea summaryTextArea = new JTextArea();
        summaryTextArea.setEditable(false);
        summaryTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        double totalPrice = FileManager.populateOrderSummary(summaryTextArea, currentOrder);
        JScrollPane scrollPane = new JScrollPane(summaryTextArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Final Order"));
        checkoutPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton confirmButton = new JButton("✅ Confirm Order");
        JButton cancelButton = new JButton("❌ Cancel Order");

        //confirm, then generates file
        confirmButton.addActionListener(e -> {
            if (currentOrder.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame,
                        "You have nothing in your cart.\nPlease add items.",
                        "Order Failed", JOptionPane.INFORMATION_MESSAGE);
                newinitMainMenu();
            } else {
                FileManager.generateReceipt(totalPrice, currentOrder);
                currentOrder.clear();
                JOptionPane.showMessageDialog(mainFrame,
                        "Order confirmed! Receipt saved.\nThank you for your order!",
                        "Order Complete", JOptionPane.INFORMATION_MESSAGE);
                newinitMainMenu();
            }
        });
        //cancel the checkout
        cancelButton.addActionListener(e -> showViewCartMenu());
        confirmButton.setBackground(new Color(0, 255, 0));
        confirmButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(255, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        checkoutPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(checkoutPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
