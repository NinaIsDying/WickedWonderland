
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
            if(op.equalsIgnoreCase("skip") ) {
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
                int choice = -1; // Initialize choice to an invalid value
                while (true) {
                    try {
                        System.out.println(Text.centerText(40, WELCOME_TEXT));
                        System.out.print("                                                                                      ->");
                        choice = scanner.nextInt();
                        break;
                         } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid world choice."));
                        scanner.next(); // Clear the invalid input
                    }
                }
                
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

                int worldChoice = 0;
                while (true) {
                    try {
                        System.out.println(Text.centerText(chooseWorlds));
                        System.out.print("                                                                  ->");
                        worldChoice = scanner.nextInt();
                        break;
                         } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid world choice."));
                        scanner.next(); // Clear the invalid input
                    }
                }
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
            enemy = new JacAndGus();  // Fight a minion first
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
                System.out.println(Text.centerBox(CINDERELLA_VICTORY_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                shop.purchaseItem(player);     
                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event
     

                enemy = new FairyGodMother();
              
                System.out.println(Text.centerBox(CINDERELLA_ENTRANCE_TEXT_1));
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
              
                System.out.println(Text.centerBox(CINDERELLA_VICTORY_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                shop.purchaseItem(player);
             
                System.out.println(Text.centerBox(CINDERELLA_ENTRANCE_TEXT_2));
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

                System.out.println(Text.centerText(120, CINDERELLA_ENDING));
                System.out.println(Text.centerBox("You've completed Cinderella's story and broke the curse!\n"));
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
                
                while (!validInput) {
                    try {
                        System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
                
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
                
                
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    System.exit(0);
                }
            } else {
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
                
                while (!validInput) {
                    try {
                        System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
                
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
                
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
            enemy = new TwistedTeacups();  // Initial enemy for Alice's world
            System.out.println(Text.centerBox("Entering Alice: Mad Wonderland..."));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            // Introduction Dialogue for Alice's Story
            displayDialogue(introAlice);
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding

            displayDialogue(introAliceContinue);

            System.out.println(Text.centerText(40,"Do you want to drink from the teacups?\n[Yes /  No]"));
            System.out.print("                                                                  ->");
            scanner.nextLine();

            // Regardless of the choice, the teacups turn sentient and attack
            System.out.println(Text.centerText("The teacups become sentient and attack!"));

            System.out.println(Text.centerBox(TWISTED_TEACUPS_ENTRANCE));
            System.out.print("                                                                  ->");
            scanner.nextLine();
            continueAdventure = battleSequence(ALICE_ATTACKS);  // Use Alice's attack options

            if (continueAdventure) {
                // Post-Battle Narration for Second Fight
                System.out.println(Text.centerBox(TWISTED_TEACUPS_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                System.out.println(Text.centerBox(ALICE_VICTORY_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                shop.purchaseItem(player);     
                randomEvent.displayRandomEvent(player);  // After defeating Card Soldier, trigger random event

                // Battle with the Cheshire Cat
                enemy = new MadHatter();
                
                System.out.println(Text.centerBox(ALICE_ENTRANCE_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                System.out.println(Text.centerBox(MAD_HATTER_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                continueAdventure = battleSequence(ALICE_ATTACKS);

            }

            if (continueAdventure) {
                // Pre-Boss Narration
                System.out.println(Text.centerBox(MAD_HATTER_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                System.out.println(Text.centerBox(ALICE_VICTORY_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                shop.purchaseItem(player);

                // Alice's Final Battle with the Queen of Hearts
                
                System.out.println(Text.centerBox(ALICE_ENTRANCE_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                System.out.println(Text.centerBox(WHITE_RABBIT_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();

                System.out.println(Text.centerBox("Now face the final challenge... The White Rabbit awaits!"));
                enemy = new WhiteRabbit();  // Boss fight for Alice's world

                continueAdventure = battleSequence(ALICE_ATTACKS);  // Boss battle with Alice's skills
            }

            if (continueAdventure) {
                // Post-Battle Narration for Alice's Story Completion
                System.out.println(Text.centerBox(WHITE_RABBIT_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();


                System.out.println(Text.centerText(120, ALICE_ENDING));
                System.out.println(Text.centerBox("You've completed Alice's story and freed Wonderland!\n"));
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
                
                while (!validInput) {
                    try {
                        System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
                
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
                
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerText("Thank you for playing!"));
                    System.exit(0);
                }
            } else {
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
                
                while (!validInput) {
                    try {
                        System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
                
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
                
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


    
    @Override
    public void worldThree() {
        boolean continueAdventure = true;
    
        while (continueAdventure) {
            roundCounter = 0;
            enemy = new SevenDwarves();  // Initial enemy for Snow White's world
            System.out.println(Text.centerBox("Entering Snow White: Not So White..."));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
    
            // Introduction Dialogue for Snow White's Story
            System.out.println(Text.centerBox(INTRO));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
    
            System.out.println(Text.centerBox(INTRO_CONTINUE));
            System.out.print("                                                                  ->");
            scanner.nextLine();  // Wait for input before proceeding
    
            System.out.println(Text.centerBox(SEVEN_DWARVES_ENTRANCE));

            continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);  // Use Snow White's attack options
    
            if (continueAdventure) {
                // Post-Battle Narration for First Fight
                System.out.println(Text.centerBox(SEVEN_DWARVES_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox(SNOW_WHITE_VICTORY_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                shop.purchaseItem(player);
                randomEvent.displayRandomEvent(player);  // After defeating Seven Dwarves, trigger random event
    
                enemy = new MagicMirror();
    
                System.out.println(Text.centerBox(SNOW_WHITE_ENTRANCE_TEXT_1));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox(MAGIC_MIRROR_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);
            }
    
            if (continueAdventure) {
                // Pre-Boss Narration
                System.out.println(Text.centerBox(MAGIC_MIRROR_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox(SNOW_WHITE_VICTORY_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                shop.purchaseItem(player);
    
                // Snow White final battle with dark Snow White
                System.out.println(Text.centerBox(SNOW_WHITE_ENTRANCE_TEXT_2));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox(DARK_SNOW_WHITE_ENTRANCE));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox("Now face the final challenge... ----- awaits!"));
                enemy = new DarkSnowWhite();
    
                continueAdventure = battleSequence(SNOW_WHITE_ATTACKS);
            }
    
            if (continueAdventure) {
                System.out.println(Text.centerBox(DARK_SNOW_WHITE_EXIT));
                System.out.print("                                                                  ->");
                scanner.nextLine();
    
                System.out.println(Text.centerBox(SNOW_WHITE_ENDING));
                System.out.println(Text.centerBox("You've completed Snow White's story and broke the dark curse!\n"));
                System.out.print("                                                                  ->");
                scanner.nextLine();  // Wait for input before proceeding
    
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
    
                while (!validInput) {
                    try {
                        System.out.println(Text.centerBox("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
    
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
    
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerBox("Thank you for playing!"));
                    System.exit(0);
                }
            } else {
                int choice = -1; // Initialize choice to an invalid value
                boolean validInput = false; // Flag to track valid input
    
                while (!validInput) {
                    try {
                        System.out.println(Text.centerBox("Do you want to play again?\n1. Yes\n2. No"));
                        System.out.print("                                                                  ->");
                        choice = scanner.nextInt();
    
                        if (choice == 1 || choice == 2) { // Check if choice is valid (1 or 2)
                            validInput = true; // Exit loop if input is valid
                        } else {
                            System.out.println(Text.centerText("Invalid input! Please enter 1 or 2.")); // Prompt for valid input
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(Text.centerText("Invalid input! Please enter a valid integer.")); // Prompt for valid input
                        scanner.next(); // Clear the invalid input
                    }
                }
    
                if (choice == 1) {
                    isReplay = true;
                    showMenu();  // Return to main menu
                } else {
                    System.out.println(Text.centerBox("Thank you for playing!"));
                    System.exit(0);
                }
            }
        }
    }
    

    
    //randomizer for random gold amount after every battle
    public static int generateRandomGold(int min, int max) {
        return random.nextInt(max - min + 1) + min; 
    }

    // Adjusts gold amount based on specific enemy min-max range
    private int getEnemyGoldMin() {
        if (enemy instanceof JacAndGus || enemy instanceof TwistedTeacups || enemy instanceof SevenDwarves) {
            return 50;
        } else if (enemy instanceof FairyGodMother || enemy instanceof MagicMirror || enemy instanceof MadHatter) {
            return 100;
        } else if (enemy instanceof PrinceHenry || enemy instanceof DarkSnowWhite || enemy instanceof WhiteRabbit) {
            return 150;
        } else {
            // Default value if enemy type is not recognized
            return 50;
        }
    }
    
    private int getEnemyGoldMax() {
        if (enemy instanceof JacAndGus || enemy instanceof TwistedTeacups || enemy instanceof SevenDwarves) {
            return 100;
        } else if (enemy instanceof FairyGodMother || enemy instanceof MagicMirror || enemy instanceof MadHatter) {
            return 150;
        } else if (enemy instanceof PrinceHenry || enemy instanceof DarkSnowWhite || enemy instanceof WhiteRabbit) {
            return 200;
        } else {
            // Default value if enemy type is not recognized
            return 150;
        }
    }


    // Battle sequence method with customizable attack options
    @Override
    public boolean battleSequence(String attackOptions) {   
 
        boolean firstLineDisplayed = false;
        int goldAmount = generateRandomGold(getEnemyGoldMin(), getEnemyGoldMax());
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
            int action = -1; // Initialize action to an invalid value
            boolean validInput = false; // Flag to track valid input
            
            while (!validInput) {
                try {
                    System.out.print("                                                                      Choose Attack->");
                    action = scanner.nextInt();
            
                    // Check if action is either 1, 2, or 3
                    if (action >= 1 && action <= 3) {
                        validInput = true; // Exit loop if input is valid
                    } else {
                        System.out.println(Text.centerText("Invalid input! Please enter 1, 2, or 3.")); // Prompt for valid input
                    }
                } catch (InputMismatchException e) {
                    System.out.println(Text.centerText("Invalid input! Please enter a valid integer (1, 2, or 3).")); // Prompt for valid input
                    scanner.next(); // Clear the invalid input
                }
            }
            
            System.err.println();
                
            if (player.getMana() <= 0 && action != 1) {
                System.out.println(Text.centerText("You don't have enough mana. You can only use first skill!"));
                action = 1;
            }

            // Show the skill description
            String skillDescription = SkillBoxes.getSkillDescription(currentWorld, action);
            System.out.println(Text.centerText(skillDescription));

       
            int confirmChoice = 0;
            validInput = false;

            while (!validInput) {
                try {
                    System.out.println(Text.centerText(40, "1. Confirm Attack | 2. Go Back"));
                    System.out.print("                                                                                Choose Option-> ");
                    confirmChoice = scanner.nextInt();
                    
                    if (confirmChoice == 1 || confirmChoice == 2) {
                        validInput = true; // Exit loop if input is valid
                    } else {
                        System.out.println(Text.centerText("Invalid input! Please enter 1 or 2."));
                    }
                } catch (InputMismatchException e) {
                    System.out.println(Text.centerText("Invalid input! Please enter 1 or 2."));
                    scanner.next(); // Clear the invalid input
                }
            }
            
            
            if (confirmChoice == 2) {
                // Goes back to attack selection
                continue;
            } else if (confirmChoice == 1) {
                switch (action) {
                    case 1 -> {
                        if (player instanceof Alice) {
                            player.specialSkill1(enemy);  // Apply Alice's skill
                            usedInvisibilityLastTurn = false;  // Reset invisibility status
                        } else if (player instanceof SnowWhite) {
                            player.specialSkill1(enemy);  // Apply Snow White's skill
                            usedInvisibilityLastTurn = false;
                        } else { // Cinderella
                            player.specialSkill1(enemy);  // Apply Cinderella's skill
                            usedInvisibilityLastTurn = false;
                        }
                    }
                    case 2 -> {
                        if (player instanceof Alice) {
                            player.specialSkill2(enemy);  // Apply Alice's skill
                            usedInvisibilityLastTurn = true;  // Alice goes invisible after using Skill 2
                        } else if (player instanceof SnowWhite) {
                            player.specialSkill2(enemy);  // Apply Snow White's skill
                            usedInvisibilityLastTurn = false;  // Snow White doesn't go invisible after Skill 2
                        } else { // Cinderella
                            player.specialSkill2(enemy);  // Apply Cinderella's skill
                            usedInvisibilityLastTurn = false;  // Cinderella doesn't go invisible after Skill 2
                        }
                    }
                    case 3 -> {
                        if (player instanceof Alice) {
                            player.specialSkill3(enemy);  // Apply Alice's skill
                            usedInvisibilityLastTurn = false;
                        } else if (player instanceof SnowWhite) {
                            player.specialSkill3(enemy);  // Apply Snow White's skill
                            usedInvisibilityLastTurn = false;
                        } else { // Cinderella
                            player.specialSkill3(enemy);  // Apply Cinderella's skill
                            usedInvisibilityLastTurn = true;  // Cinderella gains invulnerability for the next turn
                        }
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
                if(!player.isInvisible()){
                System.out.println(Text.centerText(40,"Press Enter"));
                scanner.nextLine();
                }
             
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
                player.adjustGold(goldAmount); // Award random gold amount for winning
                System.out.println(Text.centerBox("You received " + goldAmount + " gold for defeating " + enemy.getName() + "! "));
                player.setAttackPower(player.getAttackPower() + 5); // Increase base damage by 10
                System.out.println(Text.centerText("An billowing breeze wafts through the air. It fills you with encouragement.\nYour base attack power has increased by 5!"));
                System.out.print("                                                                  ->");
                scanner.nextLine();
                scanner.nextLine();

                return true;
            }

    
            // At the end of the round, reset invisibility
            if (player instanceof Cinderella) {
                if (usedInvisibilityLastTurn) {
                    System.out.println(Text.centerText(player.getName() + "'s invisibility wore off..."));
                    System.out.println(Text.centerText(40,"Press Enter"));
                    scanner.nextLine();
                }
                ((Cinderella) player).endTurn(); // Reset invisibility status
            }

            if (player instanceof Alice) {
                if (usedInvisibilityLastTurn) {
                    System.out.println(Text.centerText(player.getName() + " lands on the ground. "));
                    System.out.println(Text.centerText(40,"Press Enter"));
                    scanner.nextLine();
                }
                ((Alice) player).endTurn(); // Reset invisibility status
            }

            if (player instanceof SnowWhite) {
                if (usedInvisibilityLastTurn) {
                    System.out.println(Text.centerText(player.getName() + "'s shield wore off..."));
                    System.out.println(Text.centerText(40,"Press Enter"));
                    scanner.nextLine();
                }
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
        System.out.println(Text.centerText(60, 240, enemy.getName() + " Status: \nHealth: " + enemy.getHealth() + "\nMana: " + enemy.getMana()));
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



