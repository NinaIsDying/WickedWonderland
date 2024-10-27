/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

import java.util.*;

public class GameController extends Dialogue implements GameInterface {
    private Character player;
    private Enemy enemy;
    private final Scanner scanner;
    private RandomEvent randomEvent;
    private boolean isReplay = false;  // Track if the player is replaying
    private int roundCounter;
    private String currentWorld;  // To track which world the player is in
    private final Shop shop;

    // Constructor
    public GameController() {
        scanner = new Scanner(System.in);
        randomEvent = new RandomEvent();  // Initialize RandomEvent
        shop = new Shop();
    }

    @Override
    public void startGame() {
        showMenu();
    }

    @Override
    public void showIntro() {
        for (String line : gameIntro) {
            System.out.println(Text.centerBox(line));
            System.out.print("                                                                  ->");
            String op = scanner.nextLine();  // Wait for input to proceed
    
            // Programmer shortcut to skip to choose world
            if(op.equals("Skip") || op.equals("skip") ) {
                chooseWorld();
                break;
            }
        }
    }

    @Override
    public void showMenu() {
        // Check if the player is replaying the game
        if (isReplay) {
            System.out.println(Text.centerText("Skip intro? (Y/N)"));
            System.out.print("                                                                  ->");
            char option = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline

            if(option == 'Y' || option == 'y') {
                chooseWorld();  // Skip intro and go directly to world selection
            } else if (option == 'N' || option == 'n') {
                showIntro();
                chooseWorld();
            } else {
                System.out.println(Text.centerText("Invalid option. Please choose Y or N."));
                showMenu();  // Retry if invalid input
            }
        } else {
   
            // First-time players see the full intro
            showIntro();
            chooseWorld();
             
        }
    }

    // World Selection after Intro or Skip
    public void chooseWorld() {
        boolean validChoice = false;
        
        while (!validChoice) {
            try {
                System.out.println(Text.centerText("WELCOME TO WICKED WONDERLAND!\n1. Start Game\n2. Exit\nChoose an option: "));
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        player = new Cinderella();  // Set default player as Cinderella
                        validChoice = true;
                        chooseWorldSelection();  // Proceed to world selection
                    }
                    case 2 -> {
                        System.out.println(Text.centerText("Goodbye!"));
                        validChoice = true;
                    }
                    default -> {
                        System.out.println(Text.centerText("Please choose a valid option."));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(Text.centerText("Invalid input! Please enter a number."));
                scanner.nextLine();  // Clear invalid input
            }
        }
    }

