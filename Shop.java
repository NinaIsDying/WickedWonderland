/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

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
         itemsForSale.add(new Item("Health Potion", 30, "heal", 50)); // Restores 50 health
         itemsForSale.add(new Item("Attack Boost", 100, "attackBoost", 10)); // Increases attack power
         itemsForSale.add(new Item("Mana Potion", 30, "restoreMana", 50)); // Restores 30 mana points
         
         // Adding new potions
         itemsForSale.add(new Item("Elixir of Vitality", 75, "heal", Integer.MAX_VALUE)); // Full health
         itemsForSale.add(new Item("Essence of Clarity", 75, "restoreMana", Integer.MAX_VALUE)); // Full mana
         itemsForSale.add(new Item("Ultimate Elixir", 150, "ultimate", Integer.MAX_VALUE)); // Full health and mana
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
         player.adjustGold(item.getPrice());
 
         switch (item.getEffect()) {
             case "heal" -> {
                if(player.getHealth() == player.getMaxHealth()){
                    System.out.println(Text.centerText("Health is already full! Purchase failed"));
                    break;
                }
                 if (item.getValue() == Integer.MAX_VALUE) {
                     player.setHealth(player.getMaxHealth()); // Full health restoration
                     System.out.println(Text.centerText("You bought an Elixir of Vitality! Your health is now: " + player.getHealth()));
                 } else {
                     player.restoreHealth(item.getValue());
                     System.out.println(Text.centerText("You bought a Health Potion! Your health is now: " + player.getHealth()));
                 }
             }
             case "attackBoost" -> {
                 player.setAttackPower( player.attackPower += item.getValue());
                 System.out.println(Text.centerText("You bought an Attack Boost! Your attack power increased by " + item.getValue()));
             }
             case "restoreMana" -> {
                if(player.getMana() == player.getMaxMana()){
                    System.out.println(Text.centerText("Mana is already full! Purchase failed"));
                    break;
                }
                 if (item.getValue() == Integer.MAX_VALUE) {
                     player.setMana(player.getMaxMana()); // Full mana restoration
                     System.out.println(Text.centerText("You bought an Essence of Clarity! Your mana is now: " + player.getMana()));
                 } else {
                     player.restoreHealth(item.getValue());
                     System.out.println(Text.centerText("You bought a Mana Potion! Your mana is now: " + player.getMana()));
                 }
             }
             case "ultimate" -> {
                 player.setHealth(player.getMaxHealth()); // Full health restoration
                 player.setMana(player.getMaxMana()); // Full mana restoration
                 System.out.println(Text.centerText("You bought an Ultimate Elixir! Your health is now: " + player.getHealth() + " and mana is: " + player.getMana()));
             }
         }
     }
 }
 