package com.ps;

import com.ps.Core.Order;
import com.ps.Core.PremiumToppings;
import com.ps.Core.Sandwich;
import com.ps.Core.Toppings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class UserInterface {

    private static JFrame mainFrame;
    public static void initMainMenu()
    {
        mainFrame = new JFrame("DELI-cious - Main menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - mainFrame.getWidth()) / 2;
        int y = (screenSize.height - mainFrame.getHeight()) / 2;
        mainFrame.setLocation(x, y);

        //making the background white
        Color logoBg = new Color(255, 255, 255);
        mainFrame.getContentPane().setBackground(logoBg);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7,1,10,20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // DELI logo image
        ImageIcon icon = new ImageIcon("D:\\Edit\\Edit Pics\\image-imageonline.co-merged (1).png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 0));
        leftPanel.setBackground(logoBg);
        leftPanel.add(imageLabel);
        mainFrame.add(leftPanel, BorderLayout.WEST);

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
        menuButton.addActionListener(e -> showMenuScreen());

        //TODO: needs to be able to add sandwich to cart including all the toppings (can be more than 1 topping)
        menuPanel.add(orderSandwichButton);
        orderSandwichButton.addActionListener(e -> showOrderSandwichScreen());

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
        mainFrame.add(menuPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }

    public static void newinitMainMenu()
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - mainFrame.getWidth()) / 2;
        int y = (screenSize.height - mainFrame.getHeight()) / 2;
        mainFrame.setLocation(x, y);

        //making the background white
        Color logoBg = new Color(255, 255, 255);
        mainFrame.getContentPane().setBackground(logoBg);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7,1,10,20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // DELI logo image
        ImageIcon icon = new ImageIcon("D:\\Edit\\Edit Pics\\image-imageonline.co-merged (1).png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 30));
        leftPanel.setBackground(logoBg);
        leftPanel.add(imageLabel);
        mainFrame.add(leftPanel, BorderLayout.WEST);

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
        menuButton.addActionListener(e -> showMenuScreen());

        //TODO: needs to be able to add sandwich to cart including all the toppings (can be more than 1 topping)
        menuPanel.add(orderSandwichButton);
        orderSandwichButton.addActionListener(e -> showOrderSandwichScreen());

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
        mainFrame.add(menuPanel, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }

    private static void showMenuScreen() {
        mainFrame.getContentPane().removeAll();
        JPanel foodMenuScreen = new JPanel(new BorderLayout());
        foodMenuScreen.setBackground(Color.WHITE);

        JLabel menuTitle = new JLabel("Menu",SwingConstants.CENTER);
        menuTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        foodMenuScreen.add(menuTitle, BorderLayout.NORTH);

        // Scrollable content area
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
        JComboBox<Integer> sizeOptionsBox = new JComboBox<>(new Integer[]{4, 8, 12});
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
        JComboBox<String> breadOptionsBox = new JComboBox<>(new String[]{"White", "Wheat", "Rye", "Italian", "Flatbread"});
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

        //add ons coloum
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new GridLayout(1, 4, 20, 0));

        ArrayList<JCheckBox> meatCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> cheeseCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> toppingCheckBoxes = new ArrayList<>();
        ArrayList<JCheckBox> sauceCheckBoxes = new ArrayList<>();

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
            normalToppingsPanel.add(cb);
            cb.setOpaque(false);
            normalToppingsPanel.add(cb);
        }

        //sauces
        JPanel saucesPanel = new JPanel();
        saucesPanel.setLayout(new BoxLayout(saucesPanel, BoxLayout.Y_AXIS));
        saucesPanel.setBackground(Color.WHITE);
        saucesPanel.setBorder(BorderFactory.createTitledBorder("Sauces"));
        for (String sauce : Toppings.getSauceToppings()) {
            String label = "<html>" + sauce + "</html>";
            JCheckBox cb = new JCheckBox(label);
            cb.setOpaque(false);
            saucesPanel.add(cb);
            sauceCheckBoxes.add(cb);
        }

        toppingsPanel.add(meatsPanel);
        toppingsPanel.add(cheesesPanel);
        toppingsPanel.add(normalToppingsPanel);
        toppingsPanel.add(saucesPanel);

        meatsPanel.setOpaque(false);
        cheesesPanel.setOpaque(false);
        toppingsPanel.setOpaque(false);
        saucesPanel.setOpaque(false);

        //fixed the very long vertical columns
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
            if(toastedCheckBox.isSelected())
            {
                isToasted = true;
            }
            ArrayList<String> toppings = new ArrayList<>();
            for(JCheckBox cb: meatCheckBoxes)
            {
                if(cb.isSelected())
                {
                    toppings.add(cb.getText());
                }
            }
            for(JCheckBox cb: cheeseCheckBoxes)
            {
                if(cb.isSelected())
                {
                    toppings.add(cb.getText());
                }
            }
            for(JCheckBox cb: toppingCheckBoxes)
            {
                if(cb.isSelected())
                {
                    toppings.add(cb.getText());
                }
            }
            for(JCheckBox cb: sauceCheckBoxes)
            {
                if(cb.isSelected())
                {
                    toppings.add(cb.getText());
                }
            }
            Order currentOrder = new Order();
            Sandwich sandwich = new Sandwich(selectedSize,selectedBread,isToasted,toppings);
            currentOrder.addProduct(sandwich);

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
}
