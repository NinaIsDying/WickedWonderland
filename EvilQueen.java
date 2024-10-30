
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

public class EvilQueen extends Enemy {
    
    private int mana;
    private static final int MAX_MANA = 20;
    
    public EvilQueen() {
        super("Evil Queen", 40, 15);
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {

        if (player instanceof Cinderella && ((Cinderella) player).isInvisible()) {
            System.out.println(Text.centerText(80, player.getName() + "is invisible! Cannot deal damage!"));
            // No damage is dealt when invisible
        }
        
        Random random = new Random();
        int skillChoice = random.nextInt(2);

        if (mana == 0) {
            useFirstSkill(player);
        } else {
            switch (skillChoice) {
                case 0 -> useSecondSkill(player);
                case 1 -> useThirdSkill(player);
            }
        }
    }
        
    // add more skills here.
    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " attacks with Black Thorn!\nEvil Queen's attack damage " + getAttackPower() + " to " + player.getName()));
        player.receiveDamage(getAttackPower());
        mana -= 5;
    }

    private void useSecondSkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, name + " uses Mirror's Wrath!\nEvil Queen's attack damage " + (getAttackPower()+5) + " to " + player.getName()));
            player.receiveDamage(getAttackPower() + 5); // More damage
            mana -= 5;
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Dark Heart!\nEvil Queen's attack damage " + (getAttackPower()+10) + " to " + player.getName()));
            player.receiveDamage(getAttackPower() + 10); // Even more damage
            mana -= 10;
        } else {
            useSecondSkill(player); // Default to second skill if not enough mana
        }
    }
    
}
