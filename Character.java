
public abstract class Character {
    protected String name;
    protected int health;;
    private int maxHealth;
    private int maxMana;
    private int gold = 0;
    private int mana = 0;
    private int attackPower = 0;
    private boolean invisible;

    public Character(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.maxHealth = health; 
        this.maxMana = mana;    
    }

    

    // Abstract methods to be implemented by subclasses for character-specific skills
    public abstract void specialSkill1(Enemy enemy);
    public abstract void specialSkill2(Enemy enemy);
    public abstract void specialSkill3(Enemy enemy);

    // Getter methods for name, health, and mana
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    // Setters for health and mana (with validation)
    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth); // Ensure health does not exceed maxHealth
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, maxMana); // Ensure mana does not exceed maxMana
    }

    // Receive damage and reduce health
    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Prevent health from going below zero
        }
    }

    // Restore health but don't exceed maxHealth
    public void restoreHealth(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth; // Ensure health doesn't go over max
        }
    }

    // Use mana and reduce it
    public void useMana(int amount) {
        mana -= amount;
        if (mana < 0) {
            mana = 0; // Prevent mana from going below zero
        }
    }

    // Check if the character is alive
    public boolean isAlive() {
        return health > 0;
    }

    // Adjust health by a specified amount
    public void adjustHealth(int amount) {
        health += amount; 
        if (health < 0) {
            health = 0; // Prevent health from going below zero
        } else if (health > maxHealth) {
            health = maxHealth; // Ensure health doesn't exceed maxHealth
        }
    }

    // Adjust mana by a specified amount
    public void adjustMana(int amount) {
        mana += amount; 
        if (mana < 0) {
            mana = 0; // Prevent mana from going below zero
        } else if (mana > maxMana) {
            mana = maxMana; // Ensure mana doesn't exceed maxMana
        }
    }

    // Getter methods for max health and mana
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    // Restore full health and mana
    public void restoreFullHealth() {
        health = maxHealth;
    }

    public void restoreFullMana() {
        mana = maxMana;
    }

    // Methods to increase max health and max mana
    public void increaseMaxHealth(int amount) {
        maxHealth += amount;
        health = maxHealth; // Optional: Adjust current health to match new max
    }

    public void increaseMaxMana(int amount) {
        maxMana += amount;
        mana = maxMana; // Optional: Adjust current mana to match new max
    }

    // Implement the missing methods based on GameController's need
    public void increaseHealth(int amount) {
        adjustHealth(amount);
    }

    public void decreaseHealth(int amount) {
        adjustHealth(-amount);
    }

    public void increaseMana(int amount) {
        adjustMana(amount);
    }

    public void gainPowerfulSpell() {
        // Logic to grant a powerful spell or item
        System.out.println(Text.centerText("You gained a powerful spell!"));
    }
    
    public void heal(int amount) {
        health += amount;
    }

    public void takeDamage(int amount) {
        health -= amount;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void decreaseGold(int amount) {
        if (amount <= gold) {
            gold -= amount;
        } else {
            System.out.println("Not enough gold to complete the transaction.");
        }
    }
    
    public void addGold(int amount) {
        gold += amount;
    }

    public void gainLife() {
        lives++;
    }

    public void gainMana(int amount) {
        mana += amount;
    }

    public void missTurn() {
        System.out.println("You miss your turn.");
    }
    
    public void increaseAttack(int amount) {
        attackPower += amount;
    }


    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

}