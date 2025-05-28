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

        //DELI logo image
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

        menuPanel.add(orderPreMadeSandwich);
        orderPreMadeSandwich.addActionListener(e -> showOrderSignatureSandwichScreen());

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

        //scrollable text area
        JTextArea menuTextArea = new JTextArea();
        menuTextArea.setEditable(false);
        menuTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        menuTextArea.setText("""
                +----------------------------------------------------------------------+
                |                    SIGNATURE SANDWICHES                              |
                +------------------+------------------+----------+----------+----------+
                | Sandwich         | Ingredients      |   4"     |   8"     |   12"    |
                +------------------+------------------+----------+----------+----------+
                | BLT Classic      | White Bread      |  $7.25   | $10.50   | $13.75   |
                | (Toasted)        | Toasted          |          |          |          |
                |                  | Bacon            |          |          |          |
                |                  | American Cheese  |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Mayo             |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Philly Steak     | White Bread      |  $7.25   | $10.50   | $13.75   |
                | (Toasted)        | Toasted          |          |          |          |
                |                  | Steak            |          |          |          |
                |                  | Provolone        |          |          |          |
                |                  | Peppers          |          |          |          |
                |                  | Onions           |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Italian Sub      | White Bread      |  $9.75   | $14.00   | $18.25   |
                | (Toasted)        | Toasted          |          |          |          |
                |                  | Ham              |          |          |          |
                |                  | Salami           |          |          |          |
                |                  | Provolone        |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Onion            |          |          |          |
                |                  | Vinaigrette      |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Chicken Club     | White Bread      |  $9.25   | $13.50   | $17.75   |
                | (Toasted)        | Toasted          |          |          |          |
                |                  | Chicken          |          |          |          |
                |                  | Bacon            |          |          |          |
                |                  | American Cheese  |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Mayo             |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Veggie Supreme   | Wheat Bread      |  $6.25   |  $8.50   | $10.75   |
                | (Toasted)        | Toasted          |          |          |          |
                |                  | American Cheese  |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Peppers          |          |          |          |
                |                  | Onions           |          |          |          |
                |                  | Cucumbers        |          |          |          |
                |                  | Mushrooms        |          |          |          |
                |                  | Mayo             |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Roast Beef       | Rye Bread        |  $7.25   | $10.50   | $13.75   |
                | Deluxe (Toasted) | Toasted          |          |          |          |
                |                  | Roast Beef       |          |          |          |
                |                  | Swiss Cheese     |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Onions           |          |          |          |
                |                  | Pickles          |          |          |          |
                |                  | Mustard          |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Ham & Swiss      | Rye Bread        |  $7.25   | $10.50   | $13.75   |
                | Classic (Toasted)| Toasted          |          |          |          |
                |                  | Ham              |          |          |          |
                |                  | Swiss Cheese     |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Mustard          |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Spicy Salami     | Italian Bread    |  $7.25   | $10.50   | $13.75   |
                | Supreme (Toasted)| Toasted          |          |          |          |
                |                  | Salami           |          |          |          |
                |                  | Cheddar Cheese   |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Onions           |          |          |          |
                |                  | Jalapeños        |          |          |          |
                |                  | Mustard          |          |          |          |
                +------------------+------------------+----------+----------+----------+
                | Chicken Avocado  | Wrap             |  $7.25   | $10.50   | $13.75   |
                | Wrap             |                  |          |          |          |
                |                  | Chicken          |          |          |          |
                |                  | Provolone        |          |          |          |
                |                  | Lettuce          |          |          |          |
                |                  | Tomato           |          |          |          |
                |                  | Guacamole        |          |          |          |
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
                |                               DRINKS                                 |
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
                | Thai Tea         |                  |  $2.00   |  $2.50   |  $3.00   |
                | Taro Boba        |                  |  $2.00   |  $2.50   |  $3.00   |
                | Matcha Latte     |                  |  $2.00   |  $2.50   |  $3.00   |
                | Coffee           |                  |  $2.00   |  $2.50   |  $3.00   |
                | Iced Coffee      |                  |  $2.00   |  $2.50   |  $3.00   |
                | Green Tea        |                  |  $2.00   |  $2.50   |  $3.00   |
                | Jasmine Tea      |                  |  $2.00   |  $2.50   |  $3.00   |
                | Mango Smoothie   |                  |  $2.00   |  $2.50   |  $3.00   |
                | Strawberry       |                  |  $2.00   |  $2.50   |  $3.00   |
                | Smoothie         |                  |          |          |          |
                | Hot Chocolate    |                  |  $2.00   |  $2.50   |  $3.00   |
                +------------------+------------------+----------+----------+----------+
                |                              SNACKS                                 |
                +------------------+------------------+----------+----------+---------+
                | Original         |                  |  $1.50   |          |         |
                | BBQ              |                  |  $1.50   |          |         |
                | Sour Cream Onion |                  |  $1.50   |          |         |
                | Salt & Vinegar   |                  |  $1.50   |          |         |
                | Jalapeño         |                  |  $1.50   |          |         |
                | Cheddar Cheese   |                  |  $1.50   |          |         |
                | Lime             |                  |  $1.50   |          |         |
                | Sea Salt         |                  |  $1.50   |          |         |
                | Kettle Cooked    |                  |  $1.50   |          |         |
                | Spicy Nacho      |                  |  $1.50   |          |         |
                | Flamin' Hot      |                  |  $1.50   |          |         |
                | Cool Ranch       |                  |  $1.50   |          |         |
                | Honey BBQ        |                  |  $1.50   |          |         |
                | Dill Pickle      |                  |  $1.50   |          |         |
                | Sweet Chili      |                  |  $1.50   |          |         |
                | Buffalo          |                  |  $1.50   |          |         |
                | Pretzels         |                  |  $1.50   |          |         |
                | Popcorn          |                  |  $1.50   |          |         |
                | Trail Mix        |                  |  $1.50   |          |         |
                | Granola Bar      |                  |  $1.50   |          |         |
                | Cookies          |                  |  $1.50   |          |         |
                | Crackers         |                  |  $1.50   |          |         |
                | Peanuts          |                  |  $1.50   |          |         |
                | Mixed Nuts       |                  |  $1.50   |          |         |
                +------------------+------------------+----------+----------+---------+
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
        menuTextArea.setCaretPosition(0);
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

        //meats
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
        for (String topping : Freetoppings.getToppings()) {
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
        for (String sauce : Freetoppings.getSauceToppings()) {
            JCheckBox cb = new JCheckBox(sauce);
            cb.setOpaque(false);
            saucesPanel.add(cb);
            sauceCheckBoxes.add(cb);
        }

        //sides
        JPanel sidesPanel = new JPanel();
        sidesPanel.setLayout(new BoxLayout(sidesPanel, BoxLayout.Y_AXIS));
        sidesPanel.setBackground(Color.WHITE);
        sidesPanel.setBorder(BorderFactory.createTitledBorder("Sides"));
        for (String sides : Freetoppings.getSideToppings()) {
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
        JButton addToCartButton = new JButton("🛒  Add to Cart");
        JButton cancelOrderButton = new JButton("❌  Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            Integer selectedSize = (Integer) sizeOptionsBox.getSelectedItem();
            String selectedBread = (String) breadOptionsBox.getSelectedItem();
            boolean isToasted = toastedCheckBox.isSelected();
            ArrayList<String> toppings = new ArrayList<>();
            ArrayList<Toppings> actualToppings = new ArrayList<>();
            boolean hasMeats = false;
            boolean hasExtraMeats = false;
            boolean hasExtraCheese = false;
            //check if extra meat is checked first
            for (JCheckBox cb : meatCheckBoxes) {
                if (cb.getText().equals("extra meat")) {
                    if (cb.isSelected()) {
                        hasExtraMeats = true;
                        hasMeats = true;
                    }
                } else {
                    if (cb.isSelected()) {
                        toppings.add(cb.getText());
                        hasMeats = true;
                    }
                }
            }
            boolean hasCheese = false;
            for (JCheckBox cb : cheeseCheckBoxes) {
                if (cb.getText().equals("extra cheese")) {
                    if (cb.isSelected()) {
                        hasExtraCheese = true;
                        hasCheese = true;
                    }
                } else {
                    if (cb.isSelected()) {
                        toppings.add(cb.getText());
                        hasCheese = true;
                    }
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
                if (Freetoppings.getToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (Freetoppings.getSideToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (Freetoppings.getSauceToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (PremiumToppings.getCheeseToppings().contains(i)) {
                    if (hasExtraCheese && !i.equals("extra cheese")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
                if (PremiumToppings.getMeatToppings().contains(i)) {
                    if (hasExtraMeats && !i.equals("extra meats")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
            }
            Sandwich sandwich = new Sandwich(selectedSize, selectedBread, isToasted, actualToppings,"custom");
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

    private static void showOrderSignatureSandwichScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel signatureScreen = new JPanel();
        signatureScreen.setLayout(new BoxLayout(signatureScreen, BoxLayout.Y_AXIS));
        signatureScreen.setBackground(Color.WHITE);
        signatureScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Choose a Signature Sandwich");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signatureScreen.add(titleLabel);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 15)));

        //blt
        JButton bltButton = new JButton("🥓  BLT Classic - $10.50");
        bltButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bltButton.setMaximumSize(new Dimension(350, 40));
        bltButton.setBackground(new Color(173, 216, 230));
        bltButton.addActionListener(e -> {
            ArrayList<Toppings> bltToppings = new ArrayList<>();
            bltToppings.add(new PremiumToppings("Bacon", false));
            bltToppings.add(new PremiumToppings("American", false));
            bltToppings.add(new Freetoppings("Lettuce"));
            bltToppings.add(new Freetoppings("Tomatoes"));
            bltToppings.add(new Freetoppings("Mayo"));

            Sandwich blt = new Sandwich(8, "white", true, bltToppings,"BLT - Classic");
            createSandwich(blt,"BLT - Classic");
        });

        //phillycheese steak
        JButton phillyButton = new JButton("🧀  Philly Cheese Steak - $10.50");
        phillyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        phillyButton.setMaximumSize(new Dimension(350, 40));
        phillyButton.setBackground(new Color(173, 216, 230));
        phillyButton.addActionListener(e -> {
            ArrayList<Toppings> phillyToppings = new ArrayList<>();
            phillyToppings.add(new PremiumToppings("Steak", false));
            phillyToppings.add(new PremiumToppings("Provolone", false));
            phillyToppings.add(new Freetoppings("Peppers"));
            phillyToppings.add(new Freetoppings("Onions"));

            Sandwich philly = new Sandwich(8, "white", true, phillyToppings,"Philly Cheese Steak");
            createSandwich(philly, "Philly Cheese Steak");
        });

        //italian
        JButton italianButton = new JButton("🍞  Italian Sub - $12.50");
        italianButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        italianButton.setMaximumSize(new Dimension(350, 40));
        italianButton.setBackground(new Color(173, 216, 230));
        italianButton.addActionListener(e -> {
            ArrayList<Toppings> italianToppings = new ArrayList<>();
            italianToppings.add(new PremiumToppings("Ham", false));
            italianToppings.add(new PremiumToppings("Salami", false));
            italianToppings.add(new PremiumToppings("Provolone", false));
            italianToppings.add(new Freetoppings("Lettuce"));
            italianToppings.add(new Freetoppings("Tomatoes"));
            italianToppings.add(new Freetoppings("Onions"));
            italianToppings.add(new Freetoppings("Vinaigrette"));

            Sandwich italian = new Sandwich(8, "italian", true, italianToppings,"Italian Sub");
            createSandwich(italian, "Italian Sub");
        });

        //chicken
        JButton chickenButton = new JButton("🐔  Chicken Club - $12.50");
        chickenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chickenButton.setMaximumSize(new Dimension(350, 40));
        chickenButton.setBackground(new Color(173, 216, 230));
        chickenButton.addActionListener(e -> {
            ArrayList<Toppings> chickenClubToppings = new ArrayList<>();
            chickenClubToppings.add(new PremiumToppings("Chicken", false));
            chickenClubToppings.add(new PremiumToppings("Bacon", false));
            chickenClubToppings.add(new PremiumToppings("American", false));
            chickenClubToppings.add(new Freetoppings("Lettuce"));
            chickenClubToppings.add(new Freetoppings("Tomatoes"));
            chickenClubToppings.add(new Freetoppings("Mayo"));

            Sandwich chickenClub = new Sandwich(8, "white", true, chickenClubToppings,"Chicken Club");
            createSandwich(chickenClub, "Chicken Club");
        });

        //veggie
        JButton veggieButton = new JButton("🥒  Veggie Supreme - $8.50");
        veggieButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        veggieButton.setMaximumSize(new Dimension(350, 40));
        veggieButton.setBackground(new Color(173, 216, 230));
        veggieButton.addActionListener(e -> {
            ArrayList<Toppings> veggieToppings = new ArrayList<>();
            veggieToppings.add(new PremiumToppings("American", false));
            veggieToppings.add(new Freetoppings("Lettuce"));
            veggieToppings.add(new Freetoppings("Tomatoes"));
            veggieToppings.add(new Freetoppings("Peppers"));
            veggieToppings.add(new Freetoppings("Onions"));
            veggieToppings.add(new Freetoppings("Cucumbers"));
            veggieToppings.add(new Freetoppings("Mushrooms"));
            veggieToppings.add(new Freetoppings("Mayo"));

            Sandwich veggie = new Sandwich(8, "wheat", true, veggieToppings,"Veggie Supreme");
            createSandwich(veggie, "Veggie Supreme");
        });

        //roast beef deluxe
        JButton roastBeefButton = new JButton("🍖  Roast Beef Deluxe - $11.25");
        roastBeefButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        roastBeefButton.setMaximumSize(new Dimension(350, 40));
        roastBeefButton.setBackground(new Color(173, 216, 230));
        roastBeefButton.addActionListener(e -> {
            ArrayList<Toppings> roastBeefToppings = new ArrayList<>();
            roastBeefToppings.add(new PremiumToppings("Roast Beef", false));
            roastBeefToppings.add(new PremiumToppings("Swiss", false));
            roastBeefToppings.add(new Freetoppings("Lettuce"));
            roastBeefToppings.add(new Freetoppings("Tomatoes"));
            roastBeefToppings.add(new Freetoppings("Onions"));
            roastBeefToppings.add(new Freetoppings("Pickles"));
            roastBeefToppings.add(new Freetoppings("Mustard"));

            Sandwich roastBeefDeluxe = new Sandwich(8, "rye", true, roastBeefToppings,"Roast Beef Deluxe");
            createSandwich(roastBeefDeluxe, "Roast Beef Deluxe");
        });

        //ham and swiss classic
        JButton hamSwissButton = new JButton("🍞  Ham & Swiss Classic - $10.50");
        hamSwissButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hamSwissButton.setMaximumSize(new Dimension(350, 40));
        hamSwissButton.setBackground(new Color(173, 216, 230));
        hamSwissButton.addActionListener(e -> {
            ArrayList<Toppings> hamSwissToppings = new ArrayList<>();
            hamSwissToppings.add(new PremiumToppings("Ham", false));
            hamSwissToppings.add(new PremiumToppings("Swiss", false));
            hamSwissToppings.add(new Freetoppings("Lettuce"));
            hamSwissToppings.add(new Freetoppings("Tomatoes"));
            hamSwissToppings.add(new Freetoppings("Mustard"));

            Sandwich hamSwiss = new Sandwich(8, "rye", true, hamSwissToppings,"Ham & Swiss Classic");
            createSandwich(hamSwiss, "Ham & Swiss Classic");
        });

        //spicy salami supreme
        JButton salamiButton = new JButton("🌶️  Spicy Salami Supreme - $11.75");
        salamiButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        salamiButton.setMaximumSize(new Dimension(350, 40));
        salamiButton.setBackground(new Color(173, 216, 230));
        salamiButton.addActionListener(e -> {
            ArrayList<Toppings> salamiToppings = new ArrayList<>();
            salamiToppings.add(new PremiumToppings("Salami", false));
            salamiToppings.add(new PremiumToppings("Cheddar", false));
            salamiToppings.add(new Freetoppings("Lettuce"));
            salamiToppings.add(new Freetoppings("Onions"));
            salamiToppings.add(new Freetoppings("Jalapeños"));
            salamiToppings.add(new Freetoppings("Mustard"));

            Sandwich salami = new Sandwich(8, "italian", true, salamiToppings,"Spicy Salami Supreme");
            createSandwich(salami, "Spicy Salami Supreme");
        });

        //chicken avocado wrap
        JButton chickenWrapButton = new JButton("🌯  Chicken Avocado Wrap - $11.25");
        chickenWrapButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chickenWrapButton.setMaximumSize(new Dimension(350, 40));
        chickenWrapButton.setBackground(new Color(173, 216, 230));
        chickenWrapButton.addActionListener(e -> {
            ArrayList<Toppings> chickenWrapToppings = new ArrayList<>();
            chickenWrapToppings.add(new PremiumToppings("Chicken", false));
            chickenWrapToppings.add(new PremiumToppings("Provolone", false));
            chickenWrapToppings.add(new Freetoppings("Lettuce"));
            chickenWrapToppings.add(new Freetoppings("Tomatoes"));
            chickenWrapToppings.add(new Freetoppings("Guacamole"));
            chickenWrapToppings.add(new Freetoppings("Ranch"));

            Sandwich chickenWrap = new Sandwich(8, "wrap", false, chickenWrapToppings,"Chicken Avocado Wrap");
            createSandwich(chickenWrap, "Chicken Avocado Wrap");
        });

        signatureScreen.add(bltButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(phillyButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(italianButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(chickenButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(veggieButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(roastBeefButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(hamSwissButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(salamiButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 10)));
        signatureScreen.add(chickenWrapButton);
        signatureScreen.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton backButton = new JButton("⬅️  Back to Main Menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(173, 216, 230));
        backButton.addActionListener(e -> newinitMainMenu());
        signatureScreen.add(backButton);

        mainFrame.getContentPane().add(signatureScreen);
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

        //chip flavor selection dropdown UI
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

        JButton addToCartButton = new JButton("🛒  Add to Cart");
        JButton cancelOrderButton = new JButton("❌  Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            String selectedFlavor = (String) flavorOptionsBox.getSelectedItem();
            Integer selectedQuantity = (Integer) quantityBox.getSelectedItem();

            boolean found = false;

            for (Product product : currentOrder) {
                if (product instanceof Chips) {
                    Chips existingChips = (Chips) product;
                    if (existingChips.getChosenChip().equals(selectedFlavor)) {
                        int newQuantity = existingChips.getAmountOfChips() + selectedQuantity;
                        existingChips.setAmountOfChips(newQuantity);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
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

        //drink flavor selection dropdown UI
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

        JButton addToCartButton = new JButton("🛒  Add to Cart");
        JButton cancelOrderButton = new JButton("❌  Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            String selectedFlavor = (String) flavorOptionsBox.getSelectedItem();
            String selectedSize = (String) sizeOptionsBox.getSelectedItem();
            Integer selectedQuantity = (Integer) quantityBox.getSelectedItem();

            boolean found = false;
            for (Product product : currentOrder) {
                if (product instanceof Drinks) {
                    Drinks existingDrinks = (Drinks) product;
                    if (existingDrinks.getSelectedFlavor().equals(selectedFlavor) && existingDrinks.getSelectedSize().equals(selectedSize)) {
                        int newQuantity = existingDrinks.getAmountOfDrinks() + selectedQuantity;
                        existingDrinks.setAmountOfDrinks(newQuantity);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                Drinks drinks = new Drinks(selectedSize, selectedQuantity, selectedFlavor);
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
                    if(((Sandwich) item).getSandwichName().equals("custom"))
                    {
                        stringBuilder.append("Sandwich #" + count).append("\n");
                    }
                    else
                    {
                        stringBuilder.append(((Sandwich) item).getSandwichName()).append("\n");
                    }
                    stringBuilder.append("-------------------").append("\n");
                    stringBuilder.append("Size: " + ((Sandwich) item).getChoosenSize()).append("'").append("\n");
                    stringBuilder.append("Bread: " + ((Sandwich) item).getChoosenBreadType()).append("\n");
                    if (((Sandwich) item).isToasted()) {
                        stringBuilder.append(" * is Toasted").append("\n");
                    }
                    stringBuilder.append("Toppings").append("\n").append("===================").append("\n");
                    for (Toppings toppings : ((Sandwich) item).getToppings()) {
                        if (toppings instanceof PremiumToppings) {
                            stringBuilder.append("- ").append(toppings.getName()).append("\n");
                            if (((PremiumToppings) toppings).isExtraMeat()) {
                                stringBuilder.append(" * extra meat(s)").append("\n");
                            }
                            if (((PremiumToppings) toppings).isExtraCheese()) {
                                stringBuilder.append(" * extra cheese(s)").append("\n");
                            }
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
                    String stringBuilder = "Drinks" + "\n" +
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
                    String stringBuilder = "Chips" + "\n" +
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

        //create dropdown with cart items
        JComboBox<String> itemDropdown = new JComboBox<>();
        itemDropdown.setMaximumSize(new Dimension(250, 30));
        itemDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);

        //shows the user things in the cart that they can remove
        if (!currentOrder.isEmpty()) {
            int itemIndex = 1;
            for (Product item : currentOrder) {
                StringBuilder stringBuilder = new StringBuilder();
                if (item instanceof Sandwich) {
                    if(((Sandwich) item).getSandwichName().equals("custom"))
                    {
                        stringBuilder.append("Sandwich #" + itemIndex).append("\n");
                    }
                    else
                    {
                        stringBuilder.append(((Sandwich) item).getSandwichName()).append("\n");
                    }
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
        JButton removeButton = new JButton("\uD83D\uDEAE  Remove Selected Item");
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeButton.setBackground(new Color(255, 100, 100));
        removeButton.addActionListener(e -> {
            if (currentOrder.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame,
                        "        Your Cart is Empty",
                        "Error", JOptionPane.WARNING_MESSAGE);
                showViewCartMenu();
            } else {
                if (itemDropdown.getSelectedIndex() >= 0 && !currentOrder.isEmpty()) {
                    int selectedIndex = itemDropdown.getSelectedIndex();
                    Product removedItem = currentOrder.get(selectedIndex);
                    currentOrder.remove(selectedIndex);
                    String itemType = "";
                    if (removedItem instanceof Sandwich) {
                        itemType = "Sandwich";
                    } else if (removedItem instanceof Drinks) {
                        itemType = "Drink";
                    } else if (removedItem instanceof Chips) {
                        itemType = "Chips";
                    }
                    JOptionPane.showMessageDialog(mainFrame,
                            itemType + " removed from cart!",
                            "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                    showViewCartMenu();
                }
            }
        });
        removePanel.add(removeButton);

        //removing a certain amount of an item
        removePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel quantityLabel = new JLabel("Quantity to remove:");
        quantityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePanel.add(quantityLabel);
        removePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        Integer[] removeAmount = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        JComboBox<Integer> quantityDropdown = new JComboBox<>(removeAmount);
        quantityDropdown.setMaximumSize(new Dimension(100, 30));
        quantityDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePanel.add(quantityDropdown);
        removePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton removeQuantityButton = new JButton("\uD83D\uDEAE  Remove Quantity");
        removeQuantityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeQuantityButton.setBackground(new Color(255, 100, 100));
        removeQuantityButton.addActionListener(e -> {
            if (currentOrder.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame,
                        "        Your Cart is Empty",
                        "Error", JOptionPane.WARNING_MESSAGE);
                showViewCartMenu();
            } else {
                int selectedIndex = itemDropdown.getSelectedIndex();
                Product product = currentOrder.get(selectedIndex);
                int numToRemove = quantityDropdown.getSelectedIndex() + 1;
                if (selectedIndex >= 0 && !currentOrder.isEmpty()) {
                    if (product instanceof Chips) {
                        Chips chips = (Chips) product;
                        if (chips.getAmountOfChips() == 1) {
                            if (numToRemove > chips.getAmountOfChips()) {
                                JOptionPane.showMessageDialog(mainFrame,
                                        "There are only " + chips.getAmountOfChips() + "x of " + chips.getChosenChip() + ".",
                                        "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                                showViewCartMenu();
                            } else {
                                currentOrder.remove(chips);
                                JOptionPane.showMessageDialog(mainFrame,
                                        numToRemove + "x of " + chips.getChosenChip() + " removed from cart!",
                                        "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                                showViewCartMenu();
                            }
                        } else {
                            if (numToRemove > chips.getAmountOfChips()) {
                                JOptionPane.showMessageDialog(mainFrame,
                                        "There are only " + chips.getAmountOfChips() + "x of " + chips.getChosenChip() + ".",
                                        "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                                showViewCartMenu();
                            } else {
                                chips.setAmountOfChips(chips.getAmountOfChips() - numToRemove);
                                if (chips.getAmountOfChips() == 0) {
                                    currentOrder.remove(chips);
                                }
                                JOptionPane.showMessageDialog(mainFrame,
                                        numToRemove + "x of " + chips.getChosenChip() + " removed from cart!",
                                        "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                                showViewCartMenu();
                            }
                        }
                    } else if (product instanceof Drinks) {
                        Drinks drinks = (Drinks) product;
                        if (drinks.getAmountOfDrinks() == 1) {
                            if (numToRemove > drinks.getAmountOfDrinks()) {
                                JOptionPane.showMessageDialog(mainFrame,
                                        "There are only " + drinks.getAmountOfDrinks() + "x of " + drinks.getSelectedFlavor() + ".",
                                        "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                                showViewCartMenu();
                            } else {
                                currentOrder.remove(drinks);
                                JOptionPane.showMessageDialog(mainFrame,
                                        numToRemove + "x of " + drinks.getSelectedFlavor() + " removed from cart!",
                                        "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                                showViewCartMenu();
                            }
                        } else {
                            if (numToRemove > drinks.getAmountOfDrinks()) {
                                JOptionPane.showMessageDialog(mainFrame,
                                        "There are only " + drinks.getAmountOfDrinks() + "x of " + drinks.getSelectedFlavor() + ".",
                                        "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                                showViewCartMenu();
                            } else {
                                drinks.setAmountOfDrinks(drinks.getAmountOfDrinks() - numToRemove);
                                if (drinks.getAmountOfDrinks() == 0) {
                                    currentOrder.remove(drinks);
                                }
                                JOptionPane.showMessageDialog(mainFrame,
                                        numToRemove + "x of " + drinks.getSelectedFlavor() + " removed from cart!",
                                        "Item Removed", JOptionPane.INFORMATION_MESSAGE);
                                showViewCartMenu();
                            }
                        }
                    } else if (product instanceof Sandwich) {
                        JOptionPane.showMessageDialog(mainFrame,
                                "Sandwiches cannot have partial quantities removed.",
                                "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        removePanel.add(removeQuantityButton);
        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(removePanel, BorderLayout.EAST);
        cartPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton btnBack = new JButton("⬅️  Back to Main Menu");
        btnBack.addActionListener(e -> newinitMainMenu());

        JButton btnClearCart = new JButton("❌ Clear Cart");
        btnClearCart.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(mainFrame,
                    "Are you sure you want to clear all items from your cart?",
                    "Clear Cart",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                if (currentOrder.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame,
                            "Your Cart is already Empty.",
                            "Cart Cleared",
                            JOptionPane.WARNING_MESSAGE);
                    showViewCartMenu();
                } else {
                    currentOrder.clear();
                    JOptionPane.showMessageDialog(mainFrame,
                            "Cart cleared successfully!",
                            "Cart Cleared",
                            JOptionPane.INFORMATION_MESSAGE);
                    showViewCartMenu();
                }
            }
        });
        JButton btnCheckOut = new JButton("💳  Checkout");
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
                        "You have nothing in your cart.\n        Please add items.",
                        "Order Failed", JOptionPane.INFORMATION_MESSAGE);
                newinitMainMenu();
            } else {
                FileManager.generateReceipt(totalPrice, currentOrder);
                currentOrder.clear();
                JOptionPane.showMessageDialog(mainFrame,
                        "Order confirmed! Receipt saved.\n    Thank you for your order!",
                        "Order Complete", JOptionPane.INFORMATION_MESSAGE);
                newinitMainMenu();
            }
        });
        //cancel the checkout
        cancelButton.addActionListener(e -> showViewCartMenu());
        confirmButton.setBackground(new Color(34, 139, 34));
        confirmButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(220, 20, 60));
        cancelButton.setForeground(Color.WHITE);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        checkoutPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(checkoutPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private static void createSandwich(Sandwich signatureSandwich, String itemName) {
        mainFrame.getContentPane().removeAll();
        JPanel orderSandwichScreen = new JPanel();
        orderSandwichScreen.setLayout(new BoxLayout(orderSandwichScreen, BoxLayout.Y_AXIS));
        orderSandwichScreen.setBackground(Color.WHITE);
        orderSandwichScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Customize: " + itemName);
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
        sizeOptionsBox.setSelectedItem(8);
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
        breadOptionsBox.setSelectedItem(signatureSandwich.getChoosenBreadType());
        breadOptionsBox.setMaximumSize(new Dimension(300, 30));
        breadOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        breadPanel.add(breadOptionsLabel);
        breadPanel.add(breadOptionsBox);

        JCheckBox toastedCheckBox = new JCheckBox("Is Toasted");
        toastedCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        toastedCheckBox.setOpaque(false);
        toastedCheckBox.setSelected(signatureSandwich.isToasted());
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

        //meats
        JPanel meatsPanel = new JPanel();
        meatsPanel.setLayout(new BoxLayout(meatsPanel, BoxLayout.Y_AXIS));
        meatsPanel.setBackground(Color.WHITE);
        meatsPanel.setBorder(BorderFactory.createTitledBorder("Meats"));
        ArrayList<String> signatureSandwichToppings = new ArrayList<>();
        for(Toppings toppings : signatureSandwich.getToppings())
        {
            signatureSandwichToppings.add(toppings.getName());
        }
        for (String meat : PremiumToppings.getMeatToppings()) {
            JCheckBox cb = new JCheckBox(meat);
            cb.setOpaque(false);
            if (signatureSandwichToppings.contains(meat)) {
                cb.setSelected(true);
            }
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
            cb.setOpaque(false);
            if (signatureSandwichToppings.contains(cheese)) {
                cb.setSelected(true);
            }
            cheesesPanel.add(cb);
            cheeseCheckBoxes.add(cb);
        }

        //normal toppings
        JPanel normalToppingsPanel = new JPanel();
        normalToppingsPanel.setLayout(new BoxLayout(normalToppingsPanel, BoxLayout.Y_AXIS));
        normalToppingsPanel.setBackground(Color.WHITE);
        normalToppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        for (String topping : Freetoppings.getToppings()) {
            JCheckBox cb = new JCheckBox(topping);
            cb.setOpaque(false);
            if (signatureSandwichToppings.contains(topping)) {
                cb.setSelected(true);
            }
            normalToppingsPanel.add(cb);
            toppingCheckBoxes.add(cb);
        }

        //sauces
        JPanel saucesPanel = new JPanel();
        saucesPanel.setLayout(new BoxLayout(saucesPanel, BoxLayout.Y_AXIS));
        saucesPanel.setBackground(Color.WHITE);
        saucesPanel.setBorder(BorderFactory.createTitledBorder("Sauces"));
        for (String sauce : Freetoppings.getSauceToppings()) {
            JCheckBox cb = new JCheckBox(sauce);
            cb.setOpaque(false);
            if (signatureSandwichToppings.contains(sauce)) {
                cb.setSelected(true);
            }
            saucesPanel.add(cb);
            sauceCheckBoxes.add(cb);
        }

        //sides
        JPanel sidesPanel = new JPanel();
        sidesPanel.setLayout(new BoxLayout(sidesPanel, BoxLayout.Y_AXIS));
        sidesPanel.setBackground(Color.WHITE);
        sidesPanel.setBorder(BorderFactory.createTitledBorder("Sides"));
        for (String sides : Freetoppings.getSideToppings()) {
            JCheckBox cb = new JCheckBox(sides);
            cb.setOpaque(false);
            if (signatureSandwichToppings.contains(sides)) {
                cb.setSelected(true);
            }
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
        JButton addToCartButton = new JButton("🛒 Add to Cart");
        JButton cancelOrderButton = new JButton("❌ Cancel Order");

        //adding to cart
        addToCartButton.addActionListener(e -> {
            Integer selectedSize = (Integer) sizeOptionsBox.getSelectedItem();
            String selectedBread = (String) breadOptionsBox.getSelectedItem();
            boolean isToasted = toastedCheckBox.isSelected();
            ArrayList<String> toppings = new ArrayList<>();
            ArrayList<Toppings> actualToppings = new ArrayList<>();
            boolean hasMeats = false;
            boolean hasExtraMeats = false;
            boolean hasExtraCheese = false;
            //check if extra meat is checked first
            for (JCheckBox cb : meatCheckBoxes) {
                if (cb.getText().equals("extra meat")) {
                    if (cb.isSelected()) {
                        hasExtraMeats = true;
                        hasMeats = true;
                    }
                } else {
                    if (cb.isSelected()) {
                        toppings.add(cb.getText());
                        hasMeats = true;
                    }
                }
            }
            boolean hasCheese = false;
            for (JCheckBox cb : cheeseCheckBoxes) {
                if (cb.getText().equals("extra cheese")) {
                    if (cb.isSelected()) {
                        hasExtraCheese = true;
                        hasCheese = true;
                    }
                } else {
                    if (cb.isSelected()) {
                        toppings.add(cb.getText());
                        hasCheese = true;
                    }
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
                if (Freetoppings.getToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (Freetoppings.getSideToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (Freetoppings.getSauceToppings().contains(i)) {
                    actualToppings.add(new Freetoppings(i));
                }
                if (PremiumToppings.getCheeseToppings().contains(i)) {
                    if (hasExtraCheese && !i.equals("extra cheese")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
                if (PremiumToppings.getMeatToppings().contains(i)) {
                    if (hasExtraMeats && !i.equals("extra meats")) {
                        actualToppings.add(new PremiumToppings(i, true));
                    } else {
                        actualToppings.add(new PremiumToppings(i, false));
                    }
                }
            }
            Sandwich sandwich = new Sandwich(selectedSize, selectedBread, isToasted, actualToppings,itemName);
            currentOrder.add(sandwich);
            JOptionPane.showMessageDialog(mainFrame, itemName + " added to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
}
