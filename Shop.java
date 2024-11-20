import java.util.*;

public class Shop {
    private final List<Item> itemsForSale;
    private final Scanner scanner;

    public Shop() {
        itemsForSale = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeShop();
    }

    private void initializeShop() {
        // Add regular items with descriptions in brackets
        itemsForSale.add(new Item("Health Potion", 50, "heal", 50, " ----------------- [Restores 50 health]")); 
        itemsForSale.add(new Item("Mana Potion", 50, "restoreMana", 50, " ------------------ [Restores 50 mana]"));

        // New options to increase max health and max mana with descriptions
        itemsForSale.add(new Item("Elixir of Vitality", 100, "heal", Integer.MAX_VALUE, " ----------- [Fully restores health]"));
        itemsForSale.add(new Item("Essence of Clarity", 100, "restoreMana", Integer.MAX_VALUE, " ------------ [Fully restores mana]"));
        itemsForSale.add(new Item("Ultimate Elixir", 200, "ultimate", Integer.MAX_VALUE, " ------ [Fully restores both health and mana]"));
    }

    public void displayShop(Character player) {
        StringBuilder shopContent = new StringBuilder();
        shopContent.append("Welcome to the Shop!\n\n");
        shopContent.append("Available Gold: ").append(player.getGold()).append("\n\n");
        shopContent.append("Available items:\n");

        for (int i = 0; i < itemsForSale.size(); i++) {
            shopContent.append((i + 1)).append(". ").append(itemsForSale.get(i).displayItem()).append("\n");
        }
        shopContent.append((itemsForSale.size() + 1)).append(". Exit Shop");
        shopContent.append("\n\nWhat would you like to buy? [Enter 1 - 5] [Enter 6 to Exit]");

        System.out.println(Text.centerText(shopContent.toString()));
    }

    public void purchaseItem(Character player) {
        boolean continueShopping = true;
        boolean firstTime = true;

        while (continueShopping) {
            if (firstTime) {
                System.out.println(Text.centerText("As you venture out into the world, a sparkle in the distance catches your eye.\nUpon closer inspection, there is a little house with the words 'Shop' painted onto the door.\nWould you like to come in? (Y/N)"));
                System.out.print("                                                                  ->");
                String confirmation = scanner.nextLine().trim().toUpperCase();

                if (confirmation.equals("Y")) {
                    displayShop(player);
                    firstTime = false;
                } else if (confirmation.equals("N")) {
                    System.out.println(Text.centerText("Okay, feel free to come back later!"));
                    return;
                } else {
                    System.out.println(Text.centerText("Invalid option. Please enter 'Y' or 'N'."));
                    continue;
                }
            }

            if (handleItemPurchase(player)) {
                continueShopping = askContinueShopping();
                if (continueShopping) {
                    displayShop(player);
                }
            } else {
                continueShopping = false;
            }
        }
    }

    private boolean handleItemPurchase(Character player) {
        boolean validItemChoice = false;

        while (!validItemChoice) {
            try {
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice > 0 && choice <= itemsForSale.size()) {
                    Item selectedItem = itemsForSale.get(choice - 1);

                    if (player.getGold() >= selectedItem.getPrice()) {
                        processPurchase(player, selectedItem);
                        validItemChoice = true;
                        return true;
                    } else {
                        System.out.println(Text.centerText("You don't have enough gold. Please choose another item.  [Enter 1 - 5] [Enter 6 to Exit]"));
                        displayShop(player);
                    }
                } else if (choice == itemsForSale.size() + 1) {
                    System.out.println(Text.centerText("Exiting the shop."));
                    return false;
                } else {
                    System.out.println(Text.centerText("Invalid option. Please choose again."));
                }
            } catch (InputMismatchException e) {
                System.out.println(Text.centerText("Invalid input! Please enter a number."));
                scanner.nextLine();
            }
        }
        return false;
    }

    private boolean askContinueShopping() {
        while (true) {
            System.out.println(Text.centerText("Would you like to purchase something else? (Y/N)"));
            System.out.print("                                                                  ->");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("Y")) {
                return true;
            } else if (choice.equals("N")) {
                System.out.println(Text.centerText("Thanks for visiting the shop!"));
                return false;
            } else {
                System.out.println(Text.centerText("Invalid input! Please enter 'Y' or 'N'."));
            }
        }
    }

    private void processPurchase(Character player, Item item) {
        // Only deduct gold after successfully processing the item effect
        boolean purchaseSuccessful = false;
    
        switch (item.getEffect()) {
            case "heal" -> {
                if (player.getHealth() == player.getMaxHealth()) {
                    System.out.println(Text.centerText("Health is already full! Purchase failed."));
                } else {
                    if (item.getValue() == Integer.MAX_VALUE) {
                        player.restoreFullHealth();
                        System.out.println(Text.centerText("You bought an Elixir of Vitality! Your health is now full."));
                    } else {
                        player.restoreHealth(item.getValue());
                        System.out.println(Text.centerText("You bought a Health Potion! Your health is now: " + player.getHealth()));
                    }
                    purchaseSuccessful = true;
                }
            }
    
            case "restoreMana" -> {
                if (player.getMana() == player.getMaxMana()) {
                    System.out.println(Text.centerText("Mana is already full! Purchase failed."));
                } else {
                    if (item.getValue() == Integer.MAX_VALUE) {
                        player.restoreFullMana();
                        System.out.println(Text.centerText("You bought an Essence of Clarity! Your mana is now full."));
                    } else {
                        player.adjustMana(item.getValue());
                        System.out.println(Text.centerText("You bought a Mana Potion! Your mana is now: " + player.getMana()));
                    }
                    purchaseSuccessful = true;
                }
            }
    
            case "ultimate" -> {
                // This could handle cases where both health and mana are restored
                if (player.getHealth() == player.getMaxHealth() && player.getMana() == player.getMaxMana()) {
                    System.out.println(Text.centerText("Both health and mana are already full! Purchase failed."));
                } else {
                    player.restoreFullHealth();
                    player.restoreFullMana();
                    System.out.println(Text.centerText("You bought the Ultimate Elixir! Both health and mana are now full."));
                    purchaseSuccessful = true;
                }
            }
        }
    
        // Only deduct gold if the purchase was successful
        if (purchaseSuccessful) {
            player.adjustGold(-item.getPrice());
        }
    }
    
}