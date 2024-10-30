public class Dialogue {

    static String[] gameIntro = {
        wrapText("[O#n3e U[p]0n 4 t&m#]..."),
        wrapText("A fairytale world filled with hope and love-Where dreams came true, and happily ever afters were promised to all.But now...Those promises have been broken, twisted by shadows lurking just beneath the surface."),
        wrapText("The very fabric of the story has frayed... and it begins again."),
        wrapText("Tick... tock..."),
        wrapText("[You]: Why has everything changed?"),
        wrapText("How pathetic."),
        wrapText("Did you truly think there was ever a 'happy ending,' my dear?"),
        wrapText("In the world of Wicked Wonderland allies become enemies, and dreams...become nightmares."),
        wrapText("The air is heavy with dark magic. Prepare yourself, for your journey through the twisted tale begins now.Will you fight to reclaim your story... or will you fall into the dark pages of Wicked Wonderland?")
    };

    static String[] introCinderella = {
        wrapText("Darkness stretches before you, twisting what was once a place of beauty into a prison of shadows in the woods.")
        + "\n~~Please enter any key to continue~~",
    };
    
    static String[] introCinderellaContinue = {
        wrapText("An eerie call echoes through the trees, reverberating through the stillness of the forest.")
        + "\n~~Please enter any key to continue~~",
    };
    

    
    static final String[] cinderellaSkills = { 
        wrapText("Glass Shard Strike"),
        wrapText("Enchanted Resilience"),
        wrapText("Midnight Escape")
    };

    static final String[] snowWhiteSkills =  {
        wrapText("Poisoned Apple Strike"),
        wrapText("Enchanted Healing"),
        wrapText("Forest's Aid") 
    };

    static final String[] aliceSkills =  {
        wrapText("Tea Party Confusion"),
        wrapText("Wonderland Warp"),
        wrapText("Rejuvinating Sip") 
    };

    static String[] introSnowWhite = {
        wrapText("Snow White stands at the edge of the Enchanted Forest.\nThe once vibrant trees are now blackened, their twisted branches like claws reaching out for her.")
        + "\n~~Please enter any key to continue~~",
    };

        
    static final String CINDERELLA_ATTACKS = 
    wrapText("1. Glass Shard Strike-----[Mana -  0][Damage - 30]")+
    wrapText("\n2. Enchanted Resilience---[Mana - 30][Damage - 50]") +
    wrapText("\n3. Midnight Escape--------[Mana - 50][Damage -  0]");
    
    static final String SNOW_WHITE_ATTACKS = 
    wrapText("1. Poisoned Apple Strike--[Mana -  0][Damage - 30]") +
    wrapText("\n2. Enchanted Healing---[Mana - 30][Damage - 50]") +
    wrapText("\n3. Forest's Aid--------[Mana - 50][Damage -  80]");
    

    static final String ALICE_ATTACKS = 
    wrapText("1. Tea Party Confusion---[Mana - 10][Damage - 30]" +
          "\n2. Wonderland Jump--------[Mana - 15][Damage - 50]" +
          "\n3. Rejuvenating Sip-------[Mana - 50][Damage -  0]");


    static String[] introAlice = {
        wrapText("Alice finds herself in the heart of Mad Wonderland.\nThe colors around her swirl in a chaotic dance, and peculiar creatures scurry about, \nwhispering secrets.")
        + "A mischievous grin appears on her face as she grips her curiosity \ntightly, ready to embrace the madness that lies ahead."
        + "\n~~Please enter any key to continue~~",
    };

    static String[] battleStart = {
        wrapText("Prepare for battle!")
    };

    static final String chooseWorlds = 
        wrapText("C H O O S E               - Y O U R -               C H A R A C T E R")
                + ("\n--------------------------------------------------------------------\n")
                + ("1. WORLD ONE: The Shattered Palace----------------------------Cinderella\n") 
                + ("2. WORLD TWO: Mad Wonderland--------------------------------------Alice\n") +
                  ("3. WORLD THREE: Not So White----------------------------------Snow White");

                  public static final String VICTORY_TEXT_1 = 
                  wrapText("As the dark creature slowly retreats back into the shadows, Cinderella hears a strange sound behind her. Upon further observation, she finds that it is indeed a Golden Pumpkin Carriage awaiting her. Looks like not all her friends have turned against her, after all. Cinderella boards the carriage and it carries her deep into the woods.");
              
              public static final String VICTORY_TEXT_2 = 
                  wrapText("With a final, defiant flourish, Cinderella watches as the Fairy Godmother's magic dissipates like mist in the morning sun. The oppressive darkness lifts, revealing a path bathed in light. A sense of freedom floods her heart as she realizes that she has reclaimed her destiny. No longer bound by enchantments, she takes a deep breath, ready to embrace the adventures that await her. The world feels anew, full of possibilities, as she steps forward into her future with unwavering resolve.");
              
              public static final String ENTRANCE_TEXT_1 = 
                  wrapText("The air shimmers with magic and the scene shifts into a twilight glade, where beams of moonlight filter through the tree. A soft rustle breaks the silence, and a figure steps into view: the Fairy Godmother, her gown sparkling with stardust, her wand flickering like a tiny star. With a warm yet mischievous smile, she raises her wand, the air crackling with anticipation.");
              
              public static final String ENTRANCE_TEXT_2 = 
                  wrapText("Cinderella's bruised yet tired feet finally step onto the steps of the magnificent palace. At least.. that's what she thinks. The palace is covered in vines and cracks. It is almost unrecognizable, the place she once called home. Now she must face whatever lies beyond the ivy-covered palace doors.");
              
              public static final String DARK_CREATURE_ENTRANCE = 
                  wrapText("A ghastly creature emerges from the darkness, its eyes gleaming with malice... Intruder... your fate is sealed within these shadowed walls. Only despair awaits.");
              
              // Entrance dialogue for Prince Henry
              public static final String PRINCE_HENRY_ENTRANCE = 
                  wrapText("The flickering candlelight casts eerie shadows on the marbled floor as Cinderella ascends the grand staircase. Each step reverberates with the weight of her determination. At the top, she catches a glimpse of a figure - a dark silhouette that sends chills down her spine. It is Prince Henry, the man she once loved, now twisted by the curse. Cinderella knows that to save her home, she must confront the monster he has become. From the depths of the cursed palace, a familiar silhouette emerges... \"Cinderella, you should have never returned. I am no longer the prince you once knew...\" The shadows have claimed me, and now I serve their will!");
              
              // Entrance dialogue for Mad Hatter's Twisted Teacups
              static final String MAD_HATTER_ENTRANCE = 
                  wrapText("From the swirling chaos of the tea party, twisted teacups come to life... \"Welcome to the mad realm of delights! But beware, for reality bends and shatters here!\"");
              
              // Entrance dialogue for the Fairy Godmother
              static final String FAIRY_GODMOTHER_ENTRANCE = 
                  wrapText("With a wave of her hand, the air crackles with dark magic... \"You thought I was your savior, but I am your curse! Time stands still at my command!\"");
              
              // Entrance dialogue for the Cheshire Cat
              static final String CHESHIRE_CAT_ENTRANCE = 
                  wrapText("A grin appears in the shadows, followed by the Cheshire Cat materializing... \"Oh, a curious little player! Care to make a deal? But beware, the truth can be quite... elusive!\"");
              
              // Entrance dialogue for the Evil Queen
              static final String EVIL_QUEEN_ENTRANCE = 
                  wrapText("From her dark throne, the Evil Queen emerges, her presence suffocating... \"Foolish child, you dare to challenge me? I have absorbed the magic of the dwarfs! Prepare to perish!\"");
              
              // Entrance dialogue for Alice's White Rabbit
              static final String WHITE_RABBIT_ENTRANCE = 
                  wrapText("Out of the rushing blur, the White Rabbit appears, eyes frantic... \"Late, late, I'm late for a very important date! But you, dear Alice, are a mistake in my path!\"");
              
              // Entrance dialogue for Snow White (as the final boss)
              static final String SNOW_WHITE_ENTRANCE = 
                  wrapText("From the moonlit shadows, Snow White steps forward, a dark aura surrounding her... \"You thought me the innocent princess, but I am the queen now! Bow before my darkness!\"");
              
              // EXIT DIALOGUES (after battle)
              // Exit dialogue for Mad Hatter's Twisted Teacups
              static final String MAD_HATTER_EXIT = 
                  wrapText("As the twisted teacups spin away, a chaotic laugh echoes... \"Do come again for tea! Maybe next time, you won't survive!\"");
              
              // Exit dialogue for Dark Creatures
              static final String DARK_CREATURE_EXIT = 
                  wrapText("With a hiss, the dark beings retreat into the shadows... \"Remember, fear is your eternal companion... until we meet again!\"");
              
              // Exit dialogue for the Fairy Godmother
              static final String FAIRY_GODMOTHER_EXIT = 
                  wrapText("With a wave, she vanishes in a swirl of dark magic... \"The clock will strike again, and next time, you may not escape!\"");
              
              // Exit dialogue for the Cheshire Cat
              static final String CHESHIRE_CAT_EXIT = 
                  wrapText("The Cheshire Cat's grin lingers as he fades into the mist... \"You can find me at the crossroads of reality and dreams... if you dare!\"");
              
              // Exit dialogue for the Evil Queen
              static final String EVIL_QUEEN_EXIT = 
                  wrapText("The Evil Queen dissolves into shadows, her laughter echoing... \"You may have won this time, but darkness will always return!\"");
              
              // Exit dialogue for Cinderella's Prince (Prince Henry)
              static final String PRINCE_HENRY_EXIT = 
                  wrapText("As he falls back into darkness, a trace of sadness lingers in his voice... \"Cinderella... I hope you find your way back to me...\"");
              
              // Exit dialogue for Alice's White Rabbit
              static final String WHITE_RABBIT_EXIT = 
                  wrapText("The White Rabbit dashes away in a flurry... \"Time is against you, but perhaps there's still hope... if you can find it!\"");
              
              // Exit dialogue for Snow White (as the final boss)
              static final String SNOW_WHITE_EXIT = 
                  wrapText("As Snow White fades, her voice echoes with a chilling finality... \"You may have defeated me, but darkness will always find a way to reign!\"");
              

    public void displayDialogue(String[] dialogue) {
        for (String line : dialogue) {
            System.out.println(Text.centerText(line));
        }
    }

    // Method to wrap text within a specified width
    public static String wrapText(String text) {
        StringBuilder wrappedText = new StringBuilder();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() + 1 > 95) {  // can adjust this la
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

   //overloading method so we can adjsut width dynamcially
    public static String wrapText(String text, int width) {
            StringBuilder wrappedText = new StringBuilder();
            String[] words = text.split(" ");
            StringBuilder line = new StringBuilder();
    
            for (String word : words) {
                if (line.length() + word.length() + 1 > width) {  // can adjust this la
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
    

 

}
