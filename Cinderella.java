import java.util.Random;

public class Cinderella extends Character {
    private int attackPower = 0;
    private boolean invisible;
    private int maxHealth = 400;


    public Cinderella() {
        super("Cinderella", 200, 200);
        this.invisible = false;       
    }

    public void restoreHealth(int amount) {
        int currentHealth = getHealth(); // Get the current health
        if (currentHealth >= maxHealth) {
            System.out.println(Text.centerText("Health is already full.")); // No restoration needed
        } else {
            // Increase health by the amount
            currentHealth += amount; 
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth; // Cap health at maxHealth
                System.out.println(Text.centerText("Health restored to full. Current health: " + currentHealth));
            } else {
                System.out.println(Text.centerText("Health restored by " + amount + ". Current health: " + currentHealth));
            }
            setHealth(currentHealth); // Update the character's health
        }
    }
    
    @Override
    public int getSkillDamage(int num) {
        switch (num) {
            case 1:  // Glass Shard Strike
                return 50 + attackPower;  // Max damage for Glass Shard Strike
            case 2:  // Enchanted Resilience
                return 60 + attackPower;  // Max damage for Enchanted Resilience
            case 3:  // Midnight Escape
                return 0 + attackPower;   // No damage for Midnight Escape
            default:
                return 0;  // Invalid skill
        }
    }
    
    
    @Override
    public void increaseMaxHealth(int amount) {
        maxHealth += amount;
        health = Math.min(health, maxHealth); // Ensure current health doesn't exceed new max
    }


    
    
    
    public static final String[] cinderellaSkills = { 
        "Glass Shard Strike",
        "Enchanted Resilience",
        "Midnight Escape"
    };
    @Override
    public void specialSkill1(Enemy enemy) {
        if (getMana() <= 0) {
            System.out.println(Text.centerText(name + " has insufficient mana!"));
            return;
        }
        int minDamage = 25; // Minimum damage for Skill 1
        int maxDamage = 50+getAttackPower(); // Maximum damage for Skill 1
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage; // Random damage generation
        useMana(0); // No mana cost for this skill
     
        
        // Display the damage dealt
        System.out.println(Text.centerText(name + " uses Glass Shard Strike\n" +
                name + " deals " + damage + " damage to " + enemy.getName() + "!"));
        
        if (damage > 40) { // Critical damage threshold
            System.out.println(Text.centerText("CRITICAL DAMAGE!"));
        }   
        
        enemy.receiveDamage(damage); // Deal damage to the enemy
        setLastSkillDamage(damage); // Save the damage for display
    }
    
    @Override
    public void specialSkill2(Enemy enemy) {
        if (getMana() <= 0) {
            System.out.println(Text.centerText(name + " has insufficient mana!"));
            return;
        }
        int minDamage = 45; // Minimum damage for Skill 2
        int maxDamage = 60+getAttackPower(); // Maximum damage for Skill 2
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage; // Random damage generation
        restoreHealth(20); // Heal the player
        useMana(30); // Use 30 mana for this skill
     
        
        // Display the damage dealt
        System.out.println(Text.centerText(name + " uses Enchanted Resilience\n" +
                name + " deals " + damage + " damage to " + enemy.getName() + "!"));
        
        if (damage >50) { // Critical damage threshold
            System.out.println(Text.centerText("CRITICAL DAMAGE!"));
        }

        enemy.receiveDamage(damage); // Deal damage to the enemy
        setLastSkillDamage(damage); // Save the damage for display
    }
    
    @Override
    public void specialSkill3(Enemy enemy) {
        if (getMana() <= 0) {
            System.out.println(Text.centerText(name + " has insufficient mana!"));
            return;
        }
        useMana(50); // Use 50 mana for this skill
        setInvisible(true); // Set the player as invisible (or any effect this skill has)
        
        // Display skill use
        System.out.println(Text.centerText(name + " uses Midnight Escape\n" +
                name + " becomes invisible for the next turn!"));
    }
    

    // Check if the character is alive
    
    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public boolean isInvisible() {
        return invisible;
    }

    @Override
    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    // Method to be called at the end of each turn to reset invisibility
    public void endTurn() {
        setInvisible(false);
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    
}
