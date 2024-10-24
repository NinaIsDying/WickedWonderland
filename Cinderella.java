
public class Cinderella extends Character {
    public Cinderella() {
        super("Cinderella", 200, 100);
    }


    @Override
    public void specialSkill1(Enemy enemy) {
        System.out.println(Text.centerText(name + " uses Glass Shard Strike!"));
        useMana(10);
        enemy.receiveDamage(10);

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
        enemy.receiveDamage(20);


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

