
public class PrinceHenry extends Enemy {

   
    public PrinceHenry() {
        super("Prince Henry", 40, 15);
    }

    @Override
    public void attack(Character player) {
        System.out.println(Text.centerText(name + " attacks with royal fury!"));
        int attackDamage = 15;
        player.receiveDamage(attackDamage);
    }
    
}