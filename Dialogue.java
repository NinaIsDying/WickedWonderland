/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

public class Dialogue {

    static String[] gameIntro = {
        "[O#n3e U[p]0n 4 t&m#]...",
        "A fairytale world filled with hope and love-\nWhere dreams came true, and happily ever afters were promised to all. But now...\nThose promises have been broken, twisted by shadows lurking just beneath the surface.",
        "The very fabric of the story has frayed... and it begins again.",
        "Tick... tock...",
        "[You]: Why has everything changed?",
        "How pathetic.",
        "Did you truly think there was ever a 'happy ending,' my dear?",
        "In the world of Wicked Wonderland allies become enemies, and dreams...become nightmares.",
        "The air is heavy with dark magic. \nPrepare yourself, for your journey through the twisted tale begins now. \nWill you fight to reclaim your story... or will you fall into the dark pages of Wicked Wonderland?"
    };

    static String[] introCinderella = {
        "Darkness stretches before you, twisting what was once a place of beauty into a prison of shadows."
        + "\n~~Please enter any key to continue~~",
    };
    
    static String[] introCinderellaContinue = {
        "An eerie call echoes throughout the palace, reverberating throughout the gilded walls."
        + "\n~~Please enter any key to continue~~",
    };
    

    static final String CINDERELLA_ATTACKS = 
    "1. Glass Shard Strike [Mana cost: 0] [Damage: 10]\n2. Enchanted Resilience [Mana cost: 30] [Health +20] [Damage: 20] \n3. Illusionary Escape Enchanted Resilience [Mana cost: 50] [Damage: 0]\n [Allows invisibility for one turn]";
    static final String cinderellaSkills[] = { 
        "Glass Shard Strike",
        "Enchanted Resilience",
        "llusionary Escape"
        };
       
   
    static String[] introSnowWhite = {
        "Snow White stands at the edge of the Enchanted Forest.\nThe once vibrant trees are now blackened, their twisted branches like claws reaching out for her."
         + "\n~~Please enter any key to continue~~",
    };
    
    static final String SNOW_WHITE_ATTACKS = 
    "1. Poisoned Apple Strike [Mana cost: 0] [Damage: 10]\n2. Enchanted Healing [Mana cost: 30] [Health +20] [Damage: 20] \n3. Forest's Aid [Mana cost: 50]";
    static final String snowWhiteSkills[] =  {
    "Poisoned Apple Strike",
    "Enchanted Healing",
    "Forest's Aid" 
    };


    static String[] introAlice = {
        "Alice finds herself in the heart of Mad Wonderland.\nThe colors around her swirl in a chaotic dance, and peculiar creatures scurry about, \nwhispering secrets"
        + "A mischievous grin appears on her face as she grips her curiosity \ntightly, ready to embrace the madness that lies ahead."
        + "\n~~Please enter any key to continue~~",
    };

    static String[] battleStart = {
        "Prepare for battle!"
    };

    static String[] chooseWorlds = {
        "C H O O S E - Y O U R -  C H A R A C T E R\nWORLD ONE  Cinderella: The Shattered Palace\nWORLD TWO: Alice: Mad Wonderland\nWORLD THREE: Snow White: Not So White"
    };



    // Entrance dialogue for The Marionette Knight
    static final String MARIONETTE_KNIGHT_ENTRANCE = 
    "From the shadows, a figure lurches forward, strings glistening with dark magic...\n" +
    "\"You dare to step into the cursed halls? The prince's darkness binds me, and I cannot let you pass.\"";

    // Entrance dialogue for a Dark Creature
    static final String DARK_CREATURE_ENTRANCE = 
    "A ghastly creature emerges from the darkness, its eyes gleaming with malice...\n" +
    "\"Intruder... your fate is sealed within these shadowed walls. Only despair awaits.\"";

    static final String PRINCE_HENRY_ENTRANCE = 
    "From the depths of the cursed palace, a familiar silhouette emerges...\n" +
    "\"Cinderella, you should have never returned. I am no longer the prince you once knew...\"\n" +
    "\"The shadows have claimed me, and now I serve their will!\"";

