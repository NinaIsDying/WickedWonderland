
public class SnowWhite extends Character {
    public SnowWhite() {
        super("Snow White", 200, 100);
    }
    
    public static final String SNOW_WHITE_ATTACKS = 
    "1. Poisoned Apple Strike [Mana cost: 0] [Damage: 10]\n2. Enchanted Healing [Mana cost: 30] [Health +20] [Damage: 20] \n3. Forest's Aid [Mana cost: 50]";

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