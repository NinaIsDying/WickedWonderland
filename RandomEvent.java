
import java.util.Random;
import java.util.Scanner;

public class RandomEvent {

    private Random random;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public RandomEvent() {
        random = new Random(); // Initialize Random object
    }

    // Pre-Battle Narrations for Cinderella's World
    private final String[] cinderellaPreBattleNarrations = {
        wrapText("The grand ballroom, once filled with laughter and music, is now a silent graveyard of shattered dreams. "
            + "Each step Cinderella takes echoes against the crumbling walls, the crunch of glass beneath her slipper a "
            + "painful reminder of the life she left behind. The ghost of the ball whispers in the distance, a haunting melody "
            + "that reminds her of happier times. As she ventures deeper, shadows of doubt creep into her heart, but she steels "
            + "herself; she must confront the darkness that has consumed her world.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("As Cinderella walks through the decaying halls, memories swirl around her like the dust in the air. The laughter "
            + "of her step-sisters fills the empty space, a mocking reminder of her past. This palace, once a symbol of her "
            + "dreams, now stands as a monument to her pain. But Cinderella is no longer the naive girl confined to servitude; "
            + "she is a warrior, prepared to reclaim her throne. Every step forward strengthens her resolve, igniting a fire "
            + "within her heart.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The air grows thick with tension as Cinderella approaches the throne room, her heart pounding with every step. "
            + "The palace, once filled with warmth and joy, now stands as a decaying ruin. Her grip tightens around her wand, "
            + "its warmth a reminder of the magic she possesses. Somewhere deep within the palace, the remnants of her prince "
            + "linger, but she is determined to face him, to break the chains of darkness that bind them.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("Pausing at the entrance to the ballroom, Cinderella feels the weight of her past wash over her. The glass slipper, "
            + "glowing faintly in the dim light, serves as a reminder of the love and hope that once defined her life. But today, "
            + "it is a symbol of the battle she must face. With a deep breath, she prepares to step into the darkness, knowing "
            + "that there is no turning back only the fight ahead.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The flickering candlelight casts eerie shadows on the marbled floor as Cinderella ascends the grand staircase. "
            + "Each step reverberates with the weight of her determination. At the top, she catches a glimpse of a figure a dark "
            + "silhouette that sends chills down her spine. It is Prince Henry, the man she once loved, now twisted by the curse "
            + "that has engulfed her kingdom. Cinderella knows that to save her home, she must confront the monster he has become.")
            + "\n~~Please enter any key to continue~~",
    };

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

