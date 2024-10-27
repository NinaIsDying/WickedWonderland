public class Cinderella extends Character {
    private int attackPower = 0;
    private boolean invisible;
    private int health = 200;
    private final int maxHealth = 200;

    public Cinderella() {
        super("Cinderella", 200, 100);
        this.invisible = false;        
    }

    public void restoreHealth(int amount) {
        if (health >= maxHealth) {
            System.out.println("Health is already full.");
        } else {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth; // Cap health at maxHealth
            }
            System.out.println("Health restored by " + amount + ". Current health: " + health);
        }
    }

    public int getSkillDamage(int num) {
        switch(num) {
            case 1: return 10;
            case 2: return 20;
            default: return 0; 
        }
    }
    
    @Override
    public void specialSkill1(Enemy enemy) {
        useMana(10);
        enemy.receiveDamage(10 + attackPower);
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        restoreHealth(20);
        useMana(20);
        enemy.receiveDamage(20);
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        useMana(15);
        setInvisible(true);
        System.out.println("Cinderella is now invisible for one turn.");
    }

    // Check if the character is alive
    public boolean isAlive() {
        return health > 0;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    // Method to be called at the end of each turn to reset invisibility
    public void endTurn() {
        setInvisible(false);
        System.out.println("Cinderella is no longer invisible.");
    }
}
