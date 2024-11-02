
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
    private static final Random random = new Random();


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
                System.out.println(Text.centerText(40,WELCOME_TEXT));
                System.out.print("                                                                                      ->");
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
                System.out.println(Text.centerText(chooseWorlds));
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
            
            displayDialogue(introCinderellaContinue);
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
            
            System.out.println(Text.centerBox(JAQ_AND_GUS_ENTRANCE));
            System.out.print("                                                                  ->");
                scanner.nextLine();
            continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Use Cinderella's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration
                System.out.println(Text.centerBox(JAQ_AND_GUS_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                System.out.println(Text.centerBox(VICTORY_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                shop.purchaseItem(player);     
                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event
     

                enemy = new FairyGodMother();
              
                System.out.println(Text.centerBox(ENTRANCE_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                System.out.println(Text.centerBox(FAIRY_GODMOTHER_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);

            }

            if (continueAdventure) {
                System.out.println(Text.centerBox(FAIRY_GODMOTHER_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
              
                System.out.println(Text.centerBox(VICTORY_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                shop.purchaseItem(player);
             
                System.out.println(Text.centerBox(ENTRANCE_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                
                System.out.println(Text.centerBox("Now face the final challenge... Prince Henry awaits!"));
                enemy = new PrinceHenry();  // Boss fight

              
                System.out.println(Text.centerBox(PRINCE_HENRY_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                System.out.println(Text.centerBox(PRINCE_HENRY_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                randomEvent.displayPostBattleNarration(currentWorld);
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText(120, CINDERELLA_ENDING));
                System.out.println(Text.centerBox("You've completed Cinderella's story and broke the curse!\n"));
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    System.exit(0);
                }
            } else {
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                System.out.print("                                                                  ->");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    System.exit(0);
                }
            }
        }
    }

    // World Two - Alice: Mad Wonderland
@Override
public void worldTwo() {
    boolean continueAdventure = true;

    while (continueAdventure) {
        roundCounter = 0;
        enemy = new CardSoldier();  // Initial enemy for Alice's world
        System.out.println(Text.centerBox("Entering Alice: Mad Wonderland..."));
        System.out.print("                                                                  ->");
        scanner.nextLine();  // Wait for input before proceeding

        // Introduction Dialogue for Alice's Story
        displayDialogue(introAlice);
        System.out.print("                                                                  ->");
        scanner.nextLine();  // Wait for input before proceeding

        displayDialogue(introAliceContinue);
        System.out.print("                                                                  ->");
        scanner.nextLine();  // Wait for input before proceeding

        System.out.println(Text.centerBox(WHITE_RABBIT_ENTRANCE));
        System.out.print("                                                                  ->");
        scanner.nextLine();
        continueAdventure = battleSequence(ALICE_ATTACKS);  // Use Alice's attack options

        if (continueAdventure) {
            // Pre-Battle Narration for Second Fight
            System.out.println(Text.centerBox(WHITE_RABBIT_EXIT));
            System.out.print("                                                                  ->");
            scanner.nextLine();
            System.out.println(Text.centerBox(VICTORY_TEXT_1));
            System.out.print("                                                                  ->");
            scanner.nextLine();

            shop.purchaseItem(player);     
            randomEvent.displayRandomEvent(player);  // After defeating Card Soldier, trigger random event

            // Battle with the Cheshire Cat
            enemy = new CheshireCat();
            System.out.println(Text.centerBox(CHESHIRE_CAT_ENTRANCE));
            System.out.print("                                                                  ->");
            scanner.nextLine();
            continueAdventure = battleSequence(ALICE_ATTACKS);

        }

        if (continueAdventure) {
            // Pre-Boss Narration
            System.out.println(Text.centerBox(CHESHIRE_CAT_EXIT));
            System.out.print("                                                                  ->");
            scanner.nextLine();

            System.out.println(Text.centerBox(VICTORY_TEXT_2));
            System.out.print("                                                                  ->");
            scanner.nextLine();

            shop.purchaseItem(player);

            // Alice's Final Battle with the Queen of Hearts
            System.out.println(Text.centerBox(WHITE_RABBIT_ENTRANCE));
            System.out.print("                                                                  ->");
            scanner.nextLine();

            System.out.println(Text.centerBox("Now face the final challenge... The Queen of Hearts awaits!"));
            enemy = new WhiteRabbit();  // Boss fight for Alice's world

            continueAdventure = battleSequence(ALICE_ATTACKS);  // Boss battle with Alice's skills
        }

        if (continueAdventure) {
            // Post-Battle Narration for Alice's Story Completion
            System.out.println(Text.centerBox(WHITE_RABBIT_EXIT));
            System.out.print("                                                                  ->");
            scanner.nextLine();
            randomEvent.displayPostBattleNarration(currentWorld);
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            System.out.println(Text.centerText(120, ALICE_ENDING));
            System.out.println(Text.centerBox("You've completed Alice's story and freed Wonderland!\n"));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
            System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
            System.out.print("                                                                  ->");
            int choice = scanner.nextInt();
            if (choice == 1) {
                isReplay = true;
                showMenu();  // Return to main menu
            } else {
                System.out.println(Text.centerText("Thank you for playing!"));
                System.exit(0);
            }
        } else {
            System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
            System.out.print("                                                                  ->");
            int choice = scanner.nextInt();
            if (choice == 1) {
                isReplay = true;
                showMenu();  // Return to main menu
            } else {
                System.out.println(Text.centerText("Thank you for playing!"));
                System.exit(0);
            }
        }
    }
}


    
    // World Three - Snow White's storyline
    @Override
    public void worldThree() {
        boolean continueAdventure = true;

        while (continueAdventure) {
            roundCounter = 0;
            enemy = new Minion();  // Fight a minion first
            System.out.println(Text.centerBox("Entering Snow White: The Enchanted Forest..."));

            displayDialogue(introSnowWhite);  // Assuming you have a dialogue for Snow White
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);  // Use Snow White's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration

                shop.purchaseItem(player);  // Allow player to purchase items
                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event

                // Display Pre-Battle Narrati

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

    
    //randomizer for random gold amount after every battle
    public static int generateRandomGold(int min, int max) {
        return random.nextInt(max - min + 1) + min; 
    }

    // Battle sequence method with customizable attack options
    @Override
    public boolean battleSequence(String attackOptions) {        
        boolean firstLineDisplayed = false;
        int goldAmount = generateRandomGold(50, 150);
        roundCounter = 1;
        boolean usedInvisibilityLastTurn = false; // Track if invisibility was used last turn
    
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println();
            if (!firstLineDisplayed) {
                displayDialogue(battleStart);
                firstLineDisplayed = true;
            }
            
            scanner.nextLine();
            //pause para di ma shock!
            clearScreen(); // Clear screen before every round
            displayRound();            
            displayEnemyStatus();
            displayPlayerStatus(); 
    
            System.out.println(Text.centerText(60,"CHOOSE YOUR ATTACK:\n" + attackOptions));
            System.out.print("                                                                      Choose Attack->");
            int action = scanner.nextInt();
            System.err.println();
                
            if (player.getMana() <= 0 && action != 1) {
                System.out.println(Text.centerText("You don't have enough mana. You can only use basic attack!"));
                action = 1;
            }

            // Show the skill description
            String skillDescription = SkillBoxes.getSkillDescription(currentWorld, action);
            System.out.println(Text.centerText(skillDescription));

            System.out.println(Text.centerText(40,"1. Confirm Attack | 2. Go Back"));
            System.out.print("                                                                                Choose Option-> ");
            int confirmChoice = scanner.nextInt();
                        
        if (confirmChoice == 2) {
                 // Gees back to attack selection
                continue;
        } else if (confirmChoice == 1) {   
        
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
                    continue; // Skip the rest of the loop
                }
            }
        }
    
            displayEnemyStatus();
            displayPlayerStatus(); 
            delay();

            // Handle enemy attack if Cinderella is not invisible
            if (enemy.isAlive()) {
                if (!(player instanceof Cinderella && ((Cinderella) player).isInvisible())) {
                    enemy.attack(player);
                } else {
                    System.out.println(Text.centerText(enemy.getName() + " attempts to attack but " + player.getName() + " is invisible!"));
                }
                displayEnemyStatus();
                displayPlayerStatus(); 
                //dont let program immediately go to next round
                System.out.println(Text.centerText(40,"Press Enter"));
                scanner.nextLine();
             
            }
            //updates round counter after enemy attacks.
            roundCounter++;
    
            // Check player health status after enemy attack
            if (!player.isAlive()) {
                System.out.println(Text.centerText(player.getName() + " has been defeated..."));
                return false;
            }
    
            // Check enemy health status after player attack
            if (!enemy.isAlive()) {
                System.out.println(Text.centerText(enemy.getName() + " has been defeated!\nYou can continue your adventure!"));
                player.adjustGold(goldAmount); // Award rand gold amt for winning
                System.out.println(Text.centerBox("You received " + goldAmount + " gold for defeating " + enemy.getName() + "! "));
                System.out.print("                                                                  ->");
                scanner.nextLine();
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
        System.out.println(Text.centerText(60, 160, player.getName() + " Status: \nHealth: " + player.getHealth() +
                                           "\nMana: " + player.getMana()));


    }

    private void displayRound(){
        System.out.println(Text.centerText("Round: " + roundCounter));
    }

    private void displayEnemyStatus() {
        System.out.println(Text.centerText(60, 240, enemy.getName() + " Status: \nHealth: " + enemy.getHealth()));
    }

    //clear screen stuff
    public static void clearScreen() {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

    //delay method para di kaau overwhelming si beshiewep
    public static void delay() {
        try {
            Thread.sleep(1000); // Delay for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println("Thread was interrupted");
        }
    }

    
    
}



