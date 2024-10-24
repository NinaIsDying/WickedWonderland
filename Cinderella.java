
public class Cinderella extends Character {
    private int attackPower;
    private boolean invisible;

    public Cinderella() {
        super("Cinderella", 200, 100);
        this.invisible = false;
    }

    @Override
    public boolean isInvisible() {
        return invisible;
    }

    @Override
    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    @Override
    public void increaseAttack(int amount) {
        attackPower += amount;
    }


    @Override
    public void specialSkill1(Enemy enemy) {
        System.out.println(Text.centerText(name + " uses Glass Shard Strike!"));
        useMana(10);
        enemy.receiveDamage(10 + attackPower);

    }

    @Override
    public void specialSkill2(Enemy enemy) {
        System.out.println(Text.centerText(name + " uses Enchanted Resilience!"));
        restoreHealth(20);
        useMana(20);
        enemy.receiveDamage(20);
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        System.out.println(Text.centerText(name + " uses Illusionary Escape!"));
        useMana(15);
        setInvisible(true);
    }

    @Override
    public void setHealth(int health) {
        this.health = health;

    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
    

}

