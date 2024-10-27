
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

public class PrinceHenry extends Enemy {

    private int mana;
    private static final int MAX_MANA = 200;

    public PrinceHenry() {
        super("Prince Henry", 400, 90);
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {

        
        Random random = new Random();
        int skillChoice = random.nextInt(3);

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
        System.out.println(Text.centerText(80, name + " attacks with Shattered Vow!\nPrince Henry's attack damage " + getAttackPower() + " to " + player.getName()));
        player.receiveDamage(getAttackPower()+30);
        mana -= 5;
    }

    private void useSecondSkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, name + " uses Royal Dust!\nPrince Henry's attack damage " + (getAttackPower()+5) + " to " + player.getName()));
            player.receiveDamage(getAttackPower() + 45); // More damage
            mana -= 5;
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Madman's Kiss!\nPrince Henry's attack damage " + (getAttackPower()+10) + " to " + player.getName()));
            player.receiveDamage(getAttackPower() + 90); // Even more damage
            mana -= 10;
        } else {
            useSecondSkill(player); // Default to second skill if not enough mana
        }
    }
    
}