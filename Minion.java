
public class Minion extends Enemy {
  
    public Minion() {
        super("Minion", 100, 20);
    }


    @Override
    public void attack(Character player) {

            if (player instanceof Cinderella && ((Cinderella) player).isInvisible()) {
                System.out.println(Text.centerText(80, player.getName() + "is invisible! Cannot deal damage!"));
                // No damage is dealt when invisible
            } else {
                System.out.println(Text.centerText(80, name + " attacks with shadow slash!"));
                player.receiveDamage(getAttackPower());
            }
        }
        
  
}

