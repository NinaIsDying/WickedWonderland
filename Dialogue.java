
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
        "Cinderella enters the Shattered Palace.\nDarkness stretches before you, twisting what was once a place of beauty into a prison of shadows."
        + "\n~~Please enter any key to continue~~",
    };
    
    static String[] introCinderellaContinue = {
        "An eerie call echoes throughout the palace, reverberating throughout the gilded walls."
        + "\n~~Please enter any key to continue~~",
    };
    

    static final String CINDERELLA_ATTACKS = 
    "1. Glass Shard Strike [Mana cost: 0] [Damage: 10]\n2. Enchanted Resilience [Mana cost: 30] [Health +20] [Damage: 20] \n3. Illusionary Escape Enchanted Resilience [Mana cost: 50] [Damage: 0]\n [Allows invisibility for one turn]";

    static String[] introSnowWhite = {
        "Snow White stands at the edge of the Enchanted Forest.\nThe once vibrant trees are now blackened, their twisted branches like claws reaching out for her."
         + "\n~~Please enter any key to continue~~",
    };
    
    static final String SNOW_WHITE_ATTACKS = 
    "1. Poisoned Apple Strike [Mana cost: 0] [Damage: 10]\n2. Enchanted Healing [Mana cost: 30] [Health +20] [Damage: 20] \n3. Forest's Aid [Mana cost: 50]";


    static String[] introAlice = {
        "Alice finds herself in the heart of Mad Wonderland.\nThe colors around her swirl in a chaotic dance, and peculiar creatures scurry about, \nwhispering secrets"
        + "A mischievous grin appears on her face as she grips her curiosity \ntightly, ready to embrace the madness that lies ahead."
        + "\n~~Please enter any key to continue~~",
    };

    static String[] battleStart = {
        "A shadowy figure appears!\nPrepare for battle!"
         + "\n~~Please enter any key to continue~~",
    };

    static String[] chooseWorlds = {
        "C H O O S E - Y O U R -  C H A R A C T E R\nWORLD ONE [EASY]: Cinderella: The Shattered Palace\nWORLD TWO: Mad Wonderland\nWORLD THREE: Snow White: Not So White"
    };

    public void displayDialogue(String[] dialogue) {
        for (String line : dialogue) {
            System.out.println(Text.centerText(line));
        }
    }

}
