
import java.util.*;

public class Shop {
    private final List<Item> itemsForSale;
    private final Scanner scanner;

    // Constructor initializes available items
    public Shop() {
        itemsForSale = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeShop();
    }

    // Initialize the shop with items for sale
    private void initializeShop() {
        // Adding existing items
        itemsForSale.add(new Item("Health Potion", 50, "heal", 50));
        itemsForSale.add(new Item("Attack Boost", 100, "attackBoost", 10));

        // Adding new items based on your character design
        itemsForSale.add(new Item("Defense Shield", 80, "defenseBoost", 20));      // Boosts defense by 20 (could reduce incoming damage)
        itemsForSale.add(new Item("Mana Potion", 60, "restoreMana", 30));         // Restores 30 mana points
        itemsForSale.add(new Item("Speed Elixir", 120, "speedBoost", 15));        // Increases speed by 15 (adjust initiative or agility)
        itemsForSale.add(new Item("Critical Strike Charm", 200, "critBoost", 25));// Increases critical strike chance by 25%
    }

    // Display shop items and player's available gold
    public void displayShop(Character player) {
        StringBuilder shopContent = new StringBuilder();
        shopContent.append("Welcome to the Shop!\n\n");
        shopContent.append("Available Gold: ").append(player.getGold()).append("\n\n"); // Display available gold
        shopContent.append("Available items:\n");

        for (int i = 0; i < itemsForSale.size(); i++) {
            shopContent.append((i + 1)).append(". ").append(itemsForSale.get(i).displayItem()).append("\n");
        }
        shopContent.append((itemsForSale.size() + 1)).append(". Exit Shop");
        shopContent.append("\nWhat would you like to buy?");

        // Center the whole content inside a box
        System.out.println(Text.centerText(shopContent.toString()));
    }


    // Handle purchasing items
    public void purchaseItem(Character player) {
        boolean continueShopping = true;  // Controls further shopping
        boolean firstTime = true;  // Track if this is the first prompt

        while (continueShopping) {
            if (firstTime) {
                // First time: Ask "Would you like to buy something?"
                System.out.println(Text.centerText("As you venture out into the world, a sparkle in the distance catches your eye.\nUpon closer inspection, there is a little house with the words 'Shop' painted onto the door.\nWould you like to come in? (Y/N)"));
                System.out.print("                                                                  ->");
                String confirmation = scanner.nextLine().trim().toUpperCase();

                if (confirmation.equals("Y")) {
                    displayShop(player);
                    firstTime = false; // From now on, no need to ask this question again
                } else if (confirmation.equals("N")) {
                    System.out.println(Text.centerText("Okay, feel free to come back later!"));
                    return; // Exit the shop
                } else {
                    System.out.println(Text.centerText("Invalid option. Please enter 'Y' or 'N'."));
                    continue;
                }
            }

            // Handle the item purchase
            if (handleItemPurchase(player)) {
                // If an item was successfully purchased, ask if they want to continue
                continueShopping = askContinueShopping();
                if (continueShopping) {
                    displayShop(player);  // Show the shop again after deciding to continue
                }
            } else {
                continueShopping = false; // Exit if no item was purchased or they chose to leave
            }
        }
    }

    // Handles the purchase flow and returns whether the player successfully bought something
    private boolean handleItemPurchase(Character player) {
        boolean validItemChoice = false;

        while (!validItemChoice) {
            try {
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt(); // Get the choice directly after displaying the shop
                scanner.nextLine(); // Consume newline

                if (choice > 0 && choice <= itemsForSale.size()) {
                    Item selectedItem = itemsForSale.get(choice - 1);

                    if (player.getGold() >= selectedItem.getPrice()) {
                        processPurchase(player, selectedItem);
                        validItemChoice = true; // Exit item choice loop
                        return true; // Player successfully made a purchase
                    } else {
                        System.out.println(Text.centerText("You don't have enough gold."));
                    }
                } else if (choice == itemsForSale.size() + 1) {
                    System.out.println(Text.centerText("Exiting the shop."));
                    return false; // Exit the shop
                } else {
                    System.out.println(Text.centerText("Invalid option. Please choose again."));
                }
            } catch (InputMismatchException e) {
                System.out.println(Text.centerText("Invalid input! Please enter a number."));
                scanner.nextLine(); // Clear invalid input
            }
        }
        return false;
    }

    // Ask if the player wants to continue shopping after a purchase
    private boolean askContinueShopping() {
        while (true) {
            System.out.println(Text.centerText("Would you like to purchase something else? (Y/N)"));
            System.out.print("                                                                  ->");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("Y")) {
                return true;  // Continue shopping
            } else if (choice.equals("N")) {
                System.out.println(Text.centerText("Thanks for visiting the shop!"));
                return false;  // Exit shopping
            } else {
                System.out.println(Text.centerText("Invalid input! Please enter 'Y' or 'N'."));
            }
        }
    }

    // Process item purchase
    private void processPurchase(Character player, Item item) {
        player.decreaseGold(item.getPrice());

        switch (item.getEffect()) {
            case "heal" -> {
                player.heal(item.getValue());
                System.out.println(Text.centerText("You bought a Health Potion! Your health is now: " + player.getHealth()));
            }
            case "attackBoost" -> {
                player.increaseAttack(item.getValue());
                System.out.println(Text.centerText("You bought an Attack Boost! Your attack power increased by " + item.getValue()));
            }
            case "defenseBoost" -> {
                // Apply defense boost logic (you can adjust this logic based on how defense works in your game)
                System.out.println(Text.centerText("You bought a Defense Shield! You will take reduced damage for a short time."));
            }
            case "restoreMana" -> {
                player.increaseMana(item.getValue());
                System.out.println(Text.centerText("You bought a Mana Potion! Your mana is now: " + player.getMana()));
            }
            case "speedBoost" -> {
                // Apply speed boost logic (you can handle this based on your game's turn system)
                System.out.println(Text.centerText("You bought a Speed Elixir! Your speed increased by " + item.getValue()));
            }
            case "critBoost" -> {
                // Apply critical strike chance boost logic (handle crit chance in your game logic)
                System.out.println(Text.centerText("You bought a Critical Strike Charm! Your critical hit chance increased by " + item.getValue() + "%"));
            }
        }
    }
}
