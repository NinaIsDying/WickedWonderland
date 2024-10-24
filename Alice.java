
public class Alice extends Character {
    
    public Alice() {
        super("Alice", 100, 100);  // Set name, health, and mana
    }

    public static final String ALICE_ATTACKS = 
    "1. Curious Jab\n2. Mad Hat Trick\n3. Wonderland Whirl";

    @Override
    public void specialSkill1(Enemy enemy) {
        System.out.println(Text.centerText("Alice performs a Curious Jab!"));
        useMana(10);
        enemy.receiveDamage(20);  // Damage for skill 1
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        System.out.println(Text.centerText("Alice executes a Mad Hat Trick!"));
        useMana(20);
        enemy.receiveDamage(25);  // Damage for skill 2
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        System.out.println(Text.centerText("Alice spins in a Wonderland Whirl!"));
        useMana(15);
        enemy.receiveDamage(30);  // Damage for skill 3
    }
}
