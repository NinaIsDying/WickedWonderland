
public class Alice extends Character {
    private int attackPower = 0;
    private final int maxHealth = 400;

    public Alice() {
        super("Alice", 100, 100);  // Set name, health, and mana
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
                case 1: return 30;
                case 2: return 50;
                default: return 0; 
            }
        }
        


    @Override
    public void specialSkill1(Enemy enemy) {
            useMana(15);
            enemy.receiveDamage(30 + attackPower);
        }
    
    @Override
    public void specialSkill2(Enemy enemy) {

            useMana(20);
            enemy.receiveDamage(50);
        }
    
    @Override
    public void specialSkill3(Enemy enemy) {
            useMana(30);
            restoreHealth(20);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
    