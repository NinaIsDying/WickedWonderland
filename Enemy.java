
public abstract class Enemy {
    protected String name;
    protected int health;
    private int attackPower;

    public Enemy(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackPower = attackDamage;
    }

    public abstract void attack(Character player);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }
    
    public int getAttackPower() {
        return attackPower;
    }
}

