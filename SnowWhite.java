
public class SnowWhite extends Character {
    public SnowWhite() {
        super("Snow White", 200, 100);
    }
    
   
    @Override
    public void specialSkill1(Enemy enemy) {
        System.out.println(Text.centerText("Snow White uses Poisoned Apple Strike!"));
        useMana(10);
        enemy.receiveDamage(10);
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        System.out.println(Text.centerText("Snow White uses Enchanted Healing!"));
        restoreHealth(20);
        useMana(20);
        enemy.receiveDamage(20);
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        System.out.println(Text.centerText("Snow White uses Forest's Aid!"));
        useMana(15);
        enemy.receiveDamage(20);
    }

    public void applyPoisonEffect(Enemy enemy) {
        System.out.println(Text.centerText("The poison weakens " + enemy.getName() + " over time!"));
        enemy.receiveDamage(10);
    }
}