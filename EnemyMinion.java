

public class EnemyMinion extends Enemy {
   
    public EnemyMinion() {
        super("Enemy Minion", 40, 15);
    
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
    
