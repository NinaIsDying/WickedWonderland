import java.util.Random;

public class JacAndGus extends Enemy {
    private int mana;
    private static final int MAX_MANA = 100;

    public JacAndGus() {
        super("Jaq and Gus", 100, 15);
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
                case 0 -> useFirstSkill(player);
                case 1 -> useSecondSkill(player);
                case 2 -> useThirdSkill(player);
            }
        }
    }

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " distracts you with a clever ruse!\n" + name + " deals " + getAttackPower() + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower());
    }

    private void useSecondSkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, name + " throws a flurry of tiny tools!\n" + name + " deals " + (getAttackPower() + 5) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 15); // More damage
            mana -= 5;
            setMana(mana);
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " sets a trap!\n" + name + " deals " + (getAttackPower() + 10) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 20); // Even more damage
            mana -= 10;
            setMana(mana);
        } else {
            useSecondSkill(player); // Default to second skill if not enough mana
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public static int getMaxMana() {
        return MAX_MANA;
    }
}
