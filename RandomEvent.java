/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

import java.util.Random;
import java.util.Scanner;

public class RandomEvent {

    private Random random;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public RandomEvent() {
        random = new Random(); // Initialize Random object
    }


    // Post-Battle Narrations for Cinderella's World
    private final String[] cinderellaPostBattleNarrations = {
        wrapText("As the last echoes of battle fade away, Cinderella stands amidst the ruins of her once-glorious palace. The curse "
            + "that loomed over her kingdom dissolves into the night, leaving behind only memories. Her glass slipper, a cherished "
            + "token of her past, lies shattered at her feet. Yet in the debris of her dreams, she discovers the strength to move "
            + "forward, knowing that sometimes, to build anew, old dreams must be left behind.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The remnants of the palace crumble in the wake of her victory. Cinderella surveys the destruction around her, a "
            + "bittersweet reminder of what was lost. The battle is won, but the scars run deep. She has defeated the curse, yet "
            + "the shadows of betrayal linger, whispering in her ear. With each step away from the ruins, she embraces the "
            + "knowledge that she has emerged stronger—transformed by her struggles.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The crumbling palace fades into the distance as Cinderella walks away, her heart heavy with the weight of her choices. "
            + "The battle may be over, but the kingdom she once cherished is forever changed. With determination fueling her resolve, "
            + "she turns her back on the ashes of her past, ready to forge a new path forward, a path where she can redefine her future.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("Amidst the ruins, Cinderella catches a glimpse of her reflection in the shards of broken glass. The girl she once was "
            + "has been replaced by a fierce warrior, tempered by hardship. As the last vestiges of magic evaporate into the air, "
            + "she takes a moment to reflect on her journey. She has won, but at a cost that echoes through her soul, a cost she "
            + "will carry as she steps into the light of a new beginning.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("With one last glance at the shattered remnants of her home, Cinderella feels a mix of sadness and hope. The battle is "
            + "over, but her journey has just begun. The echoes of the past will forever linger, but she is ready to face whatever "
            + "challenges lie ahead. Armed with newfound strength, she walks into the future, determined to rebuild not just her "
            + "kingdom, but herself.")
            + "\n~~Please enter any key to continue~~",
    };



