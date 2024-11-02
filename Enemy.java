public abstract class Enemy{
    protected String name;
    protected int maxHealth;
    protected int currentHealth;
    protected int attackPower;

    public Enemy(String name, int maxHealth, int attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Initialize currentHealth to maxHealth
        this.attackPower = attackPower;
    }

    public void heal(int healAmount) {
        currentHealth = Math.min(currentHealth + healAmount, maxHealth);
    }

    public abstract void attack(Character player);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return Math.max(currentHealth, 0); // Ensure it returns 0 if health goes below
    }

    public void receiveDamage(int damage) {
        currentHealth -= damage;
        currentHealth = Math.max(currentHealth, 0); // Ensure health does not go below zero
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
