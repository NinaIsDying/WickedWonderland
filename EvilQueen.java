
public class EvilQueen extends Enemy {
    
    public EvilQueen() {
        super("Evil Queen", 40, 15);
    }

    @Override
    public void attack(Character player) {
        System.out.println(Text.centerText(name + " casts a dark spell!"));
        int attackDamage = 20;
        player.receiveDamage(attackDamage);
    }
}