import java.util.Random;
import java.util.Scanner;

public class RandomEvent {

    private Random random;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public RandomEvent() {
        random = new Random(); // Initialize Random object
    }

    // Method to display a random event and apply its effects
    public void displayRandomEvent(Character player) {
        String[] events = {
            "RANDOM EVENT: You find a glowing herb in the forest.\nEating it could restore 15 health points. Do you want to eat it? ",
            "RANDOM EVENT: A mystical well offers you its waters.\nDrinking from it could restore 25 health points. Do you want to drink it? ",
            "RANDOM EVENT: You come across a hidden treasure chest!\nIt contains a stash of 30 gold coins.",
            "RANDOM EVENT: A wise old sage challenges you with a riddle.\nAnswer correctly to gain 15 mana points.",
            "RANDOM EVENT: You find a strange potion on the ground.\nDrinking it could restore 20 health points. Do you want to drink it? ",
            "RANDOM EVENT: An enchanted fairy offers a challenge.\nSolve her riddle to gain 10 mana points.",
            "RANDOM EVENT: You spot a pile of coins hidden under a tree root.\nCollect 40 gold coins.",
            "RANDOM EVENT: A magical spirit appears and poses a riddle.\nAnswering correctly restores 10 health points.",
            "RANDOM EVENT: You stumble upon an ancient artifact.\nTouching it could grant you an extra 20 health points. Do you want to touch it? "
        };

        int index = random.nextInt(events.length); // Pick a random event
        switch (index) {
            case 0 -> askItemDecision(player, events[0], 15, "health");
            case 1 -> askItemDecision(player, events[1], 25, "health");
            case 2 -> {
                player.adjustGold(30); // Gain 30 gold coins
                System.out.println(Text.centerText("RANDOM EVENT: You found a treasure chest and gained 30 gold coins!"));
            }
            case 3 -> askRiddleDecision(player, "RANDOM EVENT: What has keys but can't open locks?", "piano", 15, "mana");
            case 4 -> askItemDecision(player, events[4], 20, "health");
            case 5 -> askRiddleDecision(player, "RANDOM EVENT: I’m tall when I’m young, and I’m short when I’m old. What am I?", "candle", 10, "mana");
            case 6 -> {
                player.adjustGold(40); // Gain 40 gold coins
                System.out.println(Text.centerText("RANDOM EVENT: You found hidden coins and gained 40 gold!"));
            }
            case 7 -> askRiddleDecision(player, "RANDOM EVENT: What has to be broken before you can use it?", "egg", 10, "health");
            case 8 -> askItemDecision(player, events[8], 20, "health");
            default -> System.out.println(Text.centerText("RANDOM EVENT: Nothing eventful happens this time. Continue on your journey!"));
        }
    }
    
    private void askItemDecision(Character player, String prompt, int reward, String rewardType) {
        System.out.println(Text.centerText(prompt + " (Y/N): "));
        System.out.print("                                                                  ->");
        String decision = scanner.nextLine().trim().toLowerCase();
        if (decision.equals("y")) {
            if (rewardType.equals("health")) {
                player.restoreHealth(reward);
                System.out.println(Text.centerText("You gained " + reward + " health points!"));
            } else if (rewardType.equals("mana")) {
                player.adjustMana(reward);
                System.out.println(Text.centerText("You gained " + reward + " mana points!"));
            }
        } else {
            System.out.println(Text.centerText("You chose not to take the item and continue on your way."));
        }
    }
    
    private void askRiddleDecision(Character player, String riddle, String correctAnswer, int reward, String rewardType) {
        System.out.println(Text.centerText("Would you like to answer a riddle to gain a reward? (y/n): "));
        System.out.print("                                                                  ->");
        String decision = scanner.nextLine().trim().toLowerCase();
        if (decision.equals("y")) {
            System.out.print("                                                                  ->");
            handleRiddleEvent(player, riddle, correctAnswer, reward, rewardType);
        } else {
            System.out.println(Text.centerText("You chose not to answer the riddle and continue on your way."));
        }
    }
    
    private void handleRiddleEvent(Character player, String riddle, String correctAnswer, int reward, String rewardType) {
        System.out.println(Text.centerText(riddle));
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals(correctAnswer)) {
            if (rewardType.equals("health")) {
                player.restoreHealth(reward);
                System.out.println(Text.centerText("Correct! You gained " + reward + " health points!"));
            } else if (rewardType.equals("mana")) {
                player.adjustMana(reward);
                System.out.println(Text.centerText("Correct! You gained " + reward + " mana points!"));
            }
        } else {
            System.out.println(Text.centerText("Incorrect! You do not gain any rewards."));
        }
    }
}
