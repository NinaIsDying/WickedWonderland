import java.util.Random;

public class Marionnette extends Enemy {
    private int mana;
    private static final int MAX_MANA = 150;

    public Marionnette() {
        super("Marionette Knight", 350, 70);
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

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " attacks with Shadow Slash!\n "+ name + " deals" + getAttackPower() + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower()+20);
    }

    private void useSecondSkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, name + " uses Puppet's Embrace!\n"+ name + " deals " + (getAttackPower()+5) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 40); // More damage
            mana -= 15;
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Hexed Guard!\n Minion's deals " + (getAttackPower()+10) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 50); // Even more damage
            mana -= 30;
        } else {
            useSecondSkill(player); // Default to second skill if not enough mana
        }
    }
}

