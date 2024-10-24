
public class Minion extends Enemy {
    public Minion() {
        super("Minion", 100, 20);
    }

    @Override
    public void attack(Character player) {
        System.out.println(Text.centerText(name + " casts a dark spell!"));
        int attackDamage = 20;
        player.receiveDamage(attackDamage);
    }
}

