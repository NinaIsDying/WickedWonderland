
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
            scanner.nextLine();  // Wait for input to proceed
        }
    }

    @Override
    public void showMenu() {
        // Check if the player is replaying the game
        if (isReplay) {
            System.out.println(Text.centerText("Skip intro? (Y/N)"));
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
            scanner.nextLine();  // Wait for input before proceeding

            // Display Pre-Battle Narration
            randomEvent.displayPreBattleNarration("Cinderella");
            scanner.nextLine();  // Wait for input before proceeding
            
            displayDialogue(introCinderella);
            scanner.nextLine();  // Wait for input before proceeding
            displayDialogue(introCinderellaContinue);
            scanner.nextLine();  // Wait for input before proceeding
            continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Use Cinderella's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("Cinderella");
                scanner.nextLine();  // Wait for input before proceeding
                
                shop.purchaseItem(player);
                
                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event
                
                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("Cinderella");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new EnemyMinion();  // Example of an intermediate enemy
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);
            }

            if (continueAdventure) {
               
                shop.purchaseItem(player);
                
                System.out.println(Text.centerText("Now face the final challenge... Prince Henry awaits!"));
                enemy = new PrinceHenry();  // Boss fight
                continueAdventure = battleSequence(CINDERELLA_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                randomEvent.displayPostBattleNarration(currentWorld);
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText("Congratulations! You have defeated Prince Henry and completed Cinderella's story."));
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
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
            scanner.nextLine();  // Wait for input before proceeding

            displayDialogue(introAlice);  // Display Alice's intro dialogue
            scanner.nextLine(); // Wait for input before proceeding
            continueAdventure = battleSequence(Alice.ALICE_ATTACKS);  // Pass Alice's attacks

            if (continueAdventure) {
                // Display Post-Battle Narration after minion defeat
                randomEvent.displayPostBattleNarration(currentWorld);
                scanner.nextLine();  // Wait for input before proceeding

                shop.purchaseItem(player);

                randomEvent.displayRandomEvent(player);

                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("Alice");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new EnemyMinion();  // Example minion for Alice's world
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
            scanner.nextLine();  // Wait for input before proceeding

            displayDialogue(introSnowWhite);  // Assuming you have a dialogue for Snow White
            scanner.nextLine();  // Wait for input before proceeding

            continueAdventure = battleSequence(SnowWhite.SNOW_WHITE_ATTACKS);  // Use Snow White's attack options

            if (continueAdventure) {
                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("SnowWhite");
                scanner.nextLine();  // Wait for input before proceeding

                shop.purchaseItem(player);  // Allow player to purchase items

                randomEvent.displayRandomEvent(player);  // After defeating minion, trigger random event

                // Display Pre-Battle Narration
                randomEvent.displayPreBattleNarration("SnowWhite");
                scanner.nextLine();  // Wait for input before proceeding

                enemy = new EnemyMinion();  // Intermediate enemy
                continueAdventure = battleSequence(SnowWhite.SNOW_WHITE_ATTACKS);  // Use Snow White's attack options
            }

            if (continueAdventure) {
                shop.purchaseItem(player);  // Allow another purchase before boss fight

                System.out.println(Text.centerText("Now face the final challenge... The Evil Queen awaits!"));
                enemy = new EvilQueen();  // Boss fight
                continueAdventure = battleSequence(SnowWhite.SNOW_WHITE_ATTACKS);  // Boss battle
            }

            if (continueAdventure) {
                // Display Post-Battle Narration after boss fight
                randomEvent.displayPostBattleNarration(currentWorld);
                scanner.nextLine();  // Wait for input before proceeding

                System.out.println(Text.centerText("Congratulations! You have defeated the Evil Queen and completed Snow White's story."));
                System.out.println(Text.centerText("Do you want to play again?\n1. Yes\n2. No"));
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
    public boolean battleSequence(String attackOptions) {
        boolean firstLineDisplayed = false;
        roundCounter = 1;

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            roundCounter++;  // Increment the round counter each turn

            System.out.println();
            if (!firstLineDisplayed) {
                displayDialogue(battleStart);
                scanner.nextLine();  // Wait for input before proceeding
                firstLineDisplayed = true;
            }

            // Center the input box with dynamic attack options
            System.out.println(Text.centerText("CHOOSE YOUR ATTACK:\n" + attackOptions + "\nChoose your action: "));
            int action = scanner.nextInt();
            scanner.nextLine();

            if (player.getMana() <= 0 && action != 1) {
                System.out.println(Text.centerText("You don't have enough mana. You can only use basic attack!"));
                action = 1;
            }

            switch (action) {
                case 1 -> player.specialSkill1(enemy);
                case 2 -> player.specialSkill2(enemy);
                case 3 -> player.specialSkill3(enemy);
                default -> {
                    System.out.println(Text.centerText("Invalid action!"));
                    continue;
                }
            }

            displayPlayerStatus();
            displayEnemyStatus();

            if (enemy.isAlive()) {
                enemy.attack(player);
                displayPlayerStatus();
            }

            if (!player.isAlive()) {
                System.out.println(Text.centerText(player.getName() + " has been defeated..."));
                return false;
            }

            if (!enemy.isAlive()) {
                System.out.println(Text.centerText(enemy.getName() + " has been defeated!\nYou can continue your adventure!"));
                player.addGold(75); // Award 75 gold for winning
                System.out.println(Text.centerBox("You received 75 gold"));
                scanner.nextLine();
                return true;
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
        System.out.println(Text.centerText(60, "Player Status: \nHealth: " + player.getHealth() +
                                           "\nMana: " + player.getMana() + "\nRound: " + roundCounter));
    }

    private void displayEnemyStatus() {
        System.out.println(Text.centerText(60, "Enemy Status: \nHealth: " + enemy.getHealth()));
    }
}