    // World Selection Menu
    public void chooseWorldSelection() {
        boolean validWorldChoice = false;

        while (!validWorldChoice) {
            try {
                System.out.println(Text.centerText("Choose Your World:\n1. Cinderella: The Shattered Palace\n2. Mad Wonderland\n3. Snow White: Not So White"));
                System.out.print("                                                                  ->");
                int worldChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (worldChoice) {
                    case 1 -> {
                        currentWorld = "Cinderella";  // Track current world
                        player = new Cinderella();  // Set player to Cinderella
                        worldOne();  // Start Cinderella's world
                        validWorldChoice = true;
                    }
                    case 2 -> {
                        currentWorld = "Alice";  // Track current world
                        player = new Alice();  // Set player to Alice
                        worldTwo();  // Start Alice's world
                        validWorldChoice = true;
                    }
                    case 3 -> {
                        currentWorld = "SnowWhite";  // Track current world
                        player = new SnowWhite();  // Set player to Snow White
                        worldThree();  // Start Snow White's world
                        validWorldChoice = true;
                    }
                    default -> {
                        System.out.println(Text.centerText("Please choose a valid world."));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(Text.centerText("Invalid input! Please enter a number."));
                scanner.nextLine();  // Clear invalid input
            }
        }
    }

    // World One - Cinderella's storyline
    public void worldOne() {
        boolean continueAdventure = true;

        while (continueAdventure) {
            roundCounter = 0;
            enemy = new Minion();  // Fight a minion first
            System.out.println(Text.centerBox("Entering Cinderella: The Shattered Palace..."));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding


                     
            displayDialogue(introCinderella);
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            // Display Pre-Battle Narration
            randomEvent.displayPreBattleNarration("Cinderella");
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
            
            displayDialogue(introCinderellaContinue);
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
            
            System.out.println(Text.centerText(DARK_CREATURE_ENTRANCE));
            continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Use Cinderella's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration
                System.out.println(Text.centerText(DARK_CREATURE_EXIT));

                randomEvent.displayPreBattleNarration("Cinderella");
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding
                
                shop.purchaseItem(player);     
                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event
                
                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("Cinderella");
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new Marionnette();
                System.out.println(Text.centerText(MARIONETTE_KNIGHT_ENTRANCE));
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);
            }

            if (continueAdventure) {
                System.out.println(Text.centerText(MARIONETTE_KNIGHT_EXIT));
                
                shop.purchaseItem(player);
             
                System.out.println(Text.centerText("Now face the final challenge... Prince Henry awaits!"));
                enemy = new PrinceHenry();  // Boss fight
                System.out.println(Text.centerText(PRINCE_HENRY_ENTRANCE));
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                System.out.println(Text.centerText(PRINCE_HENRY_EXIT));
                randomEvent.displayPostBattleNarration(currentWorld);
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText("Congratulations! You have defeated Prince Henry and completed Cinderella's story."));
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    break;
                }
            } else {
                System.out.println(Text.centerText("You have been defeated. Restarting game..."));
                isReplay = true;
                showMenu();  // Restart from menu
            }
        }
    }

    // World Two - Placeholder for Alice's world
    public void worldTwo() {
        boolean continueAdventure = true;

        while (continueAdventure) {
            roundCounter = 0;
            enemy = new Minion();  // Example enemy for Alice's world
            System.out.println(Text.centerBox("Entering Alice: Mad Wonderland..."));

            // Display Pre-Battle Narration
            randomEvent.displayPreBattleNarration("Alice");
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            displayDialogue(introAlice);  // Display Alice's intro dialogue
            System.out.print("                                                                  ->");
            scanner.nextLine(); // Wait for input before proceeding
            continueAdventure = battleSequence(Alice.ALICE_ATTACKS);  // Pass Alice's attacks

            if (continueAdventure) {
                // Display Post-Battle Narration after minion defeat
                randomEvent.displayPostBattleNarration(currentWorld);
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                shop.purchaseItem(player);

                randomEvent.displayRandomEvent(player);

                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("Alice");
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new Minion();  // Example minion for Alice's world
                continueAdventure = battleSequence(Alice.ALICE_ATTACKS);
            }

            if (continueAdventure) {
          
                shop.purchaseItem(player);

                System.out.println(Text.centerText("Now face the final challenge... The Queen of Hearts awaits!"));
                enemy = new MadHatter();  // Boss fight
                continueAdventure = battleSequence(Alice.ALICE_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                randomEvent.displayPostBattleNarration(currentWorld);
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText("Congratulations! You have defeated the Queen of Hearts and completed Alice's story."));
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    break;
                }
            } else {
                System.out.println(Text.centerText("You have been defeated. Restarting game..."));
                isReplay = true;
                showMenu();
            }
        }
    }

    
    // World Three - Snow White's storyline
    public void worldThree() {
        boolean continueAdventure = true;

        while (continueAdventure) {
            roundCounter = 0;
            enemy = new Minion();  // Fight a minion first
            System.out.println(Text.centerBox("Entering Snow White: The Enchanted Forest..."));

            // Display Pre-Battle Narration
            randomEvent.displayPreBattleNarration("SnowWhite");
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            displayDialogue(introSnowWhite);  // Assuming you have a dialogue for Snow White
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);  // Use Snow White's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("SnowWhite");
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                shop.purchaseItem(player);  // Allow player to purchase items

                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event

                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("SnowWhite");
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new Minion();  // Intermediate enemy
                continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);  // Use Snow White's attack options
            }

            if (continueAdventure) {
                shop.purchaseItem(player);  // Allow another purchase before boss fight

                System.out.println(Text.centerText("Now face the final challenge... The Evil Queen awaits!"));
                enemy = new EvilQueen();  // Boss fight
                continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                randomEvent.displayPostBattleNarration(currentWorld);
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText("Congratulations! You have defeated the Evil Queen and completed Snow White's story."));
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    break;
                }
            } else {
                System.out.println(Text.centerText("You have been defeated. Restarting game..."));
                isReplay = true;
                showMenu();  // Restart from menu
            }
        }
    }

    
    // Battle sequence method with customizable attack options
    @Override
    public boolean battleSequence(String attackOptions) {
        boolean firstLineDisplayed = false;
        roundCounter = 0;
        boolean usedInvisibilityLastTurn = false; // Track if invisibility was used last turn
    
        // Display character health status before and after each round.
    
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
      
            System.out.println();
            if (!firstLineDisplayed) {
                displayDialogue(battleStart);
                System.out.print("                                                                  ->");
                firstLineDisplayed = true;
            }
            
            scanner.nextLine(); //consume enter
            clearScreen();
            //clears screen before every round
            displayRound();            
            displayEnemyStatus();
            displayPlayerStatus();

            System.out.println(Text.centerText("CHOOSE YOUR ATTACK:\n" + attackOptions));
            System.out.print("                                                                  ->");
            int action = scanner.nextInt();
            scanner.nextLine();
    
            if (player.getMana() <= 0 && action != 1) {
                System.out.println(Text.centerText("You don't have enough mana. You can only use basic attack!"));
                action = 1;
            }
    
            switch (action) {
                case 1 -> {
                    player.specialSkill1(enemy);
                    System.out.println(Text.centerText(player.getName() + " uses " + cinderellaSkills[0] + "\n" +
                            player.getName() + " deals " + player.getSkillDamage(1) + " damage to " + enemy.getName() + "! "));
                    usedInvisibilityLastTurn = false; // Reset invisibility usage
                }
                case 2 -> {
                    player.specialSkill2(enemy);
                    System.out.println(Text.centerText(player.getName() + " uses " + cinderellaSkills[1] + "\n" +
                            player.getName() + " deals " + player.getSkillDamage(2) + " damage to " + enemy.getName() + "! "));
                    usedInvisibilityLastTurn = false; // Reset invisibility usage
                }
                case 3 -> {
                    player.specialSkill3(enemy);
                    System.out.println(Text.centerText(player.getName() + " uses " + cinderellaSkills[2] + "\n" +
                            player.getName() + " cannot be attacked for one turn!"));
                    usedInvisibilityLastTurn = true; // Set invisibility usage
                }
                default -> {
                    System.out.println(Text.centerText("Invalid action!"));
                    continue;
                }
            }
    
            // Handle enemy attack if Cinderella is not invisible
            if (enemy.isAlive()) {
                if (!(player instanceof Cinderella && ((Cinderella) player).isInvisible())) {
                    enemy.attack(player);
                } else {
                    System.out.println(Text.centerText(enemy.getName() + " attempts to attack but " + player.getName() + " is invisible!"));
                }
            }
    
            // Check player health status after enemy attack
            if (!player.isAlive()) {
                System.out.println(Text.centerText(player.getName() + " has been defeated..."));
                return false;
            }
    
            // Check enemy health status after player attack
            if (!enemy.isAlive()) {
                clearScreen();
                System.out.println(Text.centerText(enemy.getName() + " has been defeated!\nYou can continue your adventure!"));
                player.addGold(75); // Award 75 gold for winning
                System.out.println(Text.centerBox("You received 75 gold"));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                return true;
            }
    
            // At the end of the round, reset invisibility
            if (player instanceof Cinderella) {
                if (usedInvisibilityLastTurn) {
                    System.out.println(Text.centerText(player.getName() + "'s invisibility wore off..."));
                }
                ((Cinderella) player).endTurn(); // Reset invisibility status
            }
        }
        return true;
    }
    
    
    @Override
    public boolean journey() {
        return true;
    }

    private void displayPlayerStatus() {
        // Include round counter in the player status display
        System.out.println(Text.centerText(60, 160, "Player Status: \nHealth: " + player.getHealth() +
                                           "\nMana: " + player.getMana()));
    }
    
    private void displayRound(){
        roundCounter++;
        System.out.println(Text.centerText("Round: " + roundCounter));
    }

    private void displayEnemyStatus() {
        System.out.println(Text.centerText(60, 240, enemy.getName() + "\n Status: \nHealth: " + enemy.getHealth()));
    }

    //clear screen stuff
    public static void clearScreen() {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
        
    
}