    // Post-Battle Narrations for Alice's World
    private final String[] alicePostBattleNarrations = {
        wrapText("The Queen of Hearts falls at Alice's feet, her crown rolling across the floor like a fallen star. Victory courses "
            + "through Alice's veins, but the world around her remains fractured, a haunting reminder of what has transpired. "
            + "Wonderland is still a shell of its former self, yet Alice knows that the reign of the Queen has ended—at least for now. "
            + "Taking a deep breath, she steers her gaze toward the horizon, aware that true peace may forever elude her.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The shattered mirror before Alice reflects the scars of her journey—every battle, every betrayal etched into her heart. "
            + "Though she stands victorious, the triumph feels tainted. The remnants of Wonderland’s madness linger in the corners "
            + "of her mind, a reminder that the line between victory and defeat is often blurred. She walks away from the battlefield, "
            + "knowing that the path to recovery will be fraught with challenges.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The Cheshire Cat's grin fades into obscurity as Alice leaves the chaos behind. The weight of her victory presses "
            + "down on her shoulders, a burden she cannot shake. As the colors of Wonderland bleed into one another, she vows to "
            + "rebuild what has been lost—brick by brick, moment by moment. The laughter of lost friends echoes in her heart, "
            + "guiding her toward the light.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("With the Queen defeated, Alice takes her first steps toward rebuilding her world. The shadows of the past whisper, "
            + "but she silences them with newfound determination. She recalls the faces of those who stood beside her, their spirits "
            + "carried forward in her heart. Each step she takes is a testament to her strength and resilience, a pledge to honor "
            + "the memories of her fallen friends.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("As the ruins of the Queen's castle crumble into dust, Alice feels no joy in the destruction. Each crumbling brick "
            + "serves as a reminder of the lives lost in the battle for freedom. Yet, as she surveys the remnants of her past, "
            + "she understands that victory comes with a heavy price—a burden she must carry as she seeks to rebuild what was lost.")
            + "\n~~Please enter any key to continue~~",
    };

 
    // Post-Battle Narrations for Snow White's World
    private final String[] snowWhitePostBattleNarrations = {
        wrapText("As the sun rises over the enchanted forest, Snow White stands victorious, the remnants of the Evil Queen’s magic "
            + "fading into the dawn. The curse has been lifted, and the forest breathes a sigh of relief as life returns to its "
            + "once-vibrant state. Snow White’s heart swells with gratitude for the loyal creatures who stood by her side, and she "
            + "knows that together, they can rebuild what was lost.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The darkness dissipates like morning mist, revealing the true beauty of the kingdom once more. Snow White gazes "
            + "upon the rejuvenated forest, its colors more vivid than ever. Though the scars of battle remain, she understands that "
            + "healing takes time. With hope in her heart, she takes the first step toward restoring peace and harmony in her realm.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The throne room stands empty, but Snow White feels the presence of her allies—the dwarfs, the forest creatures, "
            + "and the spirits of those who fought beside her. They have reclaimed their home, but the memory of the battle lingers. "
            + "With every heartbeat, Snow White vows to honor their sacrifices and create a kingdom where love and light will prevail "
            + "over darkness.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("With the Evil Queen defeated, Snow White walks through the enchanted forest, feeling the warmth of the sun on her "
            + "face. The flowers bloom with renewed vigor, and the songs of birds fill the air. She understands that her journey has "
            + "just begun; the road ahead will be challenging, but she is not alone. With the spirits of the forest by her side, "
            + "she knows they can face any trial that comes their way.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("As the final remnants of darkness fade into the shadows, Snow White stands resolute, ready to lead her kingdom into "
            + "a new era. The battle may be over, but the path to healing will require strength and unity. With the dawn of a new "
            + "day, she embraces her role as a leader, prepared to nurture the light and love that will guide her people. Together, "
            + "they will rise, forever changed but unbroken.")
            + "\n~~Please enter any key to continue~~",
    };