    // Entrance dialogue for Mad Hatter's Twisted Teacups
    static final String MAD_HATTER_ENTRANCE = 
    "From the swirling chaos of the tea party, twisted teacups come to life...\n" +
    "\"Welcome to the mad realm of delights! But beware, for reality bends and shatters here!\"";


    // Entrance dialogue for the Fairy Godmother
    static final String FAIRY_GODMOTHER_ENTRANCE = 
    "With a wave of her hand, the air crackles with dark magic...\n" +
    "\"You thought I was your savior, but I am your curse! Time stands still at my command!\"";

    // Entrance dialogue for the Cheshire Cat
    static final String CHESHIRE_CAT_ENTRANCE = 
    "A grin appears in the shadows, followed by the Cheshire Cat materializing...\n" +
    "\"Oh, a curious little player! Care to make a deal? But beware, the truth can be quite... elusive!\"";

    // Entrance dialogue for the Evil Queen
    static final String EVIL_QUEEN_ENTRANCE = 
    "From her dark throne, the Evil Queen emerges, her presence suffocating...\n" +
    "\"Foolish child, you dare to challenge me? I have absorbed the magic of the dwarfs! Prepare to perish!\"";


    // Entrance dialogue for Alice's White Rabbit
    static final String WHITE_RABBIT_ENTRANCE = 
    "Out of the rushing blur, the White Rabbit appears, eyes frantic...\n" +
    "\"Late, late, I'm late for a very important date! But you, dear Alice, are a mistake in my path!\"";

    // Entrance dialogue for Snow White (as the final boss)
    static final String SNOW_WHITE_ENTRANCE = 
    "From the moonlit shadows, Snow White steps forward, a dark aura surrounding her...\n" +
    "\"You thought me the innocent princess, but I am the queen now! Bow before my darkness!\"";

    //EXIT DIALOGUES (after battle)
    // Exit dialogue for Mad Hatter's Twisted Teacups
        static final String MAD_HATTER_EXIT = 
        "As the twisted teacups spin away, a chaotic laugh echoes...\n" +
        "\"Do come again for tea! Maybe next time, you won't survive!\"";

        // Exit dialogue for Dark Creatures
        static final String DARK_CREATURE_EXIT = 
        "With a hiss, the dark beings retreat into the shadows...\n" +
        "\"Remember, fear is your eternal companion... until we meet again!\"";

        // Exit dialogue for Marionette Knight
        static final String MARIONETTE_KNIGHT_EXIT = 
        "With a final creaking of its strings, the Marionette Knight collapses...\n" +
        "\"You may have severed my strings, but remember, darkness can always be rethreaded. The shadows will find a way!\"";


        // Exit dialogue for the Fairy Godmother
        static final String FAIRY_GODMOTHER_EXIT = 
        "With a wave, she vanishes in a swirl of dark magic...\n" +
        "\"The clock will strike again, and next time, you may not escape!\"";

        // Exit dialogue for the Cheshire Cat
        static final String CHESHIRE_CAT_EXIT = 
        "The Cheshire Cat's grin lingers as he fades into the mist...\n" +
        "\"You can find me at the crossroads of reality and dreams... if you dare!\"";

        // Exit dialogue for the Evil Queen
        static final String EVIL_QUEEN_EXIT = 
        "The Evil Queen dissolves into shadows, her laughter echoing...\n" +
        "\"You may have won this time, but darkness will always return!\"";

        // Exit dialogue for Cinderella's Prince (Prince Henry)
        static final String PRINCE_HENRY_EXIT = 
        "As he falls back into darkness, a trace of sadness lingers in his voice...\n" +
        "\"Cinderella... I hope you find your way back to me...\"";

        // Exit dialogue for Alice's White Rabbit
        static final String WHITE_RABBIT_EXIT = 
        "The White Rabbit dashes away in a flurry...\n" +
        "\"Time is against you, but perhaps there's still hope... if you can find it!\"";

        // Exit dialogue for Snow White (as the final boss)
        static final String SNOW_WHITE_EXIT = 
        "As Snow White fades, her voice echoes with a chilling finality...\n" +
        "\"You may have defeated me, but darkness will always find a way to reign!\"";



    public void displayDialogue(String[] dialogue) {
        for (String line : dialogue) {
            System.out.println(Text.centerText(line));
        }
    }

}

