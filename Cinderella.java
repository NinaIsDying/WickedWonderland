public class Cinderella extends Character {
    private int attackPower = 0;
    private boolean invisible;
    private final int maxHealth = 400;


    public Cinderella() {
        super("Cinderella", 400, 200);
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
    

    public int getSkillDamage(int num) {
        switch(num) {
            case 1: return 30 + attackPower;
            case 2: return 50 + attackPower;
            default: return 0; 
        }
    }
    
    @Override
    public void specialSkill1(Enemy enemy) {
        useMana(0);
        enemy.receiveDamage(getSkillDamage(1));
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        if(getMana() <=0){
            System.out.println(Text.centerText(name + " has no more mana!"));
            return;
        }
        restoreHealth(20);
        useMana(20);
        enemy.receiveDamage(getSkillDamage(2));
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        if(getMana() <=0){
            System.out.println(Text.centerText(name + " has no more mana!"));
            return;
        }
        useMana(30);
        setInvisible(true);
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

    
}