    // Method to wrap text within a specified width
    private String wrapText(String text) {
        StringBuilder wrappedText = new StringBuilder();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() + 1 > 90) { // Adjust 60 to your preferred line width
                wrappedText.append(line).append("\n");
                line = new StringBuilder();
            }
            if (line.length() > 0) {
                line.append(" ");
            }
            line.append(word);
        }
        wrappedText.append(line); // Add the last line

        return wrappedText.toString();
    }


    // Display Post-Battle Narration
    public void displayPostBattleNarration(String world) {
        String[] narrations = switch (world) {
            case "Cinderella" -> cinderellaPostBattleNarrations;
            case "Alice" -> alicePostBattleNarrations;
            case "SnowWhite" -> snowWhitePostBattleNarrations;
            default -> null;
        };

        if (narrations != null) {
            System.out.println(Text.centerText(narrations[random.nextInt(narrations.length)]));
        }
    }

    // Method to display a random event and apply its effects
    public void displayRandomEvent(Character player) {
        String[] events = {
            "RANDOM EVENT: A mysterious stranger offers you a powerful item for a price.\nDo you accept the deal? (yes/no)",
            "RANDOM EVENT: You stumble upon a magical spring.\nDrinking from it restores 20 health points.",
            "RANDOM EVENT: A sudden illusion causes you to attack yourself!\nLose 10 health points.",
            "RANDOM EVENT: You find a hidden treasure chest!\nIt contains random items or gold.",
            "RANDOM EVENT: Forest spirits grant you a blessing.\nGain 10 mana points.",
            "RANDOM EVENT: You are ambushed by a group of enemies!\nEngage in a surprise battle.",
            "RANDOM EVENT: You pick up a cursed item that drains your health over time.\nLose 5 health points each turn until\n you find a way to remove the curse.",
            "RANDOM EVENT: A fairy offers to help you in your battle.\nFor the next battle, gain a bonus to your attack power.",
            "RANDOM EVENT: A thick fog surrounds you,\ncausing you to lose 5 health points each turn until you escape.",
            "RANDOM EVENT: You lose your way and wander for a while.\nMiss a turn while trying to find your way back.",
            "RANDOM EVENT: You encounter a friendly NPC who shares valuable information.\nGain knowledge that gives you a strategic advantage.",
            "RANDOM EVENT: You encounter an enchanted mirror.\nIt tells you a secret that helps you in your next encounter.",
            "RANDOM EVENT: You discover a hidden stash of coins!\nGain 50 gold coins.",
            "RANDOM EVENT: You find an ancient artifact.\nThis grants you an extra life.",
            " A wise old sage asks you a riddle.\nAnswering correctly grants you a powerful spell or item."
        };

        int index = random.nextInt(events.length); // Pick a random event
        // Trigger specific effects for certain events
        switch (index) {
            case 0 -> // Mysterious stranger's offer
                handleDecisionEvent(player);
            case 1 -> {
                player.restoreHealth(20); // Restores 20 health points
                System.out.println(Text.centerText("You restored 20 health points!"));
            }
            case 2 -> {
                player.receiveDamage(10); // Lose 10 health points
                System.out.println(Text.centerText("You lost 10 health points!"));
            }
            case 3 -> {
                player.adjustGold(50); // Gain 50 gold coins
                System.out.println(Text.centerText("You found a treasure chest and gained 50 gold coins!"));
            }
            case 4 -> {
                player.adjustMana(10); // Gain 10 mana points (assuming a method exists)
                System.out.println(Text.centerText("You gained 10 mana points!"));
            }
            case 5 -> {
                // Handle ambush (you can add your own battle logic here)
                System.out.println(Text.centerText("You are ambushed by a group of enemies! Prepare for battle!"));
            }
            case 6 -> {
                player.receiveDamage(5); // Lose 5 health points each turn until removed
                System.out.println(Text.centerText("You picked up a cursed item! You lose 5 health points each\n turn until you find a way to remove the curse."));
            }
            case 7 -> {
                // Bonus for the next battle
                System.out.println(Text.centerText("A fairy offers to help you in your battle. You gain a bonus\n to your attack power for the next battle!"));
            }
            case 8 -> {
                player.receiveDamage(5); // Lose 5 health points each turn until escaped
                System.out.println(Text.centerText("You are surrounded by a thick fog! You lose 5 health points each turn until you escape."));
            }
            case 9 -> {
            }
            case 10 -> {
                // Gain knowledge
                System.out.println(Text.centerText("You encounter a friendly NPC who shares valuable information.\n You gain knowledge that gives you a strategic advantage!"));
            }
            case 11 -> handleRiddleEvent(player); // Riddle event
            case 12 -> {
                player.adjustGold(50); // Gain 50 gold coins
                System.out.println(Text.centerText("You discovered a hidden stash of coins! You gain 50 gold coins!"));
            }
            default -> System.out.println(Text.centerText("As you venture out into the depths, there's a gnawing in the feeling in the back of your mind.\n You must be very unlucky today.\n Venture on, and you might just find something interesting happen to you."));
        }
    }

    private void handleDecisionEvent(Character player) {
        System.out.print(Text.centerText("Do you accept the deal? (yes/no): "));
        String decision = scanner.nextLine().trim().toLowerCase();
        if (decision.equals("yes")) {
            // Logic for accepting the deal, e.g., gain an item
            System.out.println(Text.centerText("You accepted the deal and gained a powerful item!"));
        } else {
            System.out.println(Text.centerText("You declined the deal."));
        }
    }

    private void handleRiddleEvent(Character player) {
        System.out.println(Text.centerText("What has keys but can't open locks?")); // Example riddle
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("piano")) { // Check if the answer is correct
         //   player.gainPowerfulSpell(); // Grants a powerful spell or item if answered correctly
            System.out.println(Text.centerText("Correct! You gained a powerful spell."));
        } else {
            System.out.println(Text.centerText("Incorrect! You do not gain the spell."));
        }
    }
}

