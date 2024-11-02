public class SnowWhite extends Character {
    private int attackPower = 0;
    private final int maxHealth = 400; 
    private boolean damageReductionActive;
    private final int damageReductionPercentage = 20; // Damage reduction set to 20%
    private int lastSkillDamage; // Variable to store the damage of the last skill used

    public SnowWhite() {
        super("Snow White", 400, 200);
        this.damageReductionActive = false; // Damage reduction starts inactive
        this.lastSkillDamage = 0; // Initialize lastSkillDamage
    }

    public int getLastSkillDamage() {
        return lastSkillDamage; // Getter for last skill damage
    }

    public int getSkillDamage(int num) {
        switch(num) {
            case 1: 
                lastSkillDamage = 30 + attackPower; // Set lastSkillDamage when skill 1 is used
                return lastSkillDamage;
            case 2: 
                lastSkillDamage = 40 + attackPower; // Set lastSkillDamage when skill 2 is used
                return lastSkillDamage; // Increased damage for skill 2
            default: 
                return 0; 
        }
    }
    
    @Override
    public void specialSkill1(Enemy enemy) {
   
        useMana(0);
        int damage = getSkillDamage(1); // Get the damage value for skill 1
        enemy.receiveDamage(damage); // Deal damage to the enemy
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        if(getMana() <=0){
            System.out.println(Text.centerText(name + " has no more mana!"));
            return;
        }
        useMana(30);
        restoreHealth(20);
        int damage = getSkillDamage(2); // Get the damage value for skill 2
        enemy.receiveDamage(damage); // Deal damage to the enemy
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        if(getMana() <=0){
            System.out.println(Text.centerText(name + " has no more mana!"));
            return;
        }
        activateDamageReduction(); // Activate the damage reduction for this turn
        useMana(50);
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
    
}