    // Pre-Battle Narrations for Alice's World
    private final String[] alicePreBattleNarrations = {
        wrapText("The once whimsical Wonderland has morphed into a twisted nightmare, an unsettling reflection of Alice's memories. "
            + "As she stands at the entrance, vibrant flowers wither in despair, and the sky bleeds a haunting red. The Cheshire "
            + "Cat's grin, once playful, now harbors sinister secrets, a taunting reminder of the dangers that await her. With her "
            + "heart racing, Alice grips her blade tightly, knowing that trust is a luxury she can no longer afford.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("Peering down the rabbit hole, Alice feels a pang of nostalgia. The allure of curiosity has faded, replaced by an "
            + "ominous sense of foreboding. As she steps forward, the world shifts beneath her feet, threatening to swallow her "
            + "whole. Memories of her innocence flicker in her mind, yet she understands that Wonderland has changed irreversibly, "
            + "just as she has. The Queen of Hearts awaits, her reign of terror echoing through the chaotic landscape.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The twisted trees of Wonderland stretch out before Alice, their branches clawing at the air like hungry beasts. She "
            + "feels the weight of the forest's shadows pressing against her, reminding her of the perils that lurk in every corner. "
            + "The White Rabbit scurries past her, eyes glazed and lost, a prisoner of the madness that now grips this world. "
            + "Despite the foreboding aura, Alice presses onward, her determination burning bright against the encroaching chaos.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("Standing on the shifting checkerboard path, Alice feels the ground shift beneath her feet, pulling her in different "
            + "directions. The castle of the Red Queen looms in the distance, a dark fortress that symbolizes the madness reigning "
            + "over Wonderland. Tightening her grip on her sword, she prepares to face whatever awaits her within those walls. "
            + "The air is thick with anticipation, and she knows that her past experiences will be put to the test.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The atmosphere is electric with tension as Alice approaches the forest, her senses heightened by the whispers of danger. "
            + "The Mad Hatter's voice echoes in her mind, a twisted invitation to a deadly tea party. She walks forward, every step "
            + "a reminder of the trials she has faced before. This time, however, she is no longer the curious girl who fell into "
            + "madness—she is a warrior, ready to conquer the chaos.")
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

    // Pre-Battle Narrations for Snow White's World
    private final String[] snowWhitePreBattleNarrations = {
        wrapText("The once pristine forest now lies in ruins, a shadow of its former glory. As Snow White wanders through the "
            + "overgrown paths, the whispers of the woodland creatures echo in her ears—a warning of the darkness that has seeped "
            + "into every corner of her world. The Evil Queen's power looms large, a palpable threat that hangs over her like a "
            + "storm cloud. With every step, she prepares to confront the shadows of her past.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("Amidst the chaos of her kingdom, Snow White stands alone, the weight of her crown heavy upon her brow. The forest, "
            + "once vibrant with life, now echoes with the chilling silence of despair. The Evil Queen's curse spreads like a contagion, "
            + "twisting the hearts of those she once trusted. But Snow White, with the heart of a warrior, will not allow fear to "
            + "dictate her fate. She must gather her courage and face the darkness head-on.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The sun sets behind the twisted trees as Snow White ventures deeper into the cursed woods. Shadows dance at the "
            + "edges of her vision, a reminder that danger lurks around every corner. Her heart beats fiercely in her chest, yet "
            + "she knows she must press on. The fate of her kingdom rests upon her shoulders, and she cannot afford to falter. "
            + "With each step, she steels her resolve, determined to reclaim her rightful place.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("As the moon rises high in the night sky, Snow White stands before the entrance to the Evil Queen's lair, a dark "
            + "fortress shrouded in shadows. The air is thick with the scent of magic and malevolence. She takes a moment to breathe, "
            + "summoning the strength within her. This is not just a battle for her kingdom; it is a battle for her very soul. "
            + "With unwavering determination, she prepares to face the queen and break the curse that binds her.")
            + "\n~~Please enter any key to continue~~",
        
        wrapText("The chilling wind whispers through the trees as Snow White approaches the clearing, where the Queen's dark magic "
            + "converges. She can feel the weight of countless eyes upon her—the woodland creatures who have witnessed her journey. "
            + "Drawing upon their strength, she vows to protect her home, to restore the light that has been consumed by darkness. "
            + "With each heartbeat, she feels the fire of determination igniting within her.")
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

    // Display Pre-Battle Narration
    public void displayPreBattleNarration(String world) {
        String[] narrations = switch (world) {
            case "Cinderella" -> cinderellaPreBattleNarrations;
            case "Alice" -> alicePreBattleNarrations;
            case "SnowWhite" -> snowWhitePreBattleNarrations;
            default -> null;
        };

        if (narrations != null) {
            System.out.println(Text.centerText(narrations[random.nextInt(narrations.length)]));
        }
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
            "RANDOM EVENT: A wise old sage asks you a riddle.\nAnswering correctly grants you a powerful spell or item."
        };

        int index = random.nextInt(events.length); // Pick a random event
        System.out.println(Text.centerText("RANDOM EVENT: " + events[index]));

        // Trigger specific effects for certain events
        switch (index) {
            case 0 -> // Mysterious stranger's offer
                handleDecisionEvent(player);
            case 1 -> {
                player.heal(20); // Restores 20 health points
                System.out.println(Text.centerText("You restored 20 health points!"));
            }
            case 2 -> {
                player.takeDamage(10); // Lose 10 health points
                System.out.println(Text.centerText("You lost 10 health points!"));
            }
            case 3 -> {
                player.addGold(50); // Gain 50 gold coins
                System.out.println(Text.centerText("You found a treasure chest and gained 50 gold coins!"));
            }
            case 4 -> {
                player.gainMana(10); // Gain 10 mana points (assuming a method exists)
                System.out.println("You gained 10 mana points!");
            }
            case 5 -> {
                // Handle ambush (you can add your own battle logic here)
                System.out.println(Text.centerText("You are ambushed by a group of enemies! Prepare for battle!"));
            }
            case 6 -> {
                player.takeDamage(5); // Lose 5 health points each turn until removed
                System.out.println(Text.centerText("You picked up a cursed item! You lose 5 health points each\n turn until you find a way to remove the curse."));
            }
            case 7 -> {
                // Bonus for the next battle
                System.out.println(Text.centerText("A fairy offers to help you in your battle. You gain a bonus\n to your attack power for the next battle!"));
            }
            case 8 -> {
                player.takeDamage(5); // Lose 5 health points each turn until escaped
                System.out.println(Text.centerText("You are surrounded by a thick fog! You lose 5 health points each turn until you escape."));
            }
            case 9 -> {
                // Miss a turn logic
                player.missTurn();
                System.out.println(Text.centerText("You lose your way and wander for a while. You miss a turn while trying to find your way back."));
            }
            case 10 -> {
                // Gain knowledge
                System.out.println(Text.centerText("You encounter a friendly NPC who shares valuable information.\n You gain knowledge that gives you a strategic advantage!"));
            }
            case 11 -> handleRiddleEvent(player); // Riddle event
            case 12 -> {
                player.addGold(50); // Gain 50 gold coins
                System.out.println(Text.centerText("You discovered a hidden stash of coins! You gain 50 gold coins!"));
            }
            case 13 -> {
                player.gainLife(); // Grant an extra life
                System.out.println(Text.centerText("You found an ancient artifact! You gain an extra life!"));
            }
            default -> System.out.println(Text.centerText("No specific effects triggered for this event."));
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
            player.gainPowerfulSpell(); // Grants a powerful spell or item if answered correctly
            System.out.println(Text.centerText("Correct! You gained a powerful spell."));
        } else {
            System.out.println(Text.centerText("Incorrect! You do not gain the spell."));
        }
    }
}
