
 public abstract class Character {
    protected String name;
    protected int health;
    protected int mana;
    protected int maxHealth;
    protected int maxMana;
    protected int gold = 0;
    protected int attackPower;
    protected boolean invisible;
    protected int lives = 1;
    private boolean isConfused;

    public Character() {
        this.isConfused = false; 
    }

    public boolean isConfused() {
        return isConfused;
    }

    public void setConfused(boolean confused) {
        this.isConfused = confused;
    }

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

    public void setHealth(int health) {
        this.health = Math.max(0, health); // Prevent health from going below zero
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, mana); // Prevent mana from going below zero
    }

    public void receiveDamage(int damage) {
        setHealth(health - damage);
    }

    // Restore health but don't exceed maxHealth
    public void restoreHealth(int amount) {
        if (health >= maxHealth) {
            System.out.println(Text.centerText("Health is already full.")); // No restoration needed
        } else {
            health += amount; 
            if (health > maxHealth) {
                health = maxHealth; // Cap health at maxHealth
                System.out.println(Text.centerText("Health restored to full. Current health: " + health));
            } else {
                System.out.println(Text.centerText("Health restored by " + amount + ". Current health: " + health));
            }
        }
    }

    // Use mana and reduce it
    public void useMana(int amount) {
        setMana(mana - amount);
    }

    // Check if the character is alive
    public boolean isAlive() {
        return health > 0;
    }

    // Adjust health and mana by a specified amount
    public void adjustHealth(int amount) {
        setHealth(health + amount);
    }

    public void adjustMana(int amount) {
        setMana(mana + amount); 
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

    // Increase max health and max mana
    public void increaseMaxHealth(int amount) {
        maxHealth += amount;
        health = Math.min(health, maxHealth); // Ensure current health doesn't exceed new max
    }

    public void increaseMaxMana(int amount) {
        maxMana += amount;
        mana = Math.min(mana, maxMana); // Ensure current mana doesn't exceed new max
    }

    public void gainLife() {
        lives += 1; // Increment lives by 1
    }

    public int getGold() {
        return gold;
    }
    
    public void adjustGold(int amount) {
        gold += amount;
        if (gold < 0) {
            gold = 0; // Prevent gold from going below zero
        }
    }

    public int getAttackPower() {
        return (attackPower);
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    // Setters for name, max health, max mana, and gold
    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSkillDamage(int skill){
        return 0;
    }

    private int lastSkillDamage; 


    public int getLastSkillDamage(int par) {
        return lastSkillDamage;
    }

    public void setLastSkillDamage(int damage) {
        this.lastSkillDamage = damage;
    }


}
