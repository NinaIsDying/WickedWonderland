import java.util.Random;

public class SnowWhite extends Character {
    private int attackPower = 0;
    private int maxHealth = 400; 
    private boolean damageReductionActive;
    private final int damageReductionPercentage = 20; // Damage reduction set to 20%
    private int lastSkillDamage; // Variable to store the damage of the last skill used

    public SnowWhite() {
        super("Snow White",400, 200);
        this.damageReductionActive = false; // Damage reduction starts inactive
        this.lastSkillDamage = 0; // Initialize lastSkillDamage
        this.maxHealth = health; 
        this.maxMana = mana;
    }

  
    public static final String[] snowWhiteSkills =  {
        ("Poisoned Apple Strike"),
        ("Enchanted Healing"),
        ("Forest's Aid") 
    };

    @Override
    public void restoreHealth(int amount) {
        if (health >= maxHealth) {
            System.out.println(Text.centerText("Health is already full.")); // No restoration needed
        } else {
            health += amount; 
            if (health > maxHealth) {
                health = maxHealth; // Cap health at maxHealth
                System.out.println(Text.centerText("Health restored to full. "));
            } 
        }
    }


    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public int getLastSkillDamage(int par) {
        return lastSkillDamage; // Getter for last skill damage
    }

    @Override
    public int getSkillDamage(int num) {
        switch (num) {
            case 1:  // Glass Shard Strike
                return 50 + attackPower;  // Max damage for Glass Shard Strike
            case 2:  // Enchanted Resilience
                return 60;  // Max damage for Enchanted Resilience
            case 3:  // Midnight Escape
                return 0;
            default:
                return 0;  // Invalid skill
        }
    }
    
        @Override
        public void specialSkill1(Enemy enemy) {

            
            int minDamage = 25+getAttackPower(); // Minimum damage for Skill 1
            int maxDamage = 50; // Maximum damage for Skill 1
            int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage; // Random damage generation
            useMana(0);  // Use no mana for this skill
           
            
            // Display the damage dealt
            System.out.println(Text.centerText(name + " uses Poisoned Apple Strike\n" +
                    name + " deals " + damage + " damage to " + enemy.getName() + "!"));
            
            if (damage > 45) { // Critical damage threshold
                System.out.println(Text.centerText("CRITICAL DAMAGE!"));
            }

            enemy.receiveDamage(damage);  // Deal the damage to the enemy
            setLastSkillDamage(damage);  // Store damage for display
        }
        
        @Override
        public void specialSkill2(Enemy enemy) {
            if (getMana() <= 30) {
                System.out.println(Text.centerText(name + " has insufficient mana!"));
                return;
            }
            
            int minDamage = 40; // Minimum damage for Skill 2
            int maxDamage = 60+getAttackPower(); // Maximum damage for Skill 2
            int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage; // Random damage generation
            restoreHealth(20);  // Restore health
            useMana(30);  // Deduct mana
         
            // Display the damage dealt
            System.out.println(Text.centerText(name + " uses Enchanted Healing\n" +
                    name + " deals " + damage + " damage to " + enemy.getName() + "!"));
            
            if (damage > 55) { // Critical damage threshold
                System.out.println(Text.centerText("CRITICAL DAMAGE!"));
            }

            enemy.receiveDamage(damage);  // Deal the damage to the enemy
            setLastSkillDamage(damage);  // Store damage for display
            
        }
        
        @Override
        public void specialSkill3(Enemy enemy) {
            if (getMana() <= 50) {
                System.out.println(Text.centerText(name + " has insufficient mana!"));
                return;
            }
            
            activateDamageReduction();  // Activate the damage reduction effect for this turn
            useMana(50);  // Deduct mana for this skill
            
            // Display skill use
            System.out.println(Text.centerText(name + " uses Forest's Aid\n" +
                    name + " activates damage reduction for the next turn!"));
        }
        

    public void activateDamageReduction() {
        this.damageReductionActive = true; // Set the damage reduction to active
    }

    public void deactivateDamageReduction() {
        this.damageReductionActive = false; // Set the damage reduction to inactive
    }

    public int applyDamageReduction(int damage) {
        if (damageReductionActive) {
            return damage * (100 - damageReductionPercentage) / 100; // Apply the 20% reduction
        }
        return damage; // No reduction if not active
    }

    // Call this method when taking damage
    @Override
    public void receiveDamage(int damage) {
        int finalDamage = applyDamageReduction(damage); // Apply damage reduction if active
        setHealth(getHealth() - finalDamage); // Update health after taking damage
    }

    @Override
    public boolean isAlive() {
        return health > 0;
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

    // Optionally, reset damage reduction at the end of the turn
    public void endTurn() {
        deactivateDamageReduction(); // Deactivate after the turn
    }
    @Override
    public void increaseMaxHealth(int amount) {
        maxHealth += amount;
        health = Math.min(health, maxHealth); // Ensure current health doesn't exceed new max
    }

    
}
